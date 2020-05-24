/**
 * Bid Class
 * Homework Assignment: Observer
 *
 * @author Derek Huynen
 * @version 1.00 4/30/2020
 */

package DerekHuynen.Homeworks.Observer;


/**
 * Bid class that take a bid for a specific stock
 */
public class Bid {

    /**
     * THe stock being bid on
     */
    private Stock stock;
    /**
     * Amount of shares being bought and sold
     */
    private int amountOfShares;

    /**
     * Type of Transaction
     */
    private TransactionType transactionType;


    /**
     * Bid is passing in a stock that it is going to place a bid on
     * @param stock
     */
    public Bid(Stock stock, int amountOfShares,TransactionType transactionType){
        this.stock = stock;
        this.amountOfShares = amountOfShares;
        this.transactionType = transactionType;
        this.stock.trade(this);
    }

    /**
     * Bid to String
     * @return a string version of the bid
     */
    @Override
    public String toString() {
        return String.format("Bid - Symbol: %s %s %d shares for the amount of: %.2f",stock.toString(),transactionType.toString(),this.amountOfShares,this.stock.getDollarAmount()* this.amountOfShares);
    }
}
