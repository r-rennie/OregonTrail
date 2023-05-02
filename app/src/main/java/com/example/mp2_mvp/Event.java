/*
File Name: Event.java
Date: April 4th, 2023
Author(s): Lila Baxter
Description: Deals with the generation of random events throughout the game
 */

package com.example.mp2_mvp;

import java.util.ArrayList;

public class Event {

    //redo: 100 options, 30% chance negative event (illness, wagon break, oxen, etc), 20% chance positive
    //event (find food, etc), 50% chance nothing happens [PERCENTAGES UP IN THE AIR STILL]

    private static String eventName;
    private static int effectOnHealth;
    private static String flavorText;
    private static int effectOnFood;

    public Event(String eventName, int effectOnHealth, String flavorText) {
        this.eventName = eventName;
        this.effectOnHealth = effectOnHealth;
        this.flavorText = flavorText;
    }
    public Event(int effectOnFood, String eventName, String flavorText){
        this.effectOnFood = effectOnFood;
        this.eventName = eventName;
        this.flavorText = flavorText;
    }



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
    public static void recoverIllness(Entities entity){
        entity.setCharacterHealth("Healthy");
    }

    public static void recoverInjury(Entities entity) {
        entity.setMemberInjury(entity.getRole(), "None");
    }

    /**
     * @return Either a random event, positive or negative, or nothing
     * Note: takes the place of setEvent
     */
    public static Event chooseRandomEvent() {

        int random = (int)(Math.random() * 100) + 1;

        //so you only need to change the array size in one place when adding to the event arrays
        int posArraySize = 2;
        int negArraySize = 4;

        Event[] negativeEvents = new Event[negArraySize];
        negativeEvents[0] = new Event("Bad water", 20, "Bad water");
        negativeEvents[1] = new Event("Very little water", 10, "Very little water");
        negativeEvents[2] = new Event("Diseased party member", 20, "Diseased party member");
        negativeEvents[3] = new Event("Rough trail", 10, "Rough trail");

        Event[] positiveEvents = new Event[posArraySize];
        positiveEvents[0] = new Event(20, "Find food", "Find food");
        positiveEvents[1] = new Event("Recover", 0, "Recover");

        if (random > 0 && random <= 30){
            int chooseNegative = (int)(Math.random() * negArraySize);
            return negativeEvents[chooseNegative];
        } else if (random > 30 && random <= 50) {
            int choosePositive = (int)(Math.random() * posArraySize);
            return positiveEvents[choosePositive];
        } else {
           return null;
        }
    }



}
