/*
File Name: Event.java
Date: April 4th, 2023
Author(s): Lila Baxter
Description: Deals with the generation of random events throughout the game
 */

package com.example.mp2_mvp;

import java.util.ArrayList;

public class Event {

    public static String eventID;
    public static String eventName;

    /**
     *
     * @param amount integer health value
     * @return the new integer health value after restoring some health
     */
    public static int heal(int amount) {
        if (Entities.partyHealth - amount <= 0) {
            return 0;
        } else {
            return Entities.partyHealth - amount;
        }
    }

    /**
     * @param amount the current health amount
     * @return an incremented health integer based on damage taken
     */
    public static int takeDamage(int amount) {
        return Entities.partyHealth += amount;
    }

    /**
     * sets the health status to "Ill" on a random event
     * @param entity the entity being affected
     */
    public static void fallIll(Entities entity){
        takeDamage(1);
        entity.setCharacterHealth("Ill");
    }


    /**
     * sets the health status to "Snake Bite" on random event
     * @param entity the entity being affected
     */
    public static void snakeBite(Entities entity){
        takeDamage(3);
        entity.setCharacterHealth("Snake Bite");
    }


    /**
     * resets the health status to "Healthy" on random event
     * @param entity the entity being affected
     */
    public static void recover(Entities entity){
        entity.setCharacterHealth("Healthy");
    }


    /**
     * @return the random event integer corresponding to a random event
     */
    public static int getEvent() {
        return (int)(Math.random() * 10) + 1;
    }

}
