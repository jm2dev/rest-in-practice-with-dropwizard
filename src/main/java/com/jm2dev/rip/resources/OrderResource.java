package com.jm2dev.rip.resources;

import com.codahale.metrics.annotation.Timed;
import com.jm2dev.rip.api.Order;
import com.jm2dev.rip.services.OrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
}
