package com.cassunde.order.service;

import com.cassunde.order.stock.StockFetcher;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class OrderService {

    @Inject
    @RestClient
    StockFetcher stockFetcher;

    @Fallback(fallbackMethod = "verifyStockFallback")
    public String verifyStock(){
        stockFetcher.getStock();
        return "ok";
    }

    public String verifyStockFallback(){
        return "NOk";
    }


}
