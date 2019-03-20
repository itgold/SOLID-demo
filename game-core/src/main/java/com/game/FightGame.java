package com.game;

import com.game.model.Enemy;
import com.game.model.Hero;
import com.game.service.HealthCheckService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Set;

import static com.codahale.metrics.health.HealthCheck.Result;

/**
 * This is the primary game execution point.
 * Initializes the game and run it.
 */
public class FightGame {

    public static final Logger LOG = LoggerFactory.getLogger(FightGame.class);

    /**
     * Primary entry point method.
     */
    public static void main(String[] args) throws IOException {

        FightGame game = new FightGame();
        game.initialize();

        Result checkResult = game.healthCheck();

        if (checkResult.isHealthy()) {
            Hero hero = game.loadHero();
            Enemy enemy = game.loadEnemy();

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

            persistFighters(hero, enemy);
        }
    }

    /**
     * Logs the results of the game.
     * @param hero currently fighting hero.
     * @param enemy currently fighting enemy.
     */
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

    /**
     * Makes a call to a very remote server to ensure that application's health is fine.
     * @return health check result.
     */
    protected Result healthCheck() {
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

    /**
     * Initialization logic goes here.
     * @throws IOException if operation failed.
     */
    public void initialize() throws IOException {
        LOG.info("Initialization");
        createUploadFolder();
        createDownloadFolder();
    }

    /**
     * Creates folder to upload fighter's model.
     * @throws IOException if can't complete operation.
     */
    public void createUploadFolder() throws IOException {
        if (!createFolder("Uploads")) {
            throw new IOException("Unable to create upload folder.");
        }
    }

    /**
     * Initialization of the download folder.
     * @throws IOException if folder creation failed.
     */
    public void createDownloadFolder() throws IOException {
        if (!createFolder("Downloads"))  {
            throw new IOException("Unable to create download folder.");
        }
    }

    /**
     * Utility method that creates any folder you ask.
     * @param folderName path to the folder.
     * @return true if operation succeeded.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean createFolder(String folderName) {
        LOG.debug("Folder {} created", folderName);
        return true;
    }

    /**
     * Loads hero into memory. This might be performance intensive.
     * @return a new instance of Hero object.
     */
    private Hero loadHero() {
        Hero hero = new Hero(10, 10, 10);
        hero.create();
        return hero;
    }

    /**
     * Loads an enemy to fight against.
     * @return an Enemy object instance.
     */
    private Enemy loadEnemy() {
        Enemy enemy = new Enemy(10, 10, 10);
        enemy.create();
        return enemy;
    }

    /**
     * Persists given hero and enemy into the storage.
     * @param hero object to persist.
     * @param enemy instance to persist.
     */
    private static void persistFighters(Hero hero, Enemy enemy) {
        LOG.info("Hero is alive: " + hero.isAlive());
        LOG.info("Enemy is alive: " + enemy.isAlive());

        hero.update();
        enemy.update();
    }
}
