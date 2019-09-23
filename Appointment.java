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
public abstract class Appointment {
    
    /**
     *  A person's last name , the description of the type of appointment they're
     * trying to schedule , the hour it will be at and the minutes it will be at.
     * All are necessary to make an appointment.
     */
    private String lastName;
    private String description;
    private int hours;
    private int minutes;
    
    /**
     * 
     * @param description String entered by user on what their appointment is for.
     * @param lastName String entered by user that has their last name
     * @param hours int representing the hour the appointment is at.
     * @param minutes int representing the minute the appointment is at.
     */
    
    public Appointment( String description, String lastName ,int hours , int minutes){
        this.description = description;
        this.lastName = lastName;
        this.hours = hours;
        this.minutes = minutes;
        
    }

   /**
     * 
     * @return a string version of all fields relevant in an appointment 
     * object.
    */
    
     public String toString() {
        return getDescription() + " with "+ getLastName()+ " at " + getHours() + ":" + getMinutes();
    }
    
   /**
    * 
    * @return the last name of the person making an appointment
    */

    public String getLastName() {
        return lastName;
    }
/**
 * 
 * @param lastName  the new value of the last name field of an appointment
 */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
/**
 * 
 * @return the description  of an appointment
 */
    public String getDescription() {
        return description;
    }

   /**
    * 
    * @param description the new value of the description of an appointment
    */ 
    public void setDescription(String description) {
        this.description = description;
    }
/**
 * 
 * @return the hours an appointment was made for.
 */
    public int getHours() {
        return hours;
    }
/**
 * 
 * @param hours the new values that will be stored in the hours field of appointments made.
 */
    public void setHours(int hours) {
        this.hours = hours;
    }
/**\
 * 
 * @return the minutes of any appointment made
 */
    public int getMinutes() {
        return minutes;
    }

    /**
     * 
     * @param minutes  the new value that will be saved into the appointment field minutes.
     */
    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

  /**
     * 
     * @param year int representing the year the appointment is during.
     * @param month int representing the month the appointment is during.
     * @param day int representing the day the appointment is during
     * @return  nothing yet because this method is abstract in this class.
     */
    public abstract boolean occursOn( int year , int month , int day);
    
    
}
