package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
    public ImageView prodImage;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public GridPane productContainer;
    @FXML
    public Button addProdButton;

    private Parent root;
    private Stage window;

    private List<Product> productList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {   //loaded the icons
            Image truckImg = new Image("icons\\truck.jpg");
            truckIcon.setImage(truckImg);
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

    public void handleAddProductButton() throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\addProduct.fxml")));
        window = (Stage) addProdButton.getScene().getWindow();
        window.setScene(new Scene(root, 800, 500));
        CenterSceneService.centerPage(window);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
