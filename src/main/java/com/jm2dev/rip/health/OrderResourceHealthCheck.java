package com.jm2dev.rip.health;

import com.codahale.metrics.health.HealthCheck;

public class OrderResourceHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
