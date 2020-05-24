/**
 * motelRoomVisitorImp
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
 * Observers implement this interface so that
 * their update() method is called by the subject
 * when the state of the subject changes.
 */
public interface Observer {
    /**
     * This method is called when the state of the subject
     * changes.
     * @param newState - the new state of the subject
     */
    public void update(Object newState);
}