package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.loose.fis.lfcs.services.CenterSceneService;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ViewProductDetailedController implements Initializable {

    @FXML
    public Button backButtonView;
    @FXML
    public Button orderButton;
    @FXML
    public ImageView productImageDetailed;
    @FXML
    public Label productNameDetailed;
    @FXML
    public Label productPriceDetailed;

    private Parent root;
    private Stage window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.productNameDetailed.setText("");
        this.productPriceDetailed.setText("");
    }

    public void handleBackButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\customerMainScreen.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) backButtonView.getScene().getWindow();
        window.setScene(new Scene(root, 1440, 850));
        CenterSceneService.centerPage(window);
    }
}