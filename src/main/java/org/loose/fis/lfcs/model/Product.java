package org.loose.fis.lfcs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String productName;
    private double productPrice;
    private String productDescription;
    private String productSrcPath;

    public Product(String productName, double productPrice, String productDescription, String productSrcPath) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productSrcPath = productSrcPath;
    }
}
