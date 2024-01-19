package org.example;

import java.util.Random;

public class Goblin extends Character{

    public Goblin(String name, int health, int gold, int agility, int experience, int strength) {
        this.name = name;
        this.health = 500;
        this.gold = 50;
        this.agility = 20;
        this.experience = 0;
        this.strength = 50;
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
