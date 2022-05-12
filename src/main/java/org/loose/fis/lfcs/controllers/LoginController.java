package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Objects;

public class LoginController {

    @FXML
    public Button registerButton;
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Label title;
    @FXML
    public Button loginButton;

    private int count = 1;

    @FXML
    public void handleLoginMessage() {
        title.setText("Clicked " + this.count + " times!");
        this.count++;
    }

    @FXML
    public void loadRegisterPageButton() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\register.fxml")));
        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 300));
    }
}
