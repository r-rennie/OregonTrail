/*
File Name: Entities.java
Date: April 4th, 2023
Author(s): Rachael Rennie
Description: Creates entities (Hattie, NPCs, (soon to come oxen)) and monitors health, food rationing,
             pace, etc. stats controlled by user
 */

package com.example.mp2_mvp;



public class Entities {

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
    /*
    Setting the original family member names; the 'role' can be the associated number for each family member/the
    order their names are getting entered in
     */

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

    public static String getMemberInjury(int role) {
        return memberInjury[role];
    }

    public static void setMemberInjury(int role, String condition) {
        memberInjury[role] = condition;
    }

    public static String getMemberIllness(int role) {
        return memberIllness[role];
    }

    public static void setMemberIllness(int role, String condition) {
        memberIllness[role] = condition;
    }

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

    public static int foodEaten(int pace) {
        return 5 * pace;
    }

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
     * @return the current food rationing of the family
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

    public static int getPace() {
       return pace;
    }

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


    public static int getDamageFromPace() {
        return pace;
    }

    public static String getHealthStatus() {
        return healthStatus;
    }

    public static String getCharacterHealth(int character) {
        return healthStatus;
    }

    public void setCharacterHealth(String characterHealth) {
        healthStatus = characterHealth;
    }

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

    public static double dailyHealthRegen() {
        return 0.1 * deathHealth;
    }



    @Override
    public String toString() { return entityName[index]; }


}
