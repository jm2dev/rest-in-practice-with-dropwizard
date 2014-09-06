package com.jm2dev.rip.resources;

import com.jm2dev.rip.api.Order;
import com.jm2dev.rip.services.OrderService;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderResourceTest {
    private final OrderService service = mock(OrderService.class);
    private final OrderResource resource = new OrderResource(service);
    private final Order mockedOrder = mock(Order.class);

    @Test
    public void returnOrder() {
        when(service.fetchOrder()).thenReturn(mockedOrder);

        Order order = resource.showOrder();
        assertThat(order, is(mockedOrder));
    }
}