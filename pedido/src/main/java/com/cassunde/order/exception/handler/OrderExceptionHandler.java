package com.cassunde.order.exception.handler;


import com.cassunde.order.exception.OrderException;
import com.cassunde.order.model.vo.ErrorDefault;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OrderExceptionHandler implements ExceptionMapper<OrderException> {

    @Override
    public Response toResponse(OrderException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorDefault(e.getMessage(),"2020")).build();
    }
}
