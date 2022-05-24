package org.loose.fis.lfcs.services;

import org.loose.fis.lfcs.model.Product;

import java.util.ArrayList;
import java.util.List;

public class LoadProductsService {
    public static List<Product> getData(){
        List<Product> productList = new ArrayList<>();
        Product product;

        product = new Product();
        product.setProductName("Men's Biker");
        product.setProductPrice(550);
        product.setProductImgSrcPath("products\\mens-biker.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Vivi Jacket");
        product.setProductPrice(550);
        product.setProductImgSrcPath("products\\geaca-vivi.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Paloma Coat");
        product.setProductPrice(800);
        product.setProductImgSrcPath("products\\pardesiu-paloma.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Aviator Jacket");
        product.setProductPrice(850);
        product.setProductImgSrcPath("products\\womens-aviator.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Ada Jacket");
        product.setProductPrice(600);
        product.setProductImgSrcPath("products\\jacheta-ada.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Alin Coat");
        product.setProductPrice(1200);
        product.setProductImgSrcPath("products\\cojoc-alin.jpg");
        productList.add(product);

        return productList;
    }
}
