package com.mortalcombat.model;

public class Fighter implements ICreature {

    private int health;
    private int defense;
    private int damage;

    public Fighter(int health, int defense, int damage) {
        this.health = health;
        this.defense = defense;
        this.damage = damage;
    }

    @Override
    public void attack(ICreature opponent) {

    }
}
