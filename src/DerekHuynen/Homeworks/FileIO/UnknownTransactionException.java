/**
 * UnknownTransactionException
 * Homework Assignment: File I/O
 *
 * @author Derek Huynen
 * @date 3/12/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.FileIO;

public class UnknownTransactionException extends Exception{


    /**
     *	Default constructor
     */
    public UnknownTransactionException() {
        super();
    }
    /**
     * @param message of the exception
     */
    public UnknownTransactionException(String message) {
        super(message);
    }
    /**
     * overrides the toString()
     */
    public String toString() {
        return "UnknownTransactionException class";
    }
}
