/**
 * TransactionType Enum Class
 * Homework Assignment: Observer
 *
 * @author Derek Huynen
 * @version 1.00 4/30/2020
 */

package DerekHuynen.Homeworks.Observer;

public enum TransactionType {
    /**
     * Buying enum
     */
    BUY{
        @Override
        public String toString(){

            return "buying";
        }

    },
    /**
     * Selling enum
     */
    SELL{
        @Override
        public String toString(){

            return "selling";
        }

    }

}
