package com.jm2dev.rip;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.jm2dev.rip.health.OrderResourceHealthCheck;
import com.jm2dev.rip.resources.OrderResource;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class RipApplicationTest {
    private final Environment environment = mock(Environment.class);
    private final JerseyEnvironment jersey = mock(JerseyEnvironment.class);
    private final HealthCheckRegistry health = mock(HealthCheckRegistry.class);
    private final RipApplication application = new RipApplication();
    private final RipConfiguration configuration = new RipConfiguration();

    @Before
    public void setup() throws Exception {
        configuration.setSample("Under test");
        when(environment.jersey()).thenReturn(jersey);
        when(environment.healthChecks()).thenReturn(health);
        application.run(configuration, environment);
    }

    //Ignore("swagger registers the resource twice")
    public void buildOrderResource() {
        verify(jersey).register(any(OrderResource.class));
    }

    @Test
    public void buildHealthCheckRegistry() {
        verify(health).register(any(String.class), any(OrderResourceHealthCheck.class));
    }
}
