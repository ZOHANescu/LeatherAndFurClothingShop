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
        product.setProductPrice(750);
        product.setProductImgSrcPath("products\\womens-aviator.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Ada Jacket");
        product.setProductPrice(450);
        product.setProductImgSrcPath("products\\jacheta-ada.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Alin Coat");
        product.setProductPrice(1200);
        product.setProductImgSrcPath("products\\cojoc-alin.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Andrei Coat");
        product.setProductPrice(970);
        product.setProductImgSrcPath("products\\cojoc-andrei.jpg");
        productList.add(product);

        product = new Product();
        product.setProductName("Mira Coat");
        product.setProductPrice(1100);
        product.setProductImgSrcPath("products\\cojoc-mira.png");
        productList.add(product);

        product = new Product();
        product.setProductName("Vali Coat");
        product.setProductPrice(1000);
        product.setProductImgSrcPath("products\\cojoc-vali.png");
        productList.add(product);

        product = new Product();
        product.setProductName("Gina Jacket");
        product.setProductPrice(450);
        product.setProductImgSrcPath("products\\jacheta-gina.png");
        productList.add(product);

        product = new Product();
        product.setProductName("Tania Jacket");
        product.setProductPrice(450);
        product.setProductImgSrcPath("products\\haina-tania.png");
        productList.add(product);

        return productList;
    }
}
