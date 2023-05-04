/*
File Name: Date.java
Date: April 4th, 2023
Author(s): Maria Lyons
Description: Monitors the passing of time in the game; increments date, days elapsed, and miles travelled
 */


package com.example.mp2_mvp;

public class Date {
    // Creating variables
    private static int month = 0;
    private static int day = 1;
    private static int year = 1850;
    private static int daysElapsed = 0;
    private static int milesElapsed = 0;

    /**
     * Constructor
     * @param month the current month
     * @param day the current day
     * @param year the current year
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //Getters & Setters

    /**
     * Gets the month
     * @return current month
     */
    public static int getMonth() {
        return month;
    }

    /**
     * Gets the current day
     * @return current day
     */
    public static int getDay() {
        return day;
    }

    /**
     * Gets the current year
     * @return current year
     */
    public static int getYear() {
        return year;
    }

    /**
     * Gets how many days have passed
     * @return days elapsed
     */
    public static int getDaysElapsed() {
        return daysElapsed;
    }

    /**
     * Sets the value of how many days have passed
     * @param daysElapsed the days that have passed
     */
    public static void setDaysElapsed(int daysElapsed) {
        Date.daysElapsed = daysElapsed;
    }

    /**
     * Gets how many miles have been travelled
     * @return milesElapsed; how many miles have been travelled
     */
    public static int getMilesElapsed() {
        return milesElapsed;
    }

    /**
     * Sets how many miles have been passed
     * @param milesElapsed how many miles have been travelled
     */
    public static void setMilesElapsed(int milesElapsed) {
        Date.milesElapsed = milesElapsed;
    }

    /**
     * Sets the current month
     * @param month current month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Sets the current day
     * @param day current day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Sets the current year
     * @param year current year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Sets the in-game date/time tracking
     * @param date the integer date
     */
    public static void nextDay(Date date){

        daysElapsed++;
        milesElapsed = milesElapsed + Entities.getPace();
        //Accounts to change month/year depending when the next day/month it currently is at
        if(day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)){
            if (month == 12) {
                month = 1;
                day = 1;
                year++;
            }
            else{
                day = 1;
                month++;
            }
        }
        if (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11 )) {
            day = 1;
            month++;
        }
        else{
            day++;
        }

    }


    /**
     * Converts the integer date value to a string and prints it
     * @param date the integer date value
     * @return the string date value
     */
    public static String printDate(Date date){
        String monthWord = "null";
        switch (getMonth()) {
            case 1:  monthWord = "January";
                break;
            case 2:   monthWord = "February";
                break;
            case 3:  monthWord = "March";
                break;
            case 4:  monthWord = "April";
                break;
            case 5:  monthWord = "May";
                break;
            case 6:  monthWord = "June";
                break;
            case 7:  monthWord = "July";
                break;
            case 8: monthWord = "August";
                break;
            case 9:  monthWord = "September";
                break;
            case 10: monthWord = "October";
                break;
            case 11: monthWord = "November";
                break;
            case 12: monthWord = "December";
                break;
            default: monthWord = "Not a month";
                break;
        }
        return monthWord + " " + getDay() + ", " + getYear();
    }



}
