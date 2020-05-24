/**
 * Ranks enum.
 * Homework Assignment: GameOfWar
 *
 * @author Julien Delane
 * @author Derek Huynen
 * @version 1.00 29/01/2020
 */

package DerekHuynen.Homeworks.GameOfWar.Card;

/**
 * Enum that list all the ranks of card possible.
 */
public enum Ranks {

    TWO(0, "2"),
    THREE(1, "3"),
    FOUR(2, "4"),
    FIVE(3, "5"),
    SIX(4,"6"),
    SEVEN(5, "7"),
    HEIGHT(6, "8"),
    NINE(7, "9"),
    TEN(8, "10"),
    JACK(9, "Jack"),
    QUEEN(10, "Queen"),
    KING(11, "King"),
    ACE(12, "Ace");

    /**
     * Int to compare the different ranks easily.
     */
    private final int value;

    /**
     * Printed name of this rank.
     */
    private final String name;

    /**
     * Ranks constructor.
     *
     * @param value, int to compare the ranks
     * @param name, printed name
     */
    Ranks(int value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Get the value.
     *
     * @return rank of the card in int
     */
    public int getValue() { return value; }

    /**
     * Overriding toString.
     *
     * @return printed name of the suit
     */
    @Override
    public String toString() {
        return name;
    }
}
