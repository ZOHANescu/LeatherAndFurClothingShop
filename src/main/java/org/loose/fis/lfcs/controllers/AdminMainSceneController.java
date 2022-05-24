package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.loose.fis.lfcs.model.Product;
import org.loose.fis.lfcs.services.CenterSceneService;
import org.loose.fis.lfcs.services.LoadProductsService;

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
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public GridPane productContainer;
    @FXML
    public Button removeProdButton;

    private Parent root;
    private Stage window;
    private List<Product> productList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {   //loaded the icons
            Image image = new Image("icons\\bigLeatherSign.png");
            displayedImage.setImage(image);
            displayedImage.setCache(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        productList = LoadProductsService.getData();

        int column = 0;
        int row = 1;

        try {
            for (Product product : productList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getClassLoader().getResource("fxml-scenes\\product.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ProductController productController = fxmlLoader.getController();
                productController.setDataNoListener(product);

                if (column == 3) {
                    column = 0;
                    ++row;
                }

                productContainer.add(anchorPane, column++, row);

                //set grid width
                productContainer.setMinWidth(Region.USE_COMPUTED_SIZE);
                productContainer.setPrefWidth(Region.USE_COMPUTED_SIZE);
                productContainer.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                productContainer.setMinHeight(Region.USE_COMPUTED_SIZE);
                productContainer.setPrefHeight(Region.USE_COMPUTED_SIZE);
                productContainer.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }catch(IOException e){
            e.printStackTrace();
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
    public void handleRemoveProdButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\removeProduct.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) removeProdButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 850));
        CenterSceneService.centerPage(window);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}