package com.mortalcombat;

import com.mortalcombat.model.Enemy;
import com.mortalcombat.model.Fighter;

import java.util.logging.Logger;

public class TheGame {

    public static final Logger LOGGER = Logger.getLogger(TheGame.class.getName());

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
        return new Fighter();
    }

    private static Enemy loadEnemy() {
        return new Enemy();
    }

    public static void initialize() {
        LOGGER.info("Initialization");
    }

    private static void serializeHero(Fighter fighter) {
        LOGGER.info("serializing");
    }

}
