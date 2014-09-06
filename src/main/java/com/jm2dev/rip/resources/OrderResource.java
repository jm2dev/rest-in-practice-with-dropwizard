package com.jm2dev.rip.resources;

import com.codahale.metrics.annotation.Timed;
import com.jm2dev.rip.api.Item;
import com.jm2dev.rip.api.Order;
import com.jm2dev.rip.services.OrderService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/order")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
    private OrderService service;

    public OrderResource(OrderService service) {
        this.service = service;
    }

    @GET
    @Timed
    public Order showOrder() {
        final Item flatWhite = new Item("flat white", 1, "small");
        final List<Item> items = Arrays.asList(flatWhite);
        final Order flatWhiteOrder = new Order("take away", items);;

        return flatWhiteOrder;
    }
}
