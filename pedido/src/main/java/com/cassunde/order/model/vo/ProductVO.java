package com.cassunde.order.model.vo;

public class ProductVO {

    private String product;
    private boolean enable;

    public ProductVO(String product, boolean enable) {
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

    @Override
    public String toString() {
        return "ProductVO{" +
                "product='" + product + '\'' +
                ", enable=" + enable +
                '}';
    }
}
