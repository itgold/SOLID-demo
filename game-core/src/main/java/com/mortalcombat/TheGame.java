package com.mortalcombat;

import com.mortalcombat.model.Enemy;
import com.mortalcombat.model.Hero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheGame {

    public static final Logger LOGGER = LoggerFactory.getLogger(TheGame.class);

    public static void main(String[] args) {

        TheGame.initialize();

        Hero hero = deserializeHero();
        Enemy enemy = loadEnemy();

        for (int i = 0; i < 10; i++) {

            hero.attack(enemy);
            if (!enemy.isAlive()) {
                LOGGER.info("Hero won!");
                break;
            }

            enemy.attack(hero);
            if (!hero.isAlive()) {
                LOGGER.info("Enemy wins :(");
                break;
            }
        }

        LOGGER.info(hero.toString());
        LOGGER.info(enemy.toString());

        serializeHero(hero);
    }

    private static Hero deserializeHero() {
        return new Hero(10, 10, 10);
    }

    private static Enemy loadEnemy() {
        return new Enemy(10, 10, 10);
    }

    public static void initialize() {
        LOGGER.info("Initialization");
    }

    private static void serializeHero(Hero hero) {
        LOGGER.info("serializing hero. Is alive: " + hero.isAlive());
    }

}
