package com.jm2dev.rip.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static io.dropwizard.testing.FixtureHelpers.*;
import org.skyscreamer.jsonassert.JSONAssert;

public class OrderTest {
    private final String LOCATION = "location";
    private final Item ITEM = new Item("flat white", 1, "small");
    private final List<Item> ITEMS = Arrays.asList(ITEM);
    private final Order ORDER = new Order(LOCATION, ITEMS);
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void hasLocation() {
        assertThat(ORDER.getLocation(), is(LOCATION));
    }

    @Test
    public void hasItems() {
        assertThat(ORDER.getItems().size(), is(not(0)));
    }

    @Test
    public void jsonSerialization() throws Exception {
        JSONAssert.assertEquals(MAPPER.writeValueAsString(ORDER), fixture("fixtures/order.json"), false);
    }

    @Test
    public void deserializationFromJson() throws IOException {
        assertThat(MAPPER.readValue(fixture("fixtures/order.json"), Order.class), is(ORDER));
    }

}