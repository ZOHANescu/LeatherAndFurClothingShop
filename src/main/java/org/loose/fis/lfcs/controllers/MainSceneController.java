package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainSceneController {

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
    public void initialize(){
        try {   //loaded the icons
            Image truckImg = new Image("icons\\truck.jpg");
            truckIcon.setImage(truckImg);
            truckIcon.setCache(true);

            Image timeImg = new Image("icons\\time.jpg");
            timeIcon.setImage(timeImg);
            timeIcon.setCache(true);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* Button handling */
    public void handleSignOutButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\login-page.fxml")));
        window = (Stage) signOutButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 450));
    }

    public void handleMyOrdersButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\myOrders.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) myOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 850));
    }

    public void handleReceivedOrdersButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\receivedOrders.fxml")));
        window = (Stage) receivedOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 850));
    }


    public void handleAboutUsButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\aboutUsPage.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) aboutUsButton.getScene().getWindow();
        window.setScene(new Scene(root, 800, 500));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
