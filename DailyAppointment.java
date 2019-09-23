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
public class DailyAppointment extends Appointment{
    
    /**
     * 
     * @param description String entered by user on what their appointment is for.
     * @param lastName String entered by user that has their last name
     * @param hours int representing the hour the appointment is at.
     * @param minutes int representing the minute the appointment is at.
     */
    public DailyAppointment(String description, String lastName ,int hours , int minutes){
        super(description,lastName, hours, minutes);
   
        
    }
   
  
    /**
     * 
     * @param year int representing the year the appointment is during.
     * @param month int representing the month the appointment is during.
     * @param day int representing the day the appointment is during
     * @return  boolean that is true for daily because those appointments will
     * repeat every year, month and day.
     */
    @Override
    public boolean occursOn(int year , int month, int day){
    
       
                return true;
        
    }
    
    
}
