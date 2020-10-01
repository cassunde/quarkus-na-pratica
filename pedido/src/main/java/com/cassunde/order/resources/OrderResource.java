package com.cassunde.order.resources;

import com.cassunde.order.exception.OrderException;
import com.cassunde.order.fetch.StockFetch;
import com.cassunde.order.model.Order;
import com.cassunde.order.model.vo.OrderVO;
import com.cassunde.order.model.vo.ProductVO;
import com.cassunde.order.services.StockServices;
import io.quarkus.panache.common.Page;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/order")
public class OrderResource {

    @Inject
    private StockServices stockServices;

    @ConfigProperty(name = "order.pages")
    private int pages;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){

        ProductVO stock = stockServices.getStock();
        System.out.println(stock);

        return Response.ok(Order.findAll().list()).build();
    }

    @GET
    @Path("/{client}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByClient(@PathParam("client") String client, @QueryParam("page") int page){
        return Response.ok(
                Order.find("client", client)
                    .page(Page.of(page, pages))
                    .project(OrderVO.class)
                    .list()
        ).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Order order) throws OrderException {

        if(Order.find("client = ?1 and product = ?2",order.getClient(), order.getProduct()).count() > 0){
            throw new OrderException("Product already registered");
        }

        ProductVO stock = stockServices.getStock();
        System.out.println(stock);

        order.setDateCreation(LocalDate.now());
        order.persist();
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") ObjectId id){
        Order.deleteById(id);
        return Response.ok().build();
    }
}
