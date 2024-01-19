package org.example;

public class Trader {

    static int amount=10;
    static int price=30;

    public static boolean buy() {
        if (amount>0) {
            amount--;
            return true;
        } else {
            return false;
        }
    }

}
