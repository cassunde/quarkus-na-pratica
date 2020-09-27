package com.cassunde.order.resource;

import com.cassunde.order.exception.OrderException;
import com.cassunde.order.model.entity.Order;
import com.cassunde.order.model.vo.OrderVO;
import com.cassunde.order.service.OrderService;
import com.cassunde.order.stock.StockFetcher;
import io.quarkus.panache.common.Page;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/orders")
public class OrderResource {

    @Inject
    private OrderService orderService;

    @ConfigProperty(name = "pedidos.page")
    Integer pages;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allOrders(){
        return Response.ok(Order.findAll().list()).build();
    }

    @GET
    @Path("/{client}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listByClient(@PathParam("client") String client, @QueryParam("page") int page){
        return Response.ok(
                Order.find("client", client)
                    .page(Page.of(page,pages))
                    .project(OrderVO.class)
                    .list()
        ).build();
    }

    @DELETE
    @Path("/{id}")
    public void removeOrder(@PathParam("id") ObjectId id){
        Order.deleteById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 3, delay = 1000L)
    public Response createOrder(Order order) throws OrderException, InterruptedException {

        System.out.println("tenta salvar");
        System.out.println(orderService.verifyStock());

        if(Order.find("client = ?1 and product = ?2", order.getClient(), order.getProduct()).count() > 0){
            throw new OrderException("Produto ja cadastrado");
        }

        order.setDateCreation(LocalDate.now());
        order.setPending(true);
        order.persist();
        return Response.ok(order).build();
    }
}
