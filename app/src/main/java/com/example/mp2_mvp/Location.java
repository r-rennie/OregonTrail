package com.example.mp2_mvp;

public class Location {

    //Variables
    private static final int MILES_TOTAL = 505;
    private int mile = 0;
    private int milesLeft = 0;
    private char biome = '0';
    private int location = 0;
    private String name = "";

    //Constructors
    public Location(int mile, int location, String name) {
        this.mile = mile;
        this.location = location;
        this.name = name;
    }

    //Getters & Setters

    public int getMile() {
        return mile;
    }

    public int getMilesLeft() {
        return milesLeft;
    }

    public char getBiome() {
        return biome;
    }

    public double getLocation() {
        return location;
    }

    public void setMile(int mile) {
        this.mile = mile;
    }

    public void setMilesLeft(int milesLeft) {
        this.milesLeft = MILES_TOTAL - getMile();
    }

    public void setBiome(char biome) {
        this.biome = biome;
    }
    //Maybe location = 0 if not at a specific location/in between)
    public void setLocation(int location) {
        this.location = location;
    }

    //Methods
    /*
    public int moveForward(int mile, entities.getPace()){
        int newMile = mile + entities.getPace; // if pace = 0, + 15, if pace = 1, +20, if pace = 2, +25
        return newMile;
    }*/

    public static boolean isVisited(Location stop) {
        if (stop.location == 0) {
            return true;
        } else {
            stop.setLocation(0);
            return false;
        }
    }

    public static String findLocation (int miles, Location stop){
        if (miles == 0) {
            return "Independence, Missouri";
        } else if (miles >= 35 && !isVisited(stop)){
            isVisited(stop);
            return "Fort Leavenworth";
        } else if (miles >= 105 && !isVisited(stop)){
            isVisited(stop);
            return "Kansas River";
        } else if (miles >= 335 && !isVisited(stop)){
            isVisited(stop);
            return "Fort Kearny";
        } else if (miles >= 505){
            return "Ash Hollow, Nebraska";
        } else {
            return "Travelling...";
        }
    }

    public static String location(int mile, int pace) {
        if (pace == 3) {
            if (mile == 0) {
                return "Independence, Missouri";
            } else if (mile == 50) {
                return "Fort Leavenworth";
            } else if (mile == 100) {
                return "Kansas River";
            } else if (mile == 325) {
                return "Fort Kearny";
            } else if (mile >= 505) {
                return "Ash Hollow, Nebraska";
            } else {
                return "Travelling...";
            }
        } else if (pace == 2) {
            if (mile == 0) {
                return "Independence, Missouri";
            } else if (mile == 60) {
                return "Fort Leavenworth";
            } else if (mile == 100) {
                return "Kansas River";
            } else if (mile == 320) {
                return "Fort Kearny";
            } else if (mile >= 505) {
                return "Ash Hollow, Nebraska";
            } else {
                return "Travelling...";
            }
        } else if (pace == 1) {
            if (mile == 0) {
                return "Independence, Missouri";
            } else if (mile == 60) {
                return "Fort Leavenworth";
            } else if (mile == 105) {
                return "Kansas River";
            } else if (mile == 330) {
                return "Fort Kearny";
            } else if (mile >= 505) {
                return "Ash Hollow, Nebraska";
            } else {
                return "Travelling...";
            }
        } else {
            return "error";
        }
    }

}
