package com.jm2dev.rip.api;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class OrderTest {
    private final String location = "location";
    private final Item item = new Item("flat white", 1, "small");
    private final List<Item> items = Arrays.asList(item);
    private final Order order = new Order(location, items);

    @Test
    public void hasLocation() {
        assertThat(order.getLocation(), is(location));
    }

    @Test
    public void hasItems() {
        assertThat(order.getItems().size(), is(not(0)));
    }
}