package com.jm2dev.rip.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private final String name;
    private final int quantity;
    private final String size;

    @JsonCreator
    public Item(@JsonProperty("name") String name,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("size") String size) {
        this.name = name;
        this.quantity = quantity;
        this.size = size;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("quantity")
    public int getQuantity() {
        return quantity;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }
}
