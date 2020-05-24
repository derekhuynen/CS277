package DerekHuynen.Demo.InterfaceDemo;

/**
 * A vehicle that can change speed, can compare names, and shift gears.
 */
public abstract class GearedVehicle implements MyComparable, ShiftingVehicle {
    /** The name of this particular vehicle.  We name all of our cars. */
    private String name;

    @Override
    public void setName (String newName) {this.name = newName; }

    @Override
    public String getName () {return this.name;}

    int presentSpeed;
    @Override
    public void speedUp (int increment) {
        //Apparently, we cannot use the default speedUp method defined in the SpeedUpSlowDown
        //interface because that is coming down directly from SpeedUpSlowDown as you would think,
        //but also through ShiftingVehicle which makes it a "grandparent interface" which means
        //that we cannot access it.
        //SpeedUpSlowDown.super.speedUp(increment);
        if (increment < 0) {
            throw new IllegalArgumentException ("Speed up incrment must be > 0!");
        }
        presentSpeed = presentSpeed + increment;
    }
    @Override
    public void slowDown (int decrement) {
        if (decrement < 0) {
            throw new IllegalArgumentException ("Speed up incrment must be > 0!");
        }
        this.presentSpeed = this.presentSpeed - decrement;
    }

    public GearedVehicle (String name) {
        setName (name);
        this.presentSpeed = 0;
        this.gear = Gears.PARK;
    }

    /** The gear that we are in currently */
    private Gears gear;

    @Override
    public String toString () {
        return this.getClass().getName() + " with name: " + this.getName() + " at speed: " + this.presentSpeed +
                " in gear " + this.gear.name();
    }
    @Override
    public Gears getCurrentGear() {
        return this.gear;
    }
    @Override
    public void changeGears(Gears newGear) {
        this.gear = newGear;
    }
}