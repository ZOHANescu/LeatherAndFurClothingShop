package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.loose.fis.lfcs.exceptions.UserInvalidCredentials;
import org.loose.fis.lfcs.model.User;
import org.loose.fis.lfcs.services.CenterSceneService;
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
    public ImageView userImg;
    @FXML
    public ImageView lockImg;

    private Parent root;
    private Stage window;

    @FXML
    public void initialize(){
        try {   //loaded the icons
            Image image1 = new Image("icons\\user.png");
            userImg.setImage(image1);
            userImg.setCache(true);

            Image image2 = new Image("icons\\lock.png");
            lockImg.setImage(image2);
            lockImg.setCache(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void handleLoginAction() throws IOException {

        User user;

        try{
            user = UserService.verifyCredentials(usernameField.getText(), passwordField.getText());
            if(user != null){
                if(user.getRole().equals("Customer")){
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\customerMainScreen.fxml")));
                    root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
                    window = (Stage) registerButton.getScene().getWindow();
                    window.setScene(new Scene(root, 1440, 850));
                    CenterSceneService.centerPage(window);
                } else if(user.getRole().equals("Admin")){
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\adminMainScreen.fxml")));
                    root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
                    window = (Stage) registerButton.getScene().getWindow();
                    window.setScene(new Scene(root, 1440, 850));
                    CenterSceneService.centerPage(window);
                }
            }
        }catch(UserInvalidCredentials e){
            message.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
            message.setTextFill(Color.RED);
            message.setText(e.getMessage());
        }
    }

    @FXML
    public void loadRegisterPageButton() throws Exception {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\register.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) registerButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 450));
    }
}
