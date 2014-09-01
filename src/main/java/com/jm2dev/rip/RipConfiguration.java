package com.jm2dev.rip;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class RipConfiguration extends Configuration {
    @NotEmpty
    private String sample;

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
