/*
File Name: Weather.java
Date: April 4th, 2023
Author(s): Maria Lyons
Description: changes the weather in the game based on time of year (to be expanded more in full game)
 */

package com.example.mp2_mvp;

public class Weather {

    //Variables
    private int temperature;

    //Constructor
    public Weather(int temp) {
        this.temperature = temp;
    }

    //Getters & Setters

    /**
     * @return the temperature
     */
    public int getWeather() {
        return temperature;
    }

    /**
     * @param temp ; sets the temperature
     */
    public void setWeather(int temp) {
        this.temperature = temp;
    }
}
