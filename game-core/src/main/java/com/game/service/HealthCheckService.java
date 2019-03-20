package com.game.service;

import com.codahale.metrics.health.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

/**
 * This is hypothetical health check service.
 */
public class HealthCheckService {

    public static final Logger LOG = LoggerFactory.getLogger(HealthCheckService.class);

    /**
     * Health check registry names getter.
     * @return new registry.
     */
    public Set<String> getHealthCheckRegistryNames() {
        return new HashSet<>();
    }

    /**
     * Can actually do a real health check call to the remote server.
     * @param serviceName a service to check.
     * @return health check result.
     */
    public HealthCheck.Result runHealthCheck(String serviceName) {
        LOG.debug("We need this {}", serviceName);
        return null;
    }
}
