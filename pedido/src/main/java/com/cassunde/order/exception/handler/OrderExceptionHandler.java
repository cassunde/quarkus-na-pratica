package com.cassunde.order.exception.handler;

import com.cassunde.order.exception.ErrorDefault;
import com.cassunde.order.exception.OrderException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OrderExceptionHandler implements ExceptionMapper<OrderException> {

    @Override
    public Response toResponse(OrderException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorDefault(exception.getMessage(),"001")).build();
    }
}
