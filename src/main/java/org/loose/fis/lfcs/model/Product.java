package org.loose.fis.lfcs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String productName;
    private int productPrice;
    private String productDescription;

    public Product(String productName, int productPrice, String productDescription) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }
}
