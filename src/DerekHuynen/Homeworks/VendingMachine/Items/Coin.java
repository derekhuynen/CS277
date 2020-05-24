/**
 * Coin Enum
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.VendingMachine.Items;

public enum Coin implements ItemInterface {
    PENNY(0.01, "Penny"),
    NICKEL(0.05, "Nickel"),
    DIME(0.10, "Dime"),
    QUARTER(0.25, "Quarter"),
    HALF_DOLLAR(0.50,"Half Dollar"),
    DOLLAR(1.00, "Dollar");

    /**
     * The Value of the Coin
     */
    private final double value;

    /**
     * The Name of the Coin
     */
    private final String name;


    /**
     * Coin enum Constructor
     * @param value of the Coin as double
     * @param name of the Coin as String
     */
    Coin(double value, String name){
        this. value = value;
        this.name = name;
    }

    /**
     * Value Getter
     * @return value of the Coin as double
     */
    @Override
    public double getValue(){
        return this.value;
    }

    /**
     * Name Getter
     * @return name of the Coin as String
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * Coin Object to a String
     * @return String of the Coin "Penny, Value: 0.01"
     */
    @Override
    public String toString() {
        return String.format("%s, Value: $%.2f", getName(), getValue());
    }

}
