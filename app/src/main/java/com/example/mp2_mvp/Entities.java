/*
File Name: Entities.java
Date: April 4th, 2023
Author(s): Rachael Rennie
Description: Creates entities (Hattie, NPCs, (soon to come oxen)) and monitors health, food rationing,
             pace, etc. stats controlled by user
 */

package com.example.mp2_mvp;



public class Entities {

    // Creating initial variables
    public static int healthModifier = 0;
    public static String[] entityName = new String[6];
    public static String[] memberIllness = new String[6];
    public static String[] memberInjury = new String[6];
    public static int partyHealth = 0;
    public static int foodRations = 3;
    public static int pace = 18;
    public int index = 0;
    public static String healthStatus;
    public static String paceWord;
    public static int poundsFoodConsumed = 0;
    private int role = 100;
    private static int deathHealth = 140;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Constructor of each of the family members at the beginning of the game
     * @param role assigns each member of the party a "role" number that references their name in an array
     * @param nameIn the inputted names of other family members as given by the player
     */
    public Entities(int role, String nameIn) {
        this.role = role;
        if (role == 0) {
            this.entityName[0] = "Hattie";
        } else {
            this.entityName[role] = nameIn;
            index = role;
        }
        memberIllness[role] = "Healthy";
        memberInjury[role] = "None";
    }

    /**
     * sets health of the family; health starts at 0 and climbs given circumstances of poor health maintenance
     * @param damage the damage being added to the current health given a circumstance
     */
    public static void setHealth(int damage) {
        partyHealth = partyHealth + damage;
    }

    /**
     * @return the referenced health status (as a string) of the family given their integer health value
     */
    public static String getHealth() {
        if(partyHealth <= 34) {
            healthStatus = "good health";
        }
        else if(partyHealth <= 65) {
            healthStatus = "fair health";
        }
        else if(partyHealth <= 104) {
            healthStatus = "poor health";
        }
        else {
            healthStatus = "very poor health";
        }

        return healthStatus;
    }

    /**
     * Gets the injury status of a given member
     * @param role ; the role referring to which member is being checked for injury
     * @return ; the String value describing the given member's injury, if any
     */
    public static String getMemberInjury(int role) {
        return memberInjury[role];
    }

    /**
     * Sets the injury status of a given member
     * @param role ; the role referring to which member the injury is being added to
     * @param condition ; the injury condition that is being added to the given member
     */
    public static void setMemberInjury(int role, String condition) {
        memberInjury[role] = condition;
    }

    /**
     * Gets the illness status of a given member
     * @param role ; the role referring to which member is being checked for illness
     * @return ; the String value desscribign the given member's illness, if any
     */
    public static String getMemberIllness(int role) {
        return memberIllness[role];
    }

    /**
     * Sets the illness status of a given member
     * @param role ; the role referring to which member the illness is being added to
     * @param condition ; the illness condition that is being added to the given member
     */
    public static void setMemberIllness(int role, String condition) {
        memberIllness[role] = condition;
    }

    /**
     * Gets the integer health value of the collective party
     * @return the party's integer health value
     */
    public static int getHealthInt() {
        return partyHealth;
    }

    /**
     *   "Filling" is 3 pounds of food per day per person, "meager" is 2 pounds, and "bare bones" is 1 pound
     *   Given the set rations, the health of the family is changed
     * @param food the food rations as set by the player
     */
    public static void setFoodRations(int food) {
        foodRations = food;
        System.out.println("foodRations: " + foodRations);
    }

    /**
     * Says how much food has been eaten so it can be removed from the wagon inventory
     * @param pace ; the pace at which the wagon is travelling
     * @return ; how much food has been eaten
     */
    public static int foodEaten(int pace) {
        return 5 * pace;
    }

    /**
     * Accounts for damage from limited food rationing/hunger
     * @return ; damage due to rationing
     */
    public static int getDamageFromRations(){
        if (foodRations == 3) {
            return 0;
        } else if (foodRations == 2) {
            return 2;
        } else if (foodRations == 1) {
            return 4;
        } else if (foodRations == 0) {
            return 6;
        } else {
            return 100;
        }
    }

    /**
     * Gets the string value describing the current food rationing
     * @return ; the current food rationing of the family
     */
    public static String getFoodRations() {
        if (foodRations == 3) {
            return "Filling";
        } else if (foodRations == 2) {
            return "Meager";
        } else if (foodRations == 1) {
            return "Barebones";
        } else if (foodRations == 0) {
            return "Out of Food";
        } else {
            return "error";
        }
    }

    /**
     * Gets the current pace of the wagon
     * @return ; the wagon pace
     */
    public static int getPace() {
       return pace;
    }

    /**
     * Sets the pace of the wagon
     * Wagon pace is decremented based on member injury, member illness, poor trail conditions, and poor oxen health
     * @param useToSet
     */
    public static void setPace(int useToSet) {
        if (useToSet == 0) {
            pace = 0;
            paceWord = "Resting";
        } else if (useToSet == 1) {
            pace = 15;
            paceWord = "Steady";
        } else if (useToSet == 2) {
            pace = 20;
            paceWord = "Strenuous";
        } else if (useToSet == 3) {
            pace = 25;
            paceWord = "Grueling";
        }
        else {
            pace = -1;
        }


        // Decrease speed by 10% for each sick party member
        double fillerVar = 0.0;
        for (int i = 2; i <= 5; i++) {
            if (memberIllness[i] != "Healthy" || memberInjury[i] != "None") {
                fillerVar += 0.1;
            }
            if (memberIllness[0] != "Healthy" || memberInjury[0] != "None") {
                fillerVar += 0.1;
            }

            fillerVar = 1.0 - fillerVar;
            pace = (int) (pace * fillerVar);
        }

        // For every inch of snow/rain on/in the ground, the speed is reduced by 5%
        // CHANGE TO cumulative snow vs. just daily
        if (Weather.getPrecipitation() > 1.0) {
            double filler = Weather.getPrecipitation() * 0.05;
            filler = 1.0 - filler;
            pace = (int) (pace * filler);
        }

        // Random odds of crossing mountainous terrain
        int randInt = (int) (Math.random() * 100);
        if (randInt <= 15) {
            pace = (int) (pace * 0.5);
        }

    }



    /*
    public static int getDamageFromPace() {
        return
    }
     */

    /**
     * Gets the overall party health status as a String
     * @return ; the part health status String description
     */
    public static String getHealthStatus() {
        return healthStatus;
    }

    /**
     * Sets the string health association for the overall party
     * @param characterHealth ; the String representation being assigned
     */
    public void setCharacterHealth(String characterHealth) {
        healthStatus = characterHealth;
    }

    /*
    public static int getDamageFromEvent() {

        Event chosenEvent = Event.chooseRandomEvent();
        int total = 0;

        //damage from diseases??? do i need this
        for (int i = 0; i < 5; i++) {
            if (!memberIllness[i].equals("Healthy")) {
                total = total + 20;
            } else {

            }
        }



        return total;

    }
    */

    /**
     * Determines how much health is naturally regenerated each day
     * @return how much of the health will be restored each day
     */
    public static double dailyHealthRegen() {
        return 0.1 * deathHealth;
    }


    /**
     *
     * @return the string name associated with a certain character index
     */
    @Override
    public String toString() { return entityName[index]; }


}
