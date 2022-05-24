package org.loose.fis.lfcs.model;

import lombok.Getter;
import lombok.Setter;

public class Product {

    private String productName;
    private double productPrice;
    private String productImgSrcPath;

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductImgSrcPath() {
        return productImgSrcPath;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImgSrcPath(String productImgSrcPath) {
        this.productImgSrcPath = productImgSrcPath;
    }
}
