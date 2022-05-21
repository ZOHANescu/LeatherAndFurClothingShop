package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.loose.fis.lfcs.model.Product;
import org.loose.fis.lfcs.services.CenterSceneService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainSceneController{

    @FXML
    public Button signOutButton;
    @FXML
    public Button myOrdersButton;
    @FXML
    public Button receivedOrdersButton;
    @FXML
    public Button aboutUsButton;
    @FXML
    public ImageView timeIcon;
    @FXML
    public ImageView truckIcon;

    private Parent root;
    private Stage window;


    @FXML
    public void initialize() {

        try {   //loaded the icons
            Image truckImg = new Image("icons\\truck.jpg");
            truckIcon.setImage(truckImg);
            truckIcon.setCache(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* Button handling */
    public void handleSignOutButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\login-page.fxml")));
        window = (Stage) signOutButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 450));
        CenterSceneService.centerPage(window);
    }

    public void handleMyOrdersButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\myOrders.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) myOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1440, 850));
        CenterSceneService.centerPage(window);
    }

    public void handleReceivedOrdersButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\receivedOrders.fxml")));
        window = (Stage) receivedOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1440, 850));
        CenterSceneService.centerPage(window);
    }


    public void handleAboutUsButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\aboutUsPage.fxml")));
        window = (Stage) aboutUsButton.getScene().getWindow();
        window.setScene(new Scene(root, 800, 500));
        CenterSceneService.centerPage(window);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
