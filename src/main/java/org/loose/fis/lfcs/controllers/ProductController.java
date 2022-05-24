package org.loose.fis.lfcs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.loose.fis.lfcs.model.Product;
import org.loose.fis.lfcs.services.MyListener;

public class ProductController {

    @FXML
    public ImageView productImage;
    @FXML
    public Label productNameLabel;
    @FXML
    public Label productPriceLabel;

    private Product product;
    private MyListener myListener;

    public void setData(Product product, MyListener myListener){
        this.product = product;
        this.myListener = myListener;
        productNameLabel.setText(product.getProductName());
        productPriceLabel.setText("$" + product.getProductPrice());
        Image image = new Image(getClass().getClassLoader().getResourceAsStream(product.getProductImgSrcPath()));
        productImage.setImage(image);
    }

    @FXML
    private void click(MouseEvent mouseEvent){
        myListener.onClickListener(product);

    }
}
