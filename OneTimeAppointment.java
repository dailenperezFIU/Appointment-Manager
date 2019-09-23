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
public class OneTimeAppointment extends MonthlyAppointment {

    /**
     *  the year and month are attributes that are not inherited directly from 
     * the MonthlyAppointment class. Therefore they have to be declared in this class.
     */
   private int year ;
   private int month;
    
   /**
    * 
    *@param description String entered by user on what their appointment is for.
    * @param lastName String entered by user that has their last name
    * @param hours int representing the hour the appointment is at.
    * @param minutes int representing the minute the appointment is at.
    * @param day int representing they day the appointment will be on
    * @param year int representing they year the appointment will be on
    * @param month int representing they month the appointment will be on
    */
    public OneTimeAppointment(String description , String lastName , int hours , int minutes , int day, int year , int month){
    super(description , lastName , hours , minutes, day);
    this.year = year;
    this.month = month;
    
    }
  /**
   * 
   * @return year 
   */
    public int getYear() {
        return year;
    }
    /**
     * 
     * @param year changes the value of year instance variable to the value of
     * the parameter year.
     */

    public void setYear(int year) {
        this.year = year;
    }
/**
 * 
 * @return month
 */
    public int getMonth() {
        return month;
    }
/**
 * 
 * @param month  the new value this.month will be changed to.
 */
    public void setMonth(int month) {
        this.month = month;
    }
    
    /**
     * 
    * @param day int representing they day the appointment is for
    * @param year int representing they year the appointment is for
    * @param month int representing they month the appointment is for
    * @return boolean true if the date being searched exists and false if it doesn't 
     * find it
     */
   @Override
    public boolean occursOn(int year , int month , int day){
        if (getDay() == day && this.year == year && this.month == month){
        
            return true;
        }
        return false;
    
    }
   
   
}
