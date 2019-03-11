package com.game.model;

/**
 * Generic fighter interface for objects that can fight.
 */
public interface IFighter {

    void attack(IFighter opponent);

    void acceptDamage(int damage);

    boolean isAlive();

    void create();

    void update();

    void delete();
}
