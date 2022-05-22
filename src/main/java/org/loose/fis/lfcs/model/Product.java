package org.loose.fis.lfcs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String productName;
    private double productPrice;
    private String productImgSrcPath;
    //private String productDescription;

//    public Product(String productName, double productPrice, String productDescription, String productImgSrcPath) {
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.productDescription = productDescription;
//        this.productImgSrcPath = productImgSrcPath;
//    }
}
