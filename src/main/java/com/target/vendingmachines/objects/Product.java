package com.target.vendingmachines.objects;

/**
 * Created by Sunil Kata on 7/14/2017.
 */
public class Product {
    ProductType productType;
    int price;
    String productId;

    public Product(String productId, ProductType productType, int price) {
        this.productId = productId;
        this.productType = productType;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
