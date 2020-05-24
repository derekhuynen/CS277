/**
 * RoachMotel
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
 * This is the abstract class forming the basis of our factor
 */
public abstract class amenitiesDecorator extends motelRooms {

    /**
     * Abstract method to get the description of the different
     * amenities associated with the room
     * @return A description as a Sting
     */
    public abstract String getDescription();
}