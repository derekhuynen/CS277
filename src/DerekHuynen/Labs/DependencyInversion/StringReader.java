/**
 * String Reader Interface
 * Lab: CECS 277 Lab Dependency Inversion
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Labs.DependencyInversion;

public interface StringReader {
    /**\
     * Get Input from user
     * @return user input as String
     */
    String getValue();

    /**
     * Check if there is next word
     * @return true if has next
     */
    boolean hasNext();
}
