package DerekHuynen.Demo.InterfaceDemo;

/**
 * Any class that can speed up or slow down and has a name can implement this interface.
 * @author	David Brown
 * @date	July 10, 2019
 * @note	We also bring in the Name interface.
 */
public interface SpeedUpSlowDown extends WhatsMyName {
    /**
     * Allows the object to increase its speed.  Note that the direction is unspecified.
     * @param increment		The amount of speed increase needed.  Do not put anything < 0 here.
     */
    public default void speedUp (int increment) {
        if (increment < 0) {
            throw new IllegalArgumentException ("Speed increment must be > 0!");
        }
    };
    /**
     * Allows the object to decrease its speed.  Note that the direction is unspecified.
     * @param increment		The amount of speed decrease needed.  Do not put anything < 0 here.
     */
    public default void slowDown (int decrement) {
        if (decrement < 0) {
            throw new IllegalArgumentException ("Speed increment must be > 0!");
        }
    }
}