/**
 * foodBar
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

/**
 * A class for the foodBar amenity
 */
public class foodBar extends amenitiesDecorator {

    //Cost of foodBar
    private double amenityCost;

    /**
     * Default Constructor
     */
    public foodBar() {
        this.amenityCost = constants.FOOD_BAR_PRICE;
    }

    /**
     * Get the Description
     * @return a Description as a String
     */
    public String getDescription() {
        return this.toString();
    }

    /**
     * Geeting for the cost
     * @return cost as a double
     */
    public double getCost() {
        return this.amenityCost;
    }

    /**
     * Return foodBar class as a String
     * @return FoodBar as A String
     */
    public String toString() {
        return "food bar";
    }
}