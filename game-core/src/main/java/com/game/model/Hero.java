package com.game.model;

public class Hero extends BaseFighter {

    public Hero(int health, int defense, int damage) {
        setHealth(health);
        setDefense(defense);
        setDamage(damage);
    }

    @Override
    public void acceptDamage(int damage) {
        int hitDefense = getRandom().nextInt(getDefense());
        int hitDamage = damage - hitDefense;
        if (hitDamage > 0) {
            setHealth(getHealth() - hitDamage);
            LOG.info("|o   x   o|o   _   o|");
        } else {
            LOG.info("|o   _   o|o   _   o|");
        }
    }

    @Override
    public String toString() {
        return "Hero {" +
               "health=" + getHealth() +
               ", defense=" + getDefense() +
               ", damage=" + getDamage() +
               '}';
    }
}
