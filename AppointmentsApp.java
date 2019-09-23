/**  * 
 * @author (5760414) *
 *  Title:            (Appointment Hierarchy)*
 * Semester:         COP3337 - Fall 2018*
 * Lecturer's Name:  (Charters)*
 * Description of Program’s Functionality:
 *   Program allows user to make and check one time , daily as well as monthly 
 * appointments for their desired events..** 
 */ 
package appointmentsapp;

import java.util.Scanner;

/**
 *
 * 
 */
public class AppointmentsApp {

    /**
     Instantiates variables needed to make an appointment as well as an array of appointments
     
     **/
    static Scanner scan = new Scanner(System.in);

    public Appointment[] myAppointments;
    static int year=0, month=0, day=0, currentSize = 0, hours=0, minutes=0;
    String lastName, description;
    static AppointmentsApp app = new AppointmentsApp();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        app.makeAppointment();
        app.checkAppointment();

    }
/**
 *   Asks user questions to schedule them an appointment . Afterwards it makes 
 * the appointment for the user once they have entered valid inputs according to
 * the instructions and there isn't an appointment already scheduled for that same time.
 */
    public void makeAppointment() {
        int i = 0;
        int appNum;

        do {
            System.out.println("How many appointments do you wish to make?");
            appNum = scan.nextInt();
            scan.nextLine();
            // ask name , descriptin year.....
            myAppointments = new Appointment[appNum];

        } while (appNum < 0);

        while (i < appNum) {

            System.out.println("Enter the appointment type you wish to schelude"
                    + " ?\n1) One Time Appointment\n2) Daily "
                    + "Appointment \n3) Monthly Appointment ");
            int appType = scan.nextInt();
            scan.nextLine();
           
            System.out.println("What is a good description of your appointment?");
            description = scan.nextLine();

            System.out.println("What is your last name?");
            lastName = scan.nextLine();
            
            System.out.println("What is the year of the appointment you want to make ?");
            year = scan.nextInt();
            scan.nextLine();

            do{
            System.out.println("What is the month you want your appointment in?");
            month = scan.nextInt();
            scan.nextLine();
            }while(month >12 || month <1 );
            
            do{
            System.out.println("What is the day you want you appointment to be on?");
            day = scan.nextInt();
            scan.nextLine();
             } while(day >31 || day <1 );
             
           do{
            System.out.println("What is the hour you want your appointment to be on?"
                    + "\nPlease enter it in military time format");
            hours = scan.nextInt();
            scan.nextLine();
           }while(hours >23 || hours < 0 );
             
            do {
            System.out.println("What is the minutes you want your appointment to be on?");
            minutes = scan.nextInt();
            scan.nextLine();
            }while(minutes > 59 || minutes < 0 );
             
            switch (appType) {
                case 1:

                    OneTimeAppointment oneTime = new OneTimeAppointment(description, lastName, hours, minutes, day, year, month);

                    app.validTime(oneTime, appType);

                    myAppointments[i] = oneTime;

                    currentSize++;

                    System.out.println("Appointment added with " + lastName + " on " + day + "/" + month + "/" + year + " at " + hours + ":" + minutes + "\n");

                    break;
                case 2:

                    DailyAppointment daily = new DailyAppointment(description, lastName, hours, minutes);

                    app.validTime(daily, appType);

                    myAppointments[i] = daily;

                    currentSize++;

                    System.out.println("Appointment added with " + lastName + " Daily at " + hours + ":" + minutes + "\n");

                    break;
                case 3:

                    MonthlyAppointment monthly = new MonthlyAppointment(description, lastName, hours, minutes, day);

                    app.validTime(monthly, appType);

                    myAppointments[i] = monthly;

                    currentSize++;
                    System.out.println("Appointment added with " + lastName + " Monthly " + day + "at " + hours + ":" + minutes + "\n");

                    break;
                default:
                    System.out.println("Your selection of appointment type was invalid");
            }
            i++;

        }

    }
/**
 * 
 * @param anAppType the Appointment type object whose appointment hour and minute 
 * will be checked.
 * 
 * @param appType the number input by the user to select if appointment would be 
 * one time , daily or monthly.
 * 
 * Checks every appointment passed to it against every other already in the array 
 * If the hour and minutes of the appointment passe are already taken then it makes the 
 * user enter them again until they are unique.
 */
    public void validTime(Appointment anAppType, int appType) {

        if (anAppType.occursOn(year, month, day)) {
            for (int j = 0; j < currentSize; j++) {

                while (myAppointments[j].getHours() == anAppType.getHours() && myAppointments[j].getMinutes() == anAppType.getMinutes()) {

//                   
                    System.out.println("There is already an appointment scheduled for this time.");
                    System.out.println(" Type a different hour for your appointment");
                    hours = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Type different minutes for your appointment");
                    minutes = scan.nextInt();
                    scan.nextLine();

                    switch (appType) {
                        case 1:
                            anAppType = new OneTimeAppointment(description, lastName, hours, minutes, day, year, month);
                            break;
                        case 2:
                            anAppType = new DailyAppointment(description, lastName, hours, minutes);
                            break;
                        case 3:
                            anAppType = new MonthlyAppointment(description, lastName, hours, minutes, day);
                            break;
                        default:

                    }
                }

            }

        }
    }
/**
 * Checks whether an appointment exists for whichever date the user specified and prints all
 * appointments for that day.If appointment wasn't found then it states it and asks
 * the user if they want to search for more appointments. 
 * 
 */
    public void checkAppointment() {
        String checkAgain = "yes";

        while (checkAgain.equalsIgnoreCase("yes")) {
            System.out.println("\nWhat is the year of the appointment you want to check ?");
            year = scan.nextInt();
            scan.nextLine();

            System.out.println("What is the month of the appointment you want to check ?");
            month = scan.nextInt();
            scan.nextLine();

            System.out.println("What is the day of the appointment you want to check ?");
            day = scan.nextInt();
            scan.nextLine();

            boolean found = false;
            System.out.println("On " + month + "/" + day + "/" + year + " you have the following appointments:\n");
            for (int i = 0; i < currentSize && !found; i++) {

                if (myAppointments[i].occursOn(year, month, day)) {

                    System.out.println(myAppointments[i].toString());
                    found = true;
                } 
            }
            if (found == false) {
                System.out.println(" The appointment you were searching for wasn't found.\n");
            }
            System.out.println("Do you wish to look up another date?\nEnter yes to continue anything else to stop.");
            checkAgain = scan.nextLine();

        }
        System.out.println("Thank you for using your appointment calendar !");
    }


}
