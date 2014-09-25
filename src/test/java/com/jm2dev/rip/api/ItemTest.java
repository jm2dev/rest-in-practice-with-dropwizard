package com.jm2dev.rip.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static io.dropwizard.testing.FixtureHelpers.*;
import org.skyscreamer.jsonassert.JSONAssert;

public class ItemTest {
    private final String coffeeName = "flat white";
    private final int quantity = 1;
    private final String size = "small";
    private final Item ITEM = new Item(coffeeName, quantity, size);

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void hasName() {
        assertThat(ITEM.getName(), is(coffeeName));
    }

    @Test
    public void hasQuantity() {
        assertThat(ITEM.getQuantity(), is(quantity));
    }

    @Test
    public void hasSize() {
        assertThat(ITEM.getSize(), is(size));
    }

    @Test
    public void jsonSerialization() throws Exception {
        JSONAssert.assertEquals(MAPPER.writeValueAsString(ITEM), fixture("fixtures/item.json"), false);
    }

    @Test
    public void deserializationFromJson() throws IOException {
        assertThat(MAPPER.readValue(fixture("fixtures/item.json"), Item.class), is(ITEM));
    }
}