package com.mortalcombat;

import com.mortalcombat.model.Enemy;
import com.mortalcombat.model.Hero;
import com.mortalcombat.service.HealthCheckService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

import static com.codahale.metrics.health.HealthCheck.Result;

public class MortalCombat {

    public static final Logger LOG = LoggerFactory.getLogger(MortalCombat.class);

    public static void main(String[] args) {

        MortalCombat game = new MortalCombat();
        game.initialize();

        Hero hero = game.deserializeHero();
        Enemy enemy = game.loadEnemy();

        Result check = game.check();
        if (check.isHealthy()) {
            LOG.info("Let the fight begin!");
            LOG.info("|o-------o|o-------o|");
            LOG.info("|o Hero  o|o Enemy o|");

            while (true) {
                hero.attack(enemy);
                if (!enemy.isAlive()) {
                    break;
                }

                enemy.attack(hero);
                if (!hero.isAlive()) {
                    break;
                }
            }
            logFightEnd(hero, enemy);

            LOG.info(hero.toString());
            LOG.info(enemy.toString());

            serializeHero(hero);
        }

    }

    private static void logFightEnd(Hero hero, Enemy enemy) {
        LOG.info("|o_______o|o_______o|");

        if (!enemy.isAlive()) {
            LOG.info("Hero won!");
        } else if (!hero.isAlive()) {
            LOG.info("Enemy wins :(");
        } else {
            LOG.info("It is a tie");
        }
    }

    protected Result check() {
        boolean healthCheck = true;

        try {
            HealthCheckService healthCheckService = new HealthCheckService();
            JSONObject obj;
            JSONObject childObj;
            JSONArray arr = new JSONArray();
            Set<String> serviceValues = healthCheckService.getHealthCheckRegistryNames();

            for (String serviceName : serviceValues) {
                obj = new JSONObject();
                childObj = new JSONObject();
                Result result = healthCheckService.runHealthCheck(serviceName);

                if (!result.isHealthy()) {
                    healthCheck = false;
                    LOG.error("Health Check Failed Details for the Health Check Name :   " + serviceName + " Error Details: " + result.getMessage());
                }

                childObj.put("healthy: ", result.isHealthy());

                if (result.getMessage() != null && !result.getMessage().isEmpty()) {
                    childObj.put("message:", result.getMessage());
                }
                obj.put(serviceName, childObj);
                arr.put(obj);
            }
        } catch (Exception ex) {
            LOG.error("Failed to read properties.", ex);
            return Result.unhealthy("Failed to read properties.");
        }

        if (healthCheck) {
            return Result.healthy();
        } else {
            return Result.unhealthy("Failed to read properties.");
        }
    }


    private Hero deserializeHero() {
        return new Hero(10, 10, 9);
    }

    private Enemy loadEnemy() {
        return new Enemy(10, 10, 10);
    }

    public void initialize() {
        LOG.info("Initialization");
    }

    private static void serializeHero(Hero hero) {
        LOG.info("serializing hero. Is alive: " + hero.isAlive());
    }

}
