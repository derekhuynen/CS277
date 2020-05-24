/**
 * Product Enum
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.DesigningClasses.Items;


public enum Product implements ItemInterface {
    DIET_COKE(1.25,"Diet Pepsi"),
    WATER(1.00,"Water"),
    MARS_BAR(0.65,"Mars Bar"),
    M_AND_MS(0.65,"M&M's"),
    POPCORN(1.5,"Popcorn");

    /**
     * Price of the Product
     */
    private final double value;

    /**
     * Name of the Product
     */
    private final String name;


    /**
     * Product Enum Constructor
     * @param value of the Product as a double
     * @param name of the Product as a String
     */
    Product(double value, String name){
        this.value = value;
        this.name = name;
    }

    /**
     * Name Getter
     * @return name of the Product as a String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Price Getter
     * @return price of the Product as double
     */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * Coverts Product Object to a String
     * @return String of the Product "Popcorn, Price: 1.00"
     */
    @Override
    public String toString() {
        return String.format("%s, Price: $%.2f", getName(), getValue());
    }

}


