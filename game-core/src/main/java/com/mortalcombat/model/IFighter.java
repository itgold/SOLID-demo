package com.mortalcombat.model;

public interface IFighter {

    void attack(IFighter opponent);

    void acceptDamage(int damage);

    boolean isAlive();
}
