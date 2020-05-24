package DerekHuynen.Demo.InterfaceDemo;

/**
 * A 4 wheeled vehicle for transporting a small number of people and a small amount of cargo
 * from place to place on land.
 * @author	David Brown
 * @date	September 19th, 2019
 */
public class Automobile extends GearedVehicle{
    public final int MAXGEAR = 5;

    /**
     * Constructor for our Automobile class.
     * @param name	The identifying name of the automobile.
     */
    public Automobile(String name) {
        super(name);
    }

    /**
     * Change the gears to a new gear.
     * @param	newGear		The gear to shift to.
     */
    @Override
    public void changeGears (Gears newGear) {
        if (newGear.getValue() > MAXGEAR) {				//They think that they have a bicycle here
            throw new IllegalArgumentException ("You cannot put a car into " + newGear.name() +
                    " gear.  This isn't a bicycle!");
        }

    }

}
