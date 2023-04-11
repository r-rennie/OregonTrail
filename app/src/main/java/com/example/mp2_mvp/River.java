package com.example.mp2_mvp;

public class River extends Location {

    //Variables
    public int riverChoice = 0;
    public int riverDepth = 0;
    public static double FERRY_PRICE = 5;

    //Constructor

    public River(int mile, int location, String name, int depth) {
        super(mile, location, name);
        this.riverDepth = depth;
    }

    //Getters & Setters

    public int getRiverDepth() {
        return riverDepth;
    }

    public int getRiverChoice() {
        return riverChoice;
    }

    public void setRiverChoice(int riverChoice) {
        this.riverChoice = riverChoice;
    }

    public void setRiverDepth(int riverDepth) {
        this.riverDepth = riverDepth;
    }

    //Methods

    /*
    //Floating Wagon Across
    boolean riverWagonCrossSucceed(int Wagon.getWagonStatus(), int entity.getPlayerHealth(), int river){
        //If health is below certain amount (must be very low) fail
        // If wagon health is low (medium) fail
        //Some rivers are worse than others
        return true;
    }
    //Swimming/Walking Across (https://www.loupcity.com/when-to-ford-rivers-in-oregon-trail/)
    boolean riverSwimAcrossSucceed(int entity.getPlayerHealth(), int depth){
        if (entity.getPlayerHealth() < 5 || depth > 4;)
        {
            return false;
        }
        return true;
    }

    //Ferry (before this, in main, check if player has a balance to do so)
    boolean payForFerry(inventory.getBalance()){
        if (inventory.getBalance() < FERRY_PRICE )
            {
                return false;
            }
        return true;
    }
*/
}
