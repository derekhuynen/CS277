/**
 * Refill Bar Amenity
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

public class refillBar extends amenitiesDecorator {

    //Cost of the Amenity
    private double amenityCost;

    /**
     * Default Constructor
     */
    public refillBar() {
        this.amenityCost = constants.REFILL_BAR_PRICE;
    }

    /**
     * Get the Description of this room
     * @return this Amenity as a String
     */
    @Override
    public String getDescription() {
        return this.toString();
    }

    /**
     * getter for the cost of the Amenity
     * @return cost of Amenity
     */
    @Override
    public double getCost() {
        return this.amenityCost;
    }

    /**
     * Return a String of the refillBar Class
     * @return refillBar as a String
     */
    @Override
    public String toString() {
        return "Auto-Refill Food Bar";
    }

}