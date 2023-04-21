package com.example.mp2_mvp;

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
    public int fish(){
        String fish = "no fish";
        int random_fish_value = (int)((Math.random() * 10) + 1);
        switch (random_fish_value){
            case 1: fish = "American Shad";
                break;
            case 2: fish = "Bluegill";
                break;
            case 3: fish = "Atlantic Sturgeon";
                break;
        }
        return 0;
    }

}
