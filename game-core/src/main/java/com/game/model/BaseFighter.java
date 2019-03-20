package com.game.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Abstract base class that contains all the common properties of a fighters.
 */
public abstract class BaseFighter implements IFighter {

    public static final Logger LOG = LoggerFactory.getLogger(IFighter.class);

    private Random random = new Random();

    private int health;
    private int defense;
    private int damage;

    /**
     * @see IFighter#attack(IFighter)
     */
    @Override
    public void attack(IFighter opponent) {
        int hitDamage = getRandom().nextInt(getDamage());
        opponent.acceptDamage(hitDamage);
    }

    /**
     * @see IFighter#acceptDamage(int)
     */
    @Override
    public void acceptDamage(int damage) {
        int hitDefense = getRandom().nextInt(getDefense());
        int hitDamage = damage - hitDefense;
        if (hitDamage > 0) {
            setHealth(getHealth() - hitDamage);
            updateHitContent();
        } else {
            LOG.info("|o   _   o|o   _   o|");
        }
    }

    /**
     * This is a template method that implements fighter's specific
     * behavior when he is under attack.
     */
    protected abstract void updateHitContent();

    /**
     * @see IFighter#isAlive()
     */
    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    /**
     * @see IFighter#create()
     */
    @Override
    public void create() {
        LOG.debug("Created");
    }

    /**
     * @see IFighter#update()
     */
    @Override
    public void update() {
        LOG.debug("Updated");
    }

    /**
     * @see IFighter#delete()
     */
    @Override
    public void delete() {
        LOG.debug("Deleted");
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
