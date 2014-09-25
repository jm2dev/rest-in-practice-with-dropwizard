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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (quantity != item.quantity) return false;
        if (!name.equals(item.name)) return false;
        if (!size.equals(item.size)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + size.hashCode();
        return result;
    }
}
