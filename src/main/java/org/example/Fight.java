package org.example;

import java.util.Random;

public class Fight implements Runnable{

    Player player;
    @Override
    public void run() {

        Random random = new Random();
        int randomNumber = random.nextInt(101);
        if (randomNumber > 50) {
            Goblin enemy = new Goblin("Гоблин", 250, 80, 30, 50, 30);
            fight(player, enemy);
        } else {
            Skeleton enemy = new Skeleton("Скелет", 200, 70, 20, 30, 20);
            fight(player, enemy);
        }


    }

    public static void fight(Player player, Character enemy) {
        System.out.println("Вы сражаетесь с монтром " + enemy.name);
        while (player.health > 0 && enemy.health > 0) {
            int playerAttack = player.attack();
            int enemyAttack = enemy.attack();
            if (playerAttack > 0) {
                enemy.health -= playerAttack;
                System.out.println("Вы нанесли монстру " + enemy.name + " " + playerAttack + " единиц урона.");
            } else {
                System.out.println("Вы промахнулись.");
            }
            if (enemy.health > 0) {
                if (enemyAttack > 0) {
                    player.health -= enemyAttack;
                    System.out.println(enemy.name + " нанес вам " + enemyAttack + " единиц урона.");
                } else {
                    System.out.println(enemy.name + " промахнулся по Вам.");
                }
            }
        }
        if (player.health <= 0) {
            System.out.println("Вы погибли.");
        } else {
            System.out.println("Вы убили монстра " + enemy.name + ".");
            System.out.println("************");
            player.gainExperience(enemy.experience);
            player.gold += enemy.gold;
            System.out.println("Получено " + enemy.gold + " золота." + " Всего золота: " + player.gold);
        }
    }
}
