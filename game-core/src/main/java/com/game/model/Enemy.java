package com.game.model;

public class Enemy extends BaseFighter {

    public Enemy(int health, int defense, int damage) {
        setHealth(health);
        setDefense(defense);
        setDamage(damage);
    }

    @Override
    public void updateHitContent() {
        LOG.info("|o   _   o|o   x   o|");
    }

    @Override
    public String toString() {
        return "Enemy {" +
               "health=" + getHealth() +
               ", defense=" + getDefense() +
               ", damage=" + getDamage() +
               '}';
    }

}
