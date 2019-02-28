package com.mortalcombat;

import com.mortalcombat.model.Enemy;
import com.mortalcombat.model.Fighter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheGame {

    public static final Logger LOGGER = LoggerFactory.getLogger(TheGame.class);

    public static void main(String[] args) {

        TheGame.initialize();

        Fighter fighter = deserializeHero();
        Enemy enemy = loadEnemy();

        for (int i = 0; i < 10; i++) {
            fighter.attack(enemy);
            enemy.attack(fighter);
        }

        serializeHero(fighter);
    }

    private static Fighter deserializeHero() {
        return new Fighter(10, 10, 10);
    }

    private static Enemy loadEnemy() {
        return new Enemy(10, 10, 10);
    }

    public static void initialize() {
        LOGGER.info("Initialization");
    }

    private static void serializeHero(Fighter fighter) {
        LOGGER.info("serializing");
    }

}
