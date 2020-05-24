package DerekHuynen.Demo.InterfaceDemo;

/**
 * If a vehicle can change speed, it's likely going to be shifting gears.  Hence, the ShiftingVehicle
 * extends SpeedUpSlowDown.  On the other hand, just because it can SpeedUpSlowDown does not mean that
 * it has gear shifting capability.  Skateboards and blade skates, for instance, can change speed without
 * being able to change gears.
 * @author 	David Brown
 * @date	07/10/2019
 *
 */
public interface ShiftingVehicle extends SpeedUpSlowDown {
    /**
     * Find out what gear the ShiftingVehicle is in.
     * @return	The current gear.
     */
    public Gears getCurrentGear ();

    /**
     * Change gears.
     * @param newGear	The new gear to shift to.  Note, do not use a negative number here.
     */
    public void changeGears (Gears newGear);

}
