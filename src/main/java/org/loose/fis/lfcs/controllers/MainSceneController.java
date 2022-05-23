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

public class MainSceneController implements Initializable {

    @FXML
    public Button signOutButton;
    @FXML
    public Button myOrdersButton;
    @FXML
    public Button receivedOrdersButton;
    @FXML
    public Button aboutUsButton;
    @FXML
    public ImageView truckIcon;
    @FXML
    public VBox chosenProdCard;
    @FXML
    public Label prodNameLabel;
    @FXML
    public Label prodPriceLabel;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public GridPane productContainer;
    @FXML
    public Button addProdButton;
    @FXML
    public ImageView displayedImage;
    @FXML
    public Button homeButton;
    @FXML
    public Button viewProductButton;
    @FXML
    public Label welcomeMessage;

    private Parent root;
    private Stage window;

    private List<Product> productList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {   //loaded the icons
            Image image1 = new Image("products\\cojoc-sonia.jpg");
            displayedImage.setImage(image1);
            displayedImage.setCache(true);

            Image image2 = new Image("icons\\truck.jpg");
            truckIcon.setImage(image2);
            truckIcon.setCache(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        productList = new ArrayList<>(products());
//
//        int column = 0;
//        int row = 1;
//
//        try{
//            for(Product prod : productList){
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getClassLoader().getResource("fxml-scenes\\product.fxml"));
//                VBox prodBox = fxmlLoader.load();
//                ProductController productController = fxmlLoader.getController();
//                productController.setData(prod);
//
//                System.out.println(prod.getProductName());
//                System.out.println(prod.getProductPrice() + '\n');
//
//                if(column == 3){
//                    column = 0;
//                    ++row;
//                }
//
//                productContainer.add(prodBox, column++, row);
//                GridPane.setMargin(prodBox, new Insets(10));
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }

    private List<Product> products(){

        List<Product> ls = new ArrayList<>();

        Product product = new Product();

        product.setProductName("Cojocel Femei");
        product.setProductPrice(750.5);
        product.setProductImgSrcPath("products\\leather1.JPG");
        ls.add(product);

        product.setProductName("Leather Mirela");
        product.setProductPrice(500);
        product.setProductImgSrcPath("products\\leather2.JPG");
        ls.add(product);

        product.setProductName("Amber Skin");
        product.setProductPrice(350);
        product.setProductImgSrcPath("products\\leather3.JPG");
        ls.add(product);

        return ls;
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

    public void handleMyOrdersButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\myOrders.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) myOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1440, 850));
        CenterSceneService.centerPage(window);
    }

    public void handleReceivedOrdersButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\receivedOrders.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) receivedOrdersButton.getScene().getWindow();
        window.setScene(new Scene(root, 1440, 850));
        CenterSceneService.centerPage(window);
    }

    public void handleAboutUsButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\aboutUsPage.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) aboutUsButton.getScene().getWindow();
        window.setScene(new Scene(root, 800, 500));
        CenterSceneService.centerPage(window);
    }

    public void handleAddProductButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\addProduct.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) addProdButton.getScene().getWindow();
        window.setScene(new Scene(root, 700, 850));
        CenterSceneService.centerPage(window);
    }

    public void handleHomeButton(){
        prodNameLabel.setText("");
        prodPriceLabel.setText("");
        viewProductButton.setVisible(false);

        welcomeMessage.setText("Welcome!");
        welcomeMessage.setFont(Font.font("cambria", FontWeight.BOLD, FontPosture.ITALIC, 24));
        welcomeMessage.setTextFill(Color.rgb(184, 134, 11));

        try {
            Image welcomeImage = new Image("icons\\bigLeatherSign.png");
            displayedImage.setImage(welcomeImage);
            displayedImage.setCache(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
