package com.mortalcombat.service;

import com.codahale.metrics.health.HealthCheck;

import java.util.HashSet;
import java.util.Set;

public class HealthCheckService {

    public Set<String> getHealthCheckRegistryNames() {
        return new HashSet<>();
    }

    public HealthCheck.Result runHealthCheck(String serviceName) {
        return null;
    }
}
