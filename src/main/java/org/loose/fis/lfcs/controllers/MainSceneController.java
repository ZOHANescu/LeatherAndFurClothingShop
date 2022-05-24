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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.loose.fis.lfcs.model.Product;
import org.loose.fis.lfcs.services.CenterSceneService;
import org.loose.fis.lfcs.services.LoadProductsService;
import org.loose.fis.lfcs.services.MyListener;

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
    public Button aboutUsButton;
    @FXML
    public ImageView truckIcon;
    @FXML
    public VBox chosenProdCard;
    @FXML
    public ScrollPane scrollPane;
    @FXML
    public GridPane productContainer;
    @FXML
    public Button homeButton;
    @FXML
    public Button viewProductButton;
    @FXML
    public Label welcomeMessage;
    @FXML
    public Label prodNameLabelCard;
    @FXML
    public Label prodPriceLabelCard;
    @FXML
    public ImageView displayedImageCard;

    private Parent root;
    private Stage window;
    private List<Product> productList = new ArrayList<>();
    private MyListener myListener;
    private Image image;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.prodNameLabelCard.setText("");
        this.prodPriceLabelCard.setText("");
        viewProductButton.setVisible(false);
        welcomeMessage.setText("Welcome!");
        welcomeMessage.setFont(Font.font("cambria", FontWeight.BOLD, FontPosture.ITALIC, 36));
        welcomeMessage.setTextFill(Color.rgb(184, 134, 11));

        try {   //loaded the icons
            Image image1 = new Image("icons\\bigLeatherSign.png");
            displayedImageCard.setImage(image1);
            displayedImageCard.setCache(true);

            Image image2 = new Image("icons\\truck.jpg");
            truckIcon.setImage(image2);
            truckIcon.setCache(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ///////////////////////////////////////////////////

        productList = LoadProductsService.getData();

        if(productList.size() > 0){
            setChosenProdCard(productList.get(0));
            welcomeMessage.setText("");
            viewProductButton.setVisible(true);
            myListener = new MyListener() {
                @Override
                public void onClickListener(Product product) {
                    setChosenProdCard(product);
                    welcomeMessage.setText("");
                    viewProductButton.setVisible(true);
                }
            };
        }

        int column = 0;
        int row = 1;

        try {
            for (Product product : productList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getClassLoader().getResource("fxml-scenes\\product.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ProductController productController = fxmlLoader.getController();
                productController.setData(product, myListener);

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

    private void setChosenProdCard(Product product){
        prodNameLabelCard.setText(product.getProductName());
        prodPriceLabelCard.setText("$" + product.getProductPrice());
        image = new Image(getClass().getClassLoader().getResourceAsStream(product.getProductImgSrcPath()));
        displayedImageCard.setImage(image);
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

    public void handleAboutUsButton() throws IOException{
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("fxml-scenes\\aboutUsPage.fxml")));
        root.getStylesheets().add(getClass().getClassLoader().getResource("cssStyles\\clientPageStyle.css").toString());
        window = (Stage) aboutUsButton.getScene().getWindow();
        window.setScene(new Scene(root, 800, 500));
        CenterSceneService.centerPage(window);
    }

    public void handleHomeButton(){
        prodNameLabelCard.setText("");
        prodPriceLabelCard.setText("");
        viewProductButton.setVisible(false);

        welcomeMessage.setText("Welcome!");
        welcomeMessage.setFont(Font.font("cambria", FontWeight.BOLD, FontPosture.ITALIC, 36));
        welcomeMessage.setTextFill(Color.rgb(184, 134, 11));

        try {
            Image welcomeImage = new Image("icons\\bigLeatherSign.png");
            displayedImageCard.setImage(welcomeImage);
            displayedImageCard.setCache(true);
            displayedImageCard.setFitWidth(300);
            displayedImageCard.setFitHeight(400);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}