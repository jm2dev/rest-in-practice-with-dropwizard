package com.jm2dev.rip.api;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    private final String coffeeName = "flat white";
    private final int quantity = 1;
    private final String size = "small";
    private final Item item = new Item(coffeeName, quantity, size);

    @Test
    public void hasName() {
        assertThat(item.getName(), is(coffeeName));
    }

    @Test
    public void hasQuantity() {
        assertThat(item.getQuantity(), is(quantity));
    }

    @Test
    public void hasSize() {
        assertThat(item.getSize(), is(size));
    }
}