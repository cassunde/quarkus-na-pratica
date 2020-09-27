package com.cassunde.order.stock;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/stock")
@RegisterRestClient(baseUri = "http://localhost:8081/")
public interface StockFetcher {

    @GET
    void getStock();

}
