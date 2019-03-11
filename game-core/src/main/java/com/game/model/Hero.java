package com.game.model;

public class Hero extends BaseFighter {

    public Hero(int health, int defense, int damage) {
        setHealth(health);
        setDefense(defense);
        setDamage(damage);
    }

    @Override
    public void updateHitContent() {
        LOG.info("|o   x   o|o   _   o|");
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
