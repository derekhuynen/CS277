/**
 * Subject
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
 * Subject.java
 *
 * Objects implementing this interface allow observers
 * to register with it. When this object changes state,
 * it notifies all registered observers.
 */
public interface Subject {

    /** allows an observer to register with the subject */
    public void addObserver( Observer o );

    /** removes an observer */
    public void removeObserver( Observer o );

    /** notifes all registered observers when its state changes */
    public void notifyObservers();
}