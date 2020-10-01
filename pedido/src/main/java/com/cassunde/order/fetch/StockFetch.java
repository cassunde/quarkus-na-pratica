package com.cassunde.order.fetch;

import com.cassunde.order.model.vo.ProductVO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/stock")
@RegisterRestClient(baseUri = "http://localhost:8081")
public interface StockFetch {

    @GET
    ProductVO getStock();

}
