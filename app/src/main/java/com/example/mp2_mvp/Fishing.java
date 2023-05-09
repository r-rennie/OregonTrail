package com.example.mp2_mvp;
import java.util.ArrayList;

public class Fishing {

    //Variables


    //Constructor

    public Fishing() {
    }

    //Methods

    //types of fish found at https://www.ksfishfinder.com/view_all_fish_types.php

    /**
     * Description: Player fishes for random fish. Depending on what fish they receive, they receive a certain amount of food.
     * @param: none
     * @return: number of pounds of food received from fish
     **/
    public int fish() {
        String fish = "no fish";
        int food_sum = 0;
        int fish_pounds = 0;
        System.out.println("You received: ");
        for (int i = 0; i < 3; i++) {
            int random_fish_value = (int) ((Math.random() * 10) + 1);
            switch (random_fish_value) {
                case 1:
                    fish = "American Shad";
                    fish_pounds = 5;
                    break;
                case 2:
                    fish = "Bluegill";
                    fish_pounds = 2;
                    break;
                case 3:
                    fish = "Atlantic Sturgeon";
                    fish_pounds = 5;
                    break;
                case 4:
                    fish = "Atlantic Salmon";
                    fish_pounds = 10;
                    break;
                case 5:
                    fish = "Common Carp";
                    fish_pounds = 3;
                    break;
                case 6:
                    fish = "Green Sunfish";
                    fish_pounds = 1;
                    break;
                case 7:
                    fish = "Flathead Catfish";
                    fish_pounds = 20;
                    break;
                case 8:
                    fish = "Largemouth Bass";
                    fish_pounds = 15;
                    break;
                case 9:
                    fish = "Rainbow Trout";
                    fish_pounds = 12;
                    break;
                case 10:
                    fish = "White Catfish";
                    fish_pounds = 8;
                    break;
            }
            food_sum += fish_pounds;
            System.out.println(fish);
        }
        System.out.println(" from fishing today.");
            return food_sum;
    }

    /**
     * Description: Checks the user's inventory to see if they have a fishing rod
     * @param supplies
     * @param fishing_rod
     * @return true if the player has a fishing rod. False otherwise.
     */
    boolean playerHasRod(ArrayList <Integer> supplies, Item fishing_rod){
        for (int i = 0; i < supplies.size(); i++){
            if ((supplies.get(i)).equals(fishing_rod.getId())){
                return true;
            }
        }
        return false;
    }
}
