package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MyOrdersController {

    @FXML
    public Button backButton;

    private Parent root;
    private Stage window;

    @FXML
    public void initialize(){}

    public void handleBackButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\customerMainScreen.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1440, 850));
    }
}
