package com.jm2dev.rip;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class RipConfiguration extends Configuration {
    private String sample;

    public RipConfiguration() {
    }

    public RipConfiguration(String sample) {
        this.sample = sample;
    }

    @JsonProperty
    public String getSample() {
        return sample;
    }

    @JsonProperty
    public void setSample(String sample) {
        this.sample = sample;
    }
}
