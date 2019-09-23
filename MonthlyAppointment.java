/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentsapp;

/**
 *
 * @author Cristy
 */
public class MonthlyAppointment extends Appointment {


    /**
     *  the day is an attribute that is not inherited directly from 
     * the Appointment class. Therefore it has to be declared in this class.
     */
    private int day;

   /**
     * 
     * @param description String entered by user on what their appointment is for.
     * @param lastName String entered by user that has their last name
     * @param hours int representing the hour the appointment is at.
     * @param minutes int representing the minute the appointment is at.
     */
    public MonthlyAppointment(String description, String lastName, int hours, int minutes, int day) {
        super(description, lastName, hours, minutes);
        this.day = day;

    }

    /**
     * 
     * @return  the day the appointment was made for
     */
    public int getDay() {
        return day;
    }
/**
 * 
 * @param day  is the new value the day variable will have.
 */
    public void setDay(int day) {
        this.day = day;
    }

     /**
     * 
     * @param year int representing the year the appointment is during.
     * @param month int representing the month the appointment is during.
     * @param day int representing the day the appointment is during
     * @return  boolean that is true if the day of the month is always the same. 
     * Because those appointments will repeat every month, year and time.
     */
    public boolean occursOn(int year, int month, int day) {
        if (this.day == day) {
            return true;
        } else {
            return false;
        }
    }
   

}
