package org.example;

import java.util.Random;

public class Player extends Character{

    int lvl;

    public Player(String name, int health, int gold, int agility, int experience, int strength, int lvl) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.agility = agility;
        this.experience = experience;
        this.strength = strength;
        this.lvl = lvl;
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
        System.out.println("Поздравляем, уровень вашего персонажа поднялся до " + this.lvl + " уровня!");
    }

    void gainExperience(int experience) {
        this.experience += experience;
        if (this.experience >= 100) {
            this.levelUp();
            this.experience = 0;
        }
        System.out.println("Вы получили " + experience + " единиц опыта." + " Ваш Уровень: " + this.lvl+ ", Здоровье: " + this.health );
    }

    void heal(int health) {
        this.health += health;
    }
}
