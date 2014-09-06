package com.jm2dev.rip;

import com.jm2dev.rip.health.OrderResourceHealthCheck;
import com.jm2dev.rip.resources.OrderResource;
import com.jm2dev.rip.services.OrderService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RipApplication extends Application<RipConfiguration> {
    public static void main(String[] args) throws Exception {
        new RipApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<RipConfiguration> bootstrap) {

    }

    @Override
    public void run(RipConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(new OrderResource(new OrderService()));
        environment.healthChecks().register("order resource", new OrderResourceHealthCheck());
    }
}
