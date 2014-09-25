package com.jm2dev.rip.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class Order {
    @NotEmpty
    private final String location;
    @NotEmpty
    private final List<Item> items;

    @JsonCreator
    public Order(@JsonProperty("location") String location, @JsonProperty("items") List<Item> items) {
        this.location = location;
        this.items = items;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!items.equals(order.items)) return false;
        if (!location.equals(order.location)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = location.hashCode();
        result = 31 * result + items.hashCode();
        return result;
    }
}
