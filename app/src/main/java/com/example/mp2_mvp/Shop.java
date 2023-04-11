/*
File Name: Shop.java
Date: April 4th, 2023
Author(s): Lila Baxter
Description: Allows users to buy/sell from the shop and increase/decrease balance and item quantity in
             inventory based on purchases/sales
 */
package com.example.mp2_mvp;

import java.util.Arrays;

public class Shop {

    //set max quantity in shop? item? <---full game

    public static double money;

    /**
     * get the value of how much money Hattie has left
     * @return money ($)
     */
    public static double getMoney() {
        return money;
    }

    /**
     * sets the balance
     * @param amount money ($)
     */
    public static void setMoney(double amount) {
        money = amount;
    }

    /**
     * Method to buy items from shop; only allows players to buy if they have enough money
     * Adds purchased items to the inventory
     * @param item the item requested
     * @param quantity how many of the item they want
     */
    public static void buyItem(Item item, int quantity) {
        if (quantity <= item.quantityInShop && (quantity * item.price) <= money) {
            Inventory.addSupplies(item.id, quantity);
            decreaseMoney(item, quantity);
            item.setQuantityInShop(item.quantityInShop - quantity);
        } else if (quantity > item.quantityInShop) {
            System.out.println("Sorry, I don't have that many.");
        } else if ((quantity * item.price) > money) {
            System.out.println("Sorry, you don't have enough money for that.");
        } else {
            System.out.println("Error - Shop.buyItem");
        }
    }

    /**
     * Allows users to sell items from their inventory
     * Adds money from sold items to balance
     * @param item item being sold
     * @param quantity how many of the item is being sold
     */
    public static void sellItem(Item item, int quantity) {
        // we will work supply list into this
        Inventory.removeSupplies(item.id, quantity);
        increaseMoney(item, quantity);
        item.setQuantityInShop(item.quantityInShop + quantity);
    }

    /**
     * Decrements the balance when something is purchased
     * @param item the item being purchased (allows access to price)
     * @param quantity how many of the item is being purchased (for decrement of balance)
     */
    public static void decreaseMoney (Item item, int quantity) {
        if ((item.price * quantity) <= money) {
            money = money - (item.price * quantity);
        } else {
            System.out.println("Error - Shop.decreaseMoney");
        }
    }

    /**
     * Method overloading of the above method
     * For the decrement of money without a certain item associated
     * @param quantity how much money is being removed from the balance
     */
    public static void decreaseMoney (double quantity) {
        money = money - quantity;
    }

    /**
     * Adds money to the user's balance when something is sold
     * @param item the item being sold
     * @param quantity how many of the item is being sold
     */
    public static void increaseMoney (Item item, int quantity) {
        money = money + (item.price * quantity);
    }

    /**
     * Method overloading of the above method
     * For the addition of money to the balance without a specific associated item
     * @param amount how much money is being added to the balance
     */
    public static void increaseMoney (int amount) {
        money = money + amount;
    }


    /**
     * Displays items in inventory as a string
     * @param items items being displayes
     */
    public static void displayWares(Item[] items) {
        System.out.println(Arrays.toString(items));
    }

    /**
     * Displays current balance of user
     */
    public static void displayMoney() {
        System.out.println(money);
    }

}
