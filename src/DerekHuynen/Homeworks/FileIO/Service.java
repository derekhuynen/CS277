/**
 * Service
 * Homework Assignment: File I/O
 *
 * @author Derek Huynen
 * @date 3/12/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.FileIO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Service {

    private String name;
    private String service;
    private double amount;
    private String date;


    //Default Constructor
    public Service(){
        //Empty
    }

    /**
     * Constructor With all the Params
     * @param name of the Customer as a String
     * @param service being bought as a String
     * @param amount of Money the Service Costs as a double
     * @param date of the Serive as a String (DD/MM/YYYY)
     */
    public Service(String name, String service, double amount, String date){
        this.name = name;
        this.service = service;
        this.amount = amount;
        this.date = date;
    }


    /**
     * Check if the Date the UserInputs is Valid
     * @param userInput of a Date
     * @return True if it is a Valid Date (MM/DD/YYYY)
     */
    public static boolean checkDate(String userInput){
        boolean result = true;
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(userInput);
        } catch (ParseException e) {
            System.out.printf("Date %s is not valid format. Try  MM/dd/yyyy, (01/01/2000)\n",userInput);
            result = false;
        }
        return result;
    }


    /**
     * Check to make sure Service Is Valid
     * @param userInput of a service
     * @return True if service is Offered
     */
    public static boolean checkService(String userInput){

        String[] services = new String[]{ "breakfast","lunch", "dinner","conference","tea","massage","cleaning"};
        try{
            for (String temp : services){
                if(userInput.toLowerCase().equalsIgnoreCase(temp))
                    return true;
            }

            throw new NoSuchElementException();

        } catch(NoSuchElementException e) {
            System.out.printf("The service %s is not offered at this Location. \n" +
                    "Services Offered: %s\n",userInput, Arrays.toString(services));
        }

        return false; // Using two returns here is just easier IMO
    }


    /**
     * Check to make sure the AMount the User Entered is Valid
     * @param userInput of the amount
     * @return True if amount is a Valid double
     */
    public static boolean checkAmount(String userInput) {
        boolean result = true;

        try {
            Double num = Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            System.out.println("Not a Valid Amount. Try format \"10.22\", without a $ sign");
            result = false;
        }
        return result;
    }

    /**
     * Service Getter
     * @return service name as a String
     */
    public String getService() {
        return service;
    }


    /**
     * Check to see if One service is equal to another.
     * @param o the Other Service being compared
     * @return true if they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Service))
            return false;
        Service c = (Service) o;
        return this.name.equals(c.name) && this.service.equals(c.service) && this.amount == c.amount && this.date.equals(c.date);
    }

    /**
     * Override to string Method
     * @return Service Object as a String
     */
    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s",this.name,this.service,this.amount,this.date);
    }
}
