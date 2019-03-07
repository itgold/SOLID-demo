package com.mortalcombat.service;

import com.codahale.metrics.health.HealthCheck;
import com.mortalcombat.MortalCombat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HealthCheckService {

    public static final Logger LOG = LoggerFactory.getLogger(HealthCheckService.class);

    public Set<String> getHealthCheckRegistryNames() {
        return new HashSet<>();
    }

    public HealthCheck.Result runHealthCheck(String serviceName) {

        return null;
    }
}
