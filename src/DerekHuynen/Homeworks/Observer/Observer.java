/**
 * Observer Interface
 * Homework Assignment: Observer
 *
 * @author Derek Huynen
 * @version 1.00 4/30/2020
 */

package DerekHuynen.Homeworks.Observer;

public interface Observer {

    /**
     * Update any changes to the observer
     * Observers are the people who will be alerted of a change
     * Is watching when the stocks will change
     */
    public void update(Subject subject);
}