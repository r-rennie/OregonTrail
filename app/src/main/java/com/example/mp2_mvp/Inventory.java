/*
File Name: Inventory.java
Date:April 4th, 2023
Author(s): Daniel MacDonald
Decription: Monitors quantity/addition/subtraction of supplies in the wagon
 */

package com.example.mp2_mvp;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
    private static final ArrayList<Integer> supplies = new ArrayList<Integer>();

    ArrayList<Integer> getSupplies(){ return this.supplies; }

    /**
     * Adds items to inventory
     * @param item the item being added to the inventory
     * @param amount how many of @param item are being added to the inventory
     * @return true if the items were added to the inventory successfully,
     *         false if they didn't
     */
    public static boolean addSupplies(int item, int amount){

        if(item < 22 && item > 1) {
            for (int i = 0; i < amount; i++) {
                supplies.add(item);
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Removes items from inventory
     * @param item the item being removed from the inventory
     * @param amount the amount of the @param item being removed
     */
    public static void removeSupplies(int item, int amount){
        int countInInventory = getItemCount(item);
        int countToRemove = 0;
        for (int i = 0; i < amount; i++){
            if (supplies.get(i) == item) {
                countToRemove++;
            }
        }
        System.out.println("Items in inventory: " + countInInventory);
        System.out.println("Items removed: " + countToRemove);
        if (countToRemove <= countInInventory) {
            for (int i = 0; i < countToRemove; i++){
                supplies.remove(item);
            }
        } else {
            for (int i = 0; i < countInInventory; i++){
                supplies.remove(item);
            }
        }
    }

    /**
     * Gets amount of a certain item in the inventory
     * @param item the item we're looking to find
     * @return how many of that item is in the inventory
     */
    public static int getItemCount(int item){
        int count = 0;
        for (int i = 0; i < supplies.size(); i++){
            if (supplies.get(i) == item) {
                count++;
            }
        }
        return count;
    }
    static int getItemCount(ArrayList<Integer> supplies){
        return supplies.size();
    }

}
