/**
 * Spa Amenity Class
 * Homework Assignment: Term Project
 *
 * @author Derek Huynen
 * @author David Chan
 * @author Serenity Brown
 * @author Justin Girgis
 *
 * @date 5/7/2020
 * @version 1.00
 */
package DerekHuynen.Homeworks.RoachMotel;

public class spa extends amenitiesDecorator {


    //Cost of the Spa
    private double amenityCost;

    /**
     * Default Constructor
     */
    public spa() {
        this.amenityCost = constants.SPA_PRICE;
    }

    /**
     * getter for the description
     * @return the description of the Spa
     */
    public String getDescription() {
        return this.toString();
    }

    /**
     * Getter for Cost of Spa
     * @return Cost of the Spa
     */
    public double getCost() {
        return this.amenityCost;
    }

    /**
     * Converts THis class to a String
     * @return string version of spa
     */
    public String toString() {
        return "Spa";
    }
}