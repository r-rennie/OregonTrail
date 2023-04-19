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
    public static String[] memberIllness;
    public static String[] memberInjury;
    public static int partyHealth = 0;
    public static int foodRations = 3;
    public static int pace = 18;
    public int index = 0;
    public static String healthStatus;

    public static String paceWord;
    public static int poundsFoodConsumed = 0;

    /**
     * Constructor of each of the family members at the beginning of the game
     * @param role assigns each member of the party a "role" number that references their name in an array
     * @param nameIn the inputted names of other family members as given by the player
     */
    public Entities(int role, String nameIn) {
        if (role == 0) {
            this.entityName[0] = "Hattie";
        } else {
            this.entityName[role] = nameIn;
            index = role;
        }
        memberIllness[role] = "Healthy";
        memberInjury[role] = "Healthy";
    }
    /*
    Setting the original family member names; the 'role' can be the associated number for each family member/the
    order their names are getting entered in
     */

    /**
     * sets health of the family; health starts at 0 and climbs given circumstances of poor health maintenance
     * @param damage the damage being added to the current health given a circumstance
     */
    public static void setHealth(int damage) { partyHealth = partyHealth + damage;
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
        if (pace == 0) {
            return 0;
        } else if(pace == 1) {
            return 15;
        } else if(pace == 2) {
            return 20;
        } else if(pace == 3) {
            return 25;
        } else {
            return -1;
        }
    }

    public static void setPace(int useToSet) {
        if (useToSet == 0) {
            pace = 0;
            paceWord = "Resting";
        } else if (useToSet == 1) {
            pace = 1;
            paceWord = "Steady";
        } else if (useToSet == 2) {
            pace = 2;
            paceWord = "Strenuous";
        } else if (useToSet == 3) {
            pace = 3;
            paceWord = "Grueling";
        }
    }

    public static int getDamageFromPace() {
        if (pace == 0) {
            return 0;
        } else if (pace == 1) {
            return 2;
        } else if (pace == 2) {
            return 4;
        } else if (pace == 3) {
            return 6;
        } else {
            System.out.println(pace);
            return 100;
        }
    }

    /*public String getName(int index) {
        return
    }

     */

    public static String getHealthStatus() {
        return healthStatus;
    }

    public static String getCharacterHealth(int character) {
        return healthStatus;
    }

    public void setCharacterHealth(String characterHealth) {
        healthStatus = characterHealth;
    }



    @Override
    public String toString() { return entityName[index]; }


}
