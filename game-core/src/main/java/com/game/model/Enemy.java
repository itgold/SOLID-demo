package com.game.model;

/**
 * Enemy class implementation.
 * It represents Enemy's properties and behavior.
 */
public class Enemy extends BaseFighter {

    /**
     * Initialization constructor.
     * @param health how much health this enemy has.
     * @param defense how much defense this enemy has.
     * @param damage  how much damage it can deliver.
     */
    public Enemy(int health, int defense, int damage) {
        setHealth(health);
        setDefense(defense);
        setDamage(damage);
    }

    /**
     * @see BaseFighter#updateHitContent()
     */
    @Override
    public void updateHitContent() {
        LOG.info("|o   _   o|o   x   o|");
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Enemy {" +
               "health=" + getHealth() +
               ", defense=" + getDefense() +
               ", damage=" + getDamage() +
               '}';
    }

}
