package com.game.model;

public class Enemy extends BaseFighter {

    public Enemy(int health, int defense, int damage) {
        setHealth(health);
        setDefense(defense);
        setDamage(damage);
    }

    @Override
    public void acceptDamage(int damage) {
        int hitDefense = getRandom().nextInt(getDefense());
        int hitDamage = damage - hitDefense;
        setHealth(hitDamage > 0 ? getHealth() - hitDamage : getHealth());
        if (hitDamage > 0) {
            setHealth(getHealth() - hitDamage);
            LOG.info("|o   _   o|o   x   o|");
        } else {
            LOG.info("|o   _   o|o   _   o|");
        }
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
