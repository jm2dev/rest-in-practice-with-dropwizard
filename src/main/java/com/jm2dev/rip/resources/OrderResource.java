package com.jm2dev.rip.resources;

import com.codahale.metrics.annotation.Timed;
import com.jm2dev.rip.core.Order;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
    public OrderResource() {
    }

    @GET
    @Timed
    public Order showOrder() {
        return new Order();
    }
}
