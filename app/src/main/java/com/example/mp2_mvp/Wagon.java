package com.example.mp2_mvp;

public class Wagon {

    private int wheelCondition = 100;
    private int axleCondition = 100;
    private int tongueCondition = 100;
    private int weightLimit = 100;
    private int wagonSpeed = 10;


    //constructors
    //public wagon(){this.wheelCondition=100;this.axleCondition=100;this.tongueCondition=100;this.weightLimit=100;this.wagonSpeed=10;}

    int getWheelCondition(){return this.wheelCondition;}
    int getAxleCondition(){return this.axleCondition;}
    int getTongueCondition(){return this.tongueCondition;}
    int getWeightLimit(){return this.weightLimit;}
    int getWagonSpeed(){return this.wagonSpeed;}
    boolean setWheelCondition(int condition){
        if(condition>=0) {
            this.wheelCondition = condition;
            return true;
        }
        return false;
    }
    boolean setAxleCondition(int condition){
        if(condition>=0) {
            this.axleCondition = condition;
            return true;
        }
        return false;
    }
    boolean setTongueCondition(int condition){
        if(condition>=0) {
            this.tongueCondition = condition;
            return true;
        }
        return false;
    }
    boolean setWagonSpeed(int speed){
        this.wagonSpeed=speed;
        return true;
    }
    boolean setWeightLimit(int limit){
        if (limit>=0) {
            this.weightLimit = limit;
            return true;
        }
        return true;
    }
}
