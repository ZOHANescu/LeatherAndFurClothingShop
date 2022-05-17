package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainSceneController {

    @FXML
    public Button signOutButton;
    @FXML
    public Button myOrdersButton;

    @FXML
    public void initialize(){

    }

    public void handleSignOutButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\login-page.fxml")));
        Stage window = (Stage) signOutButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 450));
    }

    public void handleMyOrdersButton() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\myOrders.fxml")));
        Stage window = (Stage) myOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1200, 850));
    }
}
