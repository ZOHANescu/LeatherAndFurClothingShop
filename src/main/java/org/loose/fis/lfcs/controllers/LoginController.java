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
import org.loose.fis.lfcs.exceptions.UserInvalidCredentials;
import org.loose.fis.lfcs.model.User;
import org.loose.fis.lfcs.services.UserService;

import java.io.IOException;
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
    @FXML
    public Label message;


    @FXML
    public void handleLoginAction() throws IOException {

        User user;

        try{
            user = UserService.verifyCredentials(usernameField.getText(), passwordField.getText());
            if(user != null){
                if(user.getRole().equals("Customer")){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\mainScreen.fxml")));
                    Stage window = (Stage) registerButton.getScene().getWindow();
                    window.setScene(new Scene(root, 600, 450));
                } else if(user.getRole().equals("Admin")){
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\adminMainScreen.fxml")));
                    Stage window = (Stage) registerButton.getScene().getWindow();
                    window.setScene(new Scene(root, 600, 450));
                }
            }
        }catch(UserInvalidCredentials e){
            message.setText(e.getMessage());
        }
    }

    @FXML
    public void loadRegisterPageButton() throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\register.fxml")));
        Stage window = (Stage) registerButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 450));
        //changeSceneButton(registerButton, "fxml-scenes\\register.fxml", 600, 450);
    }
}
