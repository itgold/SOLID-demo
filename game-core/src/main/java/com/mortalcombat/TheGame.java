package com.mortalcombat;

import com.mortalcombat.model.Enemy;
import com.mortalcombat.model.Hero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheGame {

    public static final Logger LOG = LoggerFactory.getLogger(TheGame.class);

    public static void main(String[] args) {

        TheGame.initialize();

        Hero hero = deserializeHero();
        Enemy enemy = loadEnemy();

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

    private static Hero deserializeHero() {
        return new Hero(10, 10, 9);
    }

    private static Enemy loadEnemy() {
        return new Enemy(10, 10, 10);
    }

    public static void initialize() {
        LOG.info("Initialization");
    }

    private static void serializeHero(Hero hero) {
        LOG.info("serializing hero. Is alive: " + hero.isAlive());
    }

}
