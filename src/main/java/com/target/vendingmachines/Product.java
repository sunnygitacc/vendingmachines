package com.target.vendingmachines;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class Product {
    ProductType productType;
    int price;

    public Product(ProductType productType, int price) {
        this.productType = productType;
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
