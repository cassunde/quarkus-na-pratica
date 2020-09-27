package com.cassunde.order.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order extends PanacheMongoEntity {

    private String client;
    private String product;
    private BigDecimal amount;
    private Boolean pending;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateCreation;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }
}
