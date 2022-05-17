package org.loose.fis.lfcs.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String productName;
    private double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
