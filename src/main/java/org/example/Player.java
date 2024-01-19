package org.example;

import java.util.Random;

public class Player extends Character{

    int lvl;

    public Player(String name, int health, int gold, int agility, int experience, int strength, int lvl) {
        this.name = name;
        this.health = 500;
        this.gold = 50;
        this.agility = 20;
        this.experience = 0;
        this.strength = 50;
        this.lvl = 1;
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

    void levelUp() {
        this.strength += 10;
        this.agility += 10;
        this.health += 10;
        this.lvl += 1;
        System.out.println("Поздравляем, уровень вашего персонажа поднялся до" + this.lvl + " уровня!");
    }

    void gainExperience(int experience) {
        this.experience += experience;
        if (this.experience >= 100) {
            this.levelUp();
            this.experience = 0;
        }
    }

    void heal(int health) {
        this.health += health;
    }
}
