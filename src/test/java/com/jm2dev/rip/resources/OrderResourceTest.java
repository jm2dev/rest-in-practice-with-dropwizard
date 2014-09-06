package com.jm2dev.rip.resources;

import com.jm2dev.rip.api.Item;
import com.jm2dev.rip.api.Order;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderResourceTest {
    private final Item flatWhite = new Item("flat white", 1, "small");
    private final List<Item> items = Arrays.asList(flatWhite);
    private final Order flatWhiteOrder = new Order("take away", items);;

    @Ignore("service to return orders not implemented")
    public void returnOrder() {
        OrderResource resource = new OrderResource();
        Order order = resource.showOrder();
        assertThat(order, is(flatWhiteOrder));
    }
}