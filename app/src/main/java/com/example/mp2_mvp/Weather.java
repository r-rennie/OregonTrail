/*
File Name: Weather.java
Date: April 4th, 2023
Author(s): Maria Lyons, Rachael Rennie
Description: changes the weather in the game based on time of year (to be expanded more in full game)
 */

package com.example.mp2_mvp;

public class Weather {

    //Variables
    private static int temperature;
    private static int avgLocationTemp;
    private static int randTempAdd;
    private static int randPrecipitation;
    private static int randInt;
    private static double avgPrecipitation;
    private static double precipitation;
    private static String rainOrSnow;
    //Constructor
    public Weather() {
        this.temperature = 0;
        this.precipitation = 0;
    }

    //Getters & Setters

    /**
     * @return the temperature
     */
    public static int getTemperature() { return temperature; }

    public static double getPrecipitation() { return precipitation; }

    /** Sets the temperature and precipitation for each day
     * @param mile; how many miles along the trail the player currently is
     * @param month; what month it currently is
     */
    public void setWeather(int mile, int month) {
        /* Location information from Independence, MO to Fort Leavenworth is averaged based on
           Kansas City climate conditions at different times of year
         */
        if (mile >= 0 && mile <= 35) {
            if (month == 1) {
                avgLocationTemp = 31;
                avgPrecipitation = 3.5;
            }
            else if (month == 2) {
                avgLocationTemp = 35;
                avgPrecipitation = 3.9;
            }
            else if (month == 3) {
                avgLocationTemp = 46;
                avgPrecipitation = 3.0;
            }
            else if (month == 4) {
                avgLocationTemp = 57;
                avgPrecipitation = 3.5;
            }
            else if (month == 5) {
                avgLocationTemp = 66;
                avgPrecipitation = 4.8;
            }
            else if (month == 6) {
                avgLocationTemp = 76;
                avgPrecipitation = 3.6;
            }
            else if (month == 7) {
                avgLocationTemp = 81;
                avgPrecipitation = 3.6;
            }
            else if (month == 8) {
                avgLocationTemp = 79;
                avgPrecipitation = 3.6;
            }
            else if (month == 9) {
                avgLocationTemp = 70;
                avgPrecipitation = 4.0;
            }
            else if (month == 10) {
                avgLocationTemp = 58;
                avgPrecipitation = 3.0;
            }
            else if (month == 11) {
                avgLocationTemp = 46;
                avgPrecipitation = 2.6;
            }
            else if (month == 12) {
                avgLocationTemp = 34;
                avgPrecipitation = 3.6;
            }
            else { System.out.println("Error"); }
        }
        /* Location information from Fort Leavenworth to the Kansas River is averaged based on
           Seneca, KS climate conditions at different times of year
         */
        else if (mile > 25 && mile <= 105) {
            if (month == 1) {
                avgLocationTemp = 28;
                avgPrecipitation = 3.1;
            }
            else if (month == 2) {
                avgLocationTemp = 31;
                avgPrecipitation = 3.2;
            }
            else if (month == 3) {
                avgLocationTemp = 43;
                avgPrecipitation = 2.8;
            }
            else if (month == 4) {
                avgLocationTemp = 54;
                avgPrecipitation = 3.3;
            }
            else if (month == 5) {
                avgLocationTemp = 64;
                avgPrecipitation = 4.3;
            }
            else if (month == 6) {
                avgLocationTemp = 74;
                avgPrecipitation = 4.4;
            }
            else if (month == 7) {
                avgLocationTemp = 78;
                avgPrecipitation = 3.7;
            }
            else if (month == 8) {
                avgLocationTemp = 76;
                avgPrecipitation = 3.5;
            }
            else if (month == 9) {
                avgLocationTemp = 67;
                avgPrecipitation = 3.1;
            }
            else if (month == 10) {
                avgLocationTemp = 55;
                avgPrecipitation = 2.4;
            }
            else if (month == 11) {
                avgLocationTemp = 42;
                avgPrecipitation = 2.4;
            }
            else if (month == 12) {
                avgLocationTemp = 30;
                avgPrecipitation = 3.9;
            }
            else { System.out.println("Error"); }
        }
        /* Location information from the Kansas River to Fort Kearny is averaged based on
           Hastings, NE climate conditions at different times of year
         */
        else if (mile > 105 && mile <= 335) {
            if (month == 1) {
                avgLocationTemp = 26;
                avgPrecipitation = 2.6;
            }
            else if (month == 2) {
                avgLocationTemp = 29;
                avgPrecipitation = 2.9;
            }
            else if (month == 3) {
                avgLocationTemp = 40;
                avgPrecipitation = 3.0;
            }
            else if (month == 4) {
                avgLocationTemp = 51;
                avgPrecipitation = 3.1;
            }
            else if (month == 5) {
                avgLocationTemp = 62;
                avgPrecipitation = 3.8;
            }
            else if (month == 6) {
                avgLocationTemp = 72;
                avgPrecipitation = 3.7;
            }
            else if (month == 7) {
                avgLocationTemp = 77;
                avgPrecipitation = 3.0;
            }
            else if (month == 8) {
                avgLocationTemp = 74;
                avgPrecipitation = 2.8;
            }
            else if (month == 9) {
                avgLocationTemp = 65;
                avgPrecipitation = 2.2;
            }
            else if (month == 10) {
                avgLocationTemp = 53;
                avgPrecipitation = 2.1;
            }
            else if (month == 11) {
                avgLocationTemp = 39;
                avgPrecipitation = 2.2;
            }
            else if (month == 12) {
                avgLocationTemp = 27;
                avgPrecipitation = 3.3;
            }
            else { System.out.println("Error"); }
        }
        /* Location information from Fort Kearny to Ash Hollow is averaged based on
           North Platte, NE climate conditions at different times of year
         */
        else if (mile > 335) {
            if (month == 1) {
                avgLocationTemp = 25;
                avgPrecipitation = 1.8;
            }
            else if (month == 2) {
                avgLocationTemp = 28;
                avgPrecipitation = 2.2;
            }
            else if (month == 3) {
                avgLocationTemp = 38;
                avgPrecipitation = 2.2;
            }
            else if (month == 4) {
                avgLocationTemp = 48;
                avgPrecipitation = 2.8;
            }
            else if (month == 5) {
                avgLocationTemp = 58;
                avgPrecipitation = 2.8;
            }
            else if (month == 6) {
                avgLocationTemp = 69;
                avgPrecipitation = 3.0;
            }
            else if (month == 7) {
                avgLocationTemp = 75;
                avgPrecipitation = 2.4;
            }
            else if (month == 8) {
                avgLocationTemp = 72;
                avgPrecipitation = 1.9;
            }
            else if (month == 9) {
                avgLocationTemp = 63;
                avgPrecipitation = 1.4;
            }
            else if (month == 10) {
                avgLocationTemp = 49;
                avgPrecipitation = 1.5;
            }
            else if (month == 11) {
                avgLocationTemp = 36;
                avgPrecipitation = 1.7;
            }
            else if (month == 12) {
                avgLocationTemp = 25;
                avgPrecipitation = 1.9;
            }
            else { System.out.println("Error"); }

        }
        else {
            System.out.println("Error");
        }

        randPrecipitation = (int) (Math.random() * 100);
        randInt = (int) (Math.random() * 100);

        if (avgPrecipitation >= 3.0) {
           if (randInt < 60) {
               if (randPrecipitation < 30) {
                   this.precipitation = 0.2;
               }
               else {
                   this.precipitation = 0.8;
               }
           }
           else {
               this.precipitation = 0.0;
           }
        }
        else if (avgPrecipitation >= 2.0) {
            if (randInt < 45) {
                if (randPrecipitation < 30) {
                    this.precipitation = 0.2;
                }
                else {
                    this.precipitation = 0.8;
                }
            }
            else {
                this.precipitation = 0.0;
            }
        }
        else if (avgPrecipitation >= 1.0) {
            if (randInt < 30) {
                if (randPrecipitation < 30) {
                    this.precipitation = 0.2;
                }
                else {
                    this.precipitation = 0.8;
                }
            }
            else {
                this.precipitation = 0.0;
            }
        }
        else {
            if (randInt < 10) {
                if (randPrecipitation < 30) {
                    this.precipitation = 0.2;
                }
                else {
                    this.precipitation = 0.8;
                }
            }
            else {
                this.precipitation = 0.0;
            }

        }

        randTempAdd = (int) (Math.random() * 41) - 20;




        this.temperature = avgLocationTemp + randTempAdd;
    }

    public static void setRainOrSnow() {
        if (temperature <= 32) {
            rainOrSnow = "snow";
        }
        else { rainOrSnow = "rain"; }
    }

    public static String getRainOrSnow() { return rainOrSnow; }





}
