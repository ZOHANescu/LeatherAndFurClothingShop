package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.loose.fis.lfcs.model.Product;
import org.loose.fis.lfcs.services.CenterSceneService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminMainSceneController implements Initializable {

    @FXML
    public Button signOutButton;
    @FXML
    public Button receivedOrdersButton;
    @FXML
    public Button addProdButton;
    @FXML
    public ImageView displayedImage;

    private Parent root;
    private Stage window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        {
            try {   //loaded the icons
                Image image = new Image("icons\\bigLeatherSign.png");
                displayedImage.setImage(image);
                displayedImage.setCache(true);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* Button handling */

    public void handleSignOutButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\login-page.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) signOutButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 450));
        CenterSceneService.centerPage(window);
    }

    public void handleReceivedOrdersButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\receivedOrders.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) receivedOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1440, 850));
        CenterSceneService.centerPage(window);
    }

    public void handleAddProductButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\addProduct.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) addProdButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 850));
        CenterSceneService.centerPage(window);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}