package DerekHuynen.Demo.InterfaceDemo;

/** A Shiftable vehicle without an engine. */
public class Bicycle extends GearedVehicle {

    public Bicycle (String name) {
        super(name);
    }

    @Override
    public void changeGears (Gears newGear) {
        if (newGear == Gears.PARK || newGear == Gears.REVERSE) {
            throw new IllegalArgumentException ("Bicycles don't have a reverse or park!");
        }
        super.changeGears(newGear);
    }
}
