package com.jm2dev.rip.services;

import com.jm2dev.rip.api.Item;
import com.jm2dev.rip.api.Order;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderService {

    public Order fetchOrder() {
        String location = "location";
        Item item = new Item("capuccino", 1, "small");
        List<Item> items = Stream.of(item).collect(Collectors.toList());
        return new Order(location, items);
    }
}
