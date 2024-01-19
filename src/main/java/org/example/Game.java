package org.example;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру! Введите ваше имя:");
        Scanner scanner = new Scanner(System.in);
        String playerName=scanner.nextLine();
        Player player = new Player(playerName, 500, 200, 50, 0, 60, 1);
        System.out.println(playerName + ", Куда вы хотите пойти?");
        String textMenu = """
                1. К торговцу
                2. В тёмный лес
                3. На выход""";
        System.out.println(textMenu);
        int choice = scanner.nextInt();
        while (choice != 3) {
            switch (choice) {
                case 1:
                    System.out.println("Вы зашли к торговцу.");
                    System.out.println("Что вы хотите купить?");
                    System.out.println("1. Лечебное зелье (30 золота)");
                    System.out.println("2. Вернуться в город");
                    int choiceTrader = scanner.nextInt();
                    switch (choiceTrader) {
                        case 1:
                            if (Trader.buy()) {
                                 if (player.gold >= Trader.price) {
                                    player.gold -= Trader.price;
                                    player.heal(50);
                                    System.out.println("Вы купили лечебное зелье. Ваше здоровье восстановлено на 200 единиц.");
                                    } else {
                                        System.out.println("У вас недостаточно золота.");
                                    }
                                } else {
                                    System.out.println("У торговца кончились зелья");
                                }
                            break;
                        case 2:
                            System.out.println(textMenu);
                            break;
                        default:
                            System.out.println("Неверный ввод.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Вы зашли в тёмный лес.");
                    System.out.println("1. Сразиться с монстром");
                    System.out.println("2. Вернуться в город");
                    int choiceForest = scanner.nextInt();
                    while (choiceForest !=2) {
                        switch (choiceForest) {
                            case 1:
                                Fight fight = new Fight();
                                fight.player = player;
                                Thread thread = new Thread(fight);
                                thread.start();
                                try {
                                    thread.join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2:
                                break;
                        }
                        break;
                    }
                    break;
                default:
                    System.out.println("Неверный ввод.");
                    break;
            }
            System.out.println(textMenu);
            choice = scanner.nextInt();
        }
    }
}
