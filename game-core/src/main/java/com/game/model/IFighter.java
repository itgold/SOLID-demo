package com.game.model;

/**
 * Generic fighter interface for objects that can fight.
 * It is also an active record and can persist itself.
 */
public interface IFighter {

    /**
     * Invoked when current fighter attacks an opponent.
     * @param opponent opponent to attack.
     */
    void attack(IFighter opponent);

    /**
     * Used when fighter is getting attacked.
     * @param damage amount of damage to digest.
     */
    void acceptDamage(int damage);

    /**
     * Is our fighter still alive?
     * @return true if an amount of health is greater than 0.
     */
    boolean isAlive();

    /**
     * Persists new entity.
     */
    void create();

    /**
     * Updates current entity.
     */
    void update();

    /**
     * Deletes current entity.
     */
    void delete();
}
