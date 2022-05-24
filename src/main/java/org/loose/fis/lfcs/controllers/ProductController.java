package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.loose.fis.lfcs.model.Product;

public class ProductController {

    @FXML
    public ImageView productImage;
    @FXML
    public Label productNameLabel;
    @FXML
    public Label productPriceLabel;

    private Product product;

    public void setData(Product product){
        this.product = product;
        productNameLabel.setText(product.getProductName());
        productPriceLabel.setText("$" + product.getProductPrice());
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(product.getProductImgSrcPath()));
        productImage.setImage(image);
    }
}
