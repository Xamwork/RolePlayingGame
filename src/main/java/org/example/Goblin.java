package org.example;

import java.util.Random;

public class Goblin extends Character{

    public Goblin(String name, int health, int gold, int agility, int experience, int strength) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.agility = agility;
        this.experience = experience;
        this.strength = strength;
    }

    @Override
    int attack() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        if (this.agility > randomNumber) {
            if (randomNumber>75) {
                return this.strength * 2; // critical hit
            }
            return this.strength; // normal hit
        } else {
            return 0; // miss
        }
    }
}
