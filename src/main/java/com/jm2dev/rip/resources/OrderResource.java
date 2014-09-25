package com.jm2dev.rip.resources;

import com.codahale.metrics.annotation.Timed;
import com.jm2dev.rip.api.Order;
import com.jm2dev.rip.services.OrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Api("/order")
@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
    private OrderService service;

    public OrderResource(OrderService service) {
        this.service = service;
    }

    @ApiOperation("GET order")
    @GET
    @Timed
    public Order showOrder() {
        final Order flatWhiteOrder = service.fetchOrder();

        return flatWhiteOrder;
    }

    @ApiOperation("POST order")
    @POST
    @Timed
    @Consumes(MediaType.APPLICATION_JSON)
    public Response submitOrder(Order order) {
        try {
            return Response.created(new URI("uri:order")).build();
        } catch (URISyntaxException e) {
//            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
