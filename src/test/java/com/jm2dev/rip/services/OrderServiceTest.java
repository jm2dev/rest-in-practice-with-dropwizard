package com.jm2dev.rip.services;

import com.jm2dev.rip.api.Order;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class OrderServiceTest {
    @Test
    public void returnOrder() {
        OrderService service = new OrderService();
        Order order = service.fetchOrder();

        assertThat("Returned order is not null", order, is(notNullValue()));
    }
}