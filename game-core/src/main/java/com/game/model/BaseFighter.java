package com.game.model;

import com.game.FightGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public abstract class BaseFighter implements IFighter {

    public static final Logger LOG = LoggerFactory.getLogger(IFighter.class);

    private Random random = new Random();

    private int health;
    private int defense;
    private int damage;

    @Override
    public void attack(IFighter opponent) {
        int hitDamage = getRandom().nextInt(getDamage());
        opponent.acceptDamage(hitDamage);
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    public Random getRandom() {
        return random;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
