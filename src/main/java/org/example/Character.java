package org.example;

public abstract class Character {

    String name;
    int health;
    int gold;
    int agility;
    int experience;
    int strength;

    abstract void attack();

    abstract void criticalAttack();



}
