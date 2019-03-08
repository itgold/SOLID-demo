package com.mortalcombat.model;

import com.mortalcombat.FightGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class Enemy implements IFighter {

    public static final Logger LOG = LoggerFactory.getLogger(FightGame.class);

    private Random random = new Random();

    private int health;
    private int defense;
    private int damage;

    public Enemy(int health, int defense, int damage) {
        this.health = health;
        this.defense = defense;
        this.damage = damage;
    }

    @Override
    public void attack(IFighter opponent) {
        int hitDamage = random.nextInt(damage);
        opponent.acceptDamage(hitDamage);
    }

    @Override
    public void acceptDamage(int damage) {
        int hitDefense = random.nextInt(defense);
        int hitDamage = damage - hitDefense;
        health = hitDamage > 0 ? health - hitDamage : health;
        if (hitDamage > 0) {
            health = health - hitDamage;
            LOG.info("|o   _   o|o   x   o|");
        } else {
            LOG.info("|o   _   o|o   _   o|");
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        return "Enemy {" +
               "health=" + health +
               ", defense=" + defense +
               ", damage=" + damage +
               '}';
    }
}
