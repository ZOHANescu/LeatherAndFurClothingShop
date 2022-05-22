package org.loose.fis.lfcs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.loose.fis.lfcs.services.FileSystemService;
import org.loose.fis.lfcs.services.UserService;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        initDirectory();
        UserService.initDatabase();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\login-page.fxml")));
        primaryStage.setTitle("Leather and Fur Clothing Shop");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
