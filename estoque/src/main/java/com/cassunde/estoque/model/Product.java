package com.cassunde.estoque.model;

public class Product {

    private String product;
    private boolean enable;

    public Product(String product, boolean enable) {
        this.product = product;
        this.enable = enable;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
