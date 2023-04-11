package com.example.mp2_mvp;

public class Player {
    public static int maxHealth = 100;
    public static int health;

    public Player() {
        health = maxHealth;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int amount) {
        health = amount;
    }

    public static int getMaxHealth() {
        return maxHealth;
    }

    public static void setMaxHealth(int amount) {
        maxHealth = amount;
    }

    public static int addHealth(int amount) {
        if (health + amount >= maxHealth) {
            return maxHealth;
        } else {
            return health + amount;
        }
    }



    public static void displayHealth(){
        System.out.println(health);
    }


}
