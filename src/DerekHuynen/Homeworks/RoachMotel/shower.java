/**
 * Shower Amenity Class
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

public class shower extends amenitiesDecorator {

    //Cost of this amenity
    private double amenityCost;

    /**
     * Default Constructor
     */
    public shower() {
        this.amenityCost = constants.SHOWER_PRICE;
    }

    /**
     * Getter for the Description
     * @return this class in String Form
     */
    @Override
    public String getDescription() {
        return this.toString();
    }

    /**
     * Getter for Cost
     * @return cost as a double
     */
    @Override
    public double getCost() {
        return this.amenityCost;
    }

    /**
     * Convert Class to a String
     * @return string Version of this class
     */
    @Override
    public String toString() {
        return "Spray-Resistant Shower";
    }

}