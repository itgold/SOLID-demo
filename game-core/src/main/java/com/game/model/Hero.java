package com.game.model;

/**
 * This is a Hero class used to define Hero's properties.
 */
public class Hero extends BaseFighter {

    /**
     * Initialization constructor.
     * @param health how much health this hero has.
     * @param defense how much defense this hero has.
     * @param damage  how much damage it can deliver.
     */
    public Hero(int health, int defense, int damage) {
        setHealth(health);
        setDefense(defense);
        setDamage(damage);
    }

    /**
     * @see BaseFighter#updateHitContent()
     */
    @Override
    public void updateHitContent() {
        LOG.info("|o   x   o|o   _   o|");
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Hero {" +
               "health=" + getHealth() +
               ", defense=" + getDefense() +
               ", damage=" + getDamage() +
               '}';
    }
}
