package com.game.model;

public interface IFighter {

    void attack(IFighter opponent);

    void acceptDamage(int damage);

    boolean isAlive();
}
