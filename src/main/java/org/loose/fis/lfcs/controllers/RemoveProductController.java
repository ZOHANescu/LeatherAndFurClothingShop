package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.loose.fis.lfcs.model.Product;
import org.loose.fis.lfcs.services.LoadProductsService;


public class RemoveProductController implements Initializable {

private List<Product> productList=new ArrayList();
    public GridPane grid;
    public ScrollPane scroll;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        productList = LoadProductsService.getData();





        int column = 0;
        int row = 1;

        try {
            for (Product product : productList) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getClassLoader().getResource("fxml-scenes\\product.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ProductController productController = fxmlLoader.getController();
               // productController.setData(product, myListener);

                if (column == 3) {
                    column = 0;
                    ++row;
                }

                grid.add(anchorPane, column++, row);

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

