package DerekHuynen.Demo.InterfaceDemo;

/** The possible gears that a GearedVehicle might be in.  Note that Bicycles cannot be in revers
 * nor park, and cars cannot be in any gear higher than 5th.
 * @author	David Brown
 * @date	July 10th, 2019
 */
public enum Gears {
    //The value that I give these is the gear number.
    PARK(0), REVERSE(-1), FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGHTH(8),
    NINTH(9), TENTH(10), ELEVENTH(11), TWELTH(12), THIRTEENTH(13), FOURTEENTH(14), FIFTEENTH(15);

    /** The integer value of the gear, for easy computation later. */
    private final int value;

    /**
     * Constructor for the enumeration.  This only runs at compile time, so making it private actually
     * makes sense since we can never add or remove objects from an enumeration class while the application
     * is running.  At compile time, the constructor runs for each of the Gears listed above.
     * @param gear	The integer value of the particular Gear.
     */
    private Gears (final int gear) {
        //Save the gear number with this one.
        value = gear;
    }

    /**
     * Retrieve the current gear that we're in.
     * @return	The gear that we're in.
     */
    public int getValue () { return value; }
}
