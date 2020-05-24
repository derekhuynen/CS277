package DerekHuynen.Labs.Momento;
import java.util.*;

/**
 * CareTaker
 * Lab Assignment: Memento
 *
 * @author Derek Huynen
 * @date 3/20/2020
 * @version 1.00
 */
public class CareTaker {
    private List<Section.Memento> mlist = new ArrayList<>();

    public void add(Section.Memento m) {
        mlist.add(m);
    }

    /**
     * Retrieve a particular memento from the list of mementos that we have.
     * @param	index	The memento that you want.  The numbering starts at 0.
     * 					If you run off the end of the ArrayList, you will throw
     * 					an exception.
     * @return			The Section instance requirested.
     */
    public Section.Memento get(int index) {
        return mlist.get(index);
    }
}