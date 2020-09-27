package com.cassunde.order.model.vo;

import com.cassunde.order.model.entity.Order;
import io.quarkus.mongodb.panache.ProjectionFor;

import java.math.BigDecimal;

@ProjectionFor(Order.class)
public class OrderVO {
    public String client;
    public String product;
    public BigDecimal amount;
    public Boolean pending;
}
