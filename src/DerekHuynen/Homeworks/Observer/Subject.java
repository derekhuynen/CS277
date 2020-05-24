/**
 * Subject Interface
 * Homework Assignment: Observer
 *
 * @author Derek Huynen
 * @version 1.00 4/30/2020
 */

package DerekHuynen.Homeworks.Observer;

public interface Subject {

    /**
     * Subscribe an Agent to this stock
     * @param observer The Agent being subscribed as type Observer
     * @return True if agent is added False if agent already exists
     */
    public boolean registerObserver(Observer observer);

    /**
     * Unsubscribe an Agent to this stock
     * @param observer The Agent being unsubscribed as type Observer
     * @return True if agent is removed; False if agent doesn't exist
     */
    public boolean removeObserver(Observer observer);

    /**
     * Notify all Observers Subscribed that subject has changed.
     */
    public void notifyObservers();
}

