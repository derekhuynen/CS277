/**
 * ObserverRunner
 * Homework Assignment: Observer
 *
 * @author Derek Huynen
 * @version 1.00 4/30/2020
 */

package DerekHuynen.Homeworks.Observer;

public class ObserverRunner {

    public static void main(String[] args) {

        //Create Stocks
        Stock stock1 = new Stock("AA", 300.34);
        Stock stock2 = new Stock("BoA", 200.87);
        Stock stock3 = new Stock("TRIX", 100.87);

        //Create Agents
        Agent tom = new Agent("Tom Clancey");
        Agent robert = new Agent("Robert Mitchner");
        Agent noah = new Agent("Noah Ben Shea");
        Agent richard = new Agent("Richard Rohr");

        //Subscribe
        stock1.registerObserver(tom);
        stock1.registerObserver(richard);
        stock1.registerObserver(noah);

        stock2.registerObserver(robert);
        stock2.registerObserver(richard);
        stock2.registerObserver(tom);

        stock3.registerObserver(tom);

        //Unsubscribe
        stock2.removeObserver(tom);

        //Make Bids
        new Bid(stock1,8, TransactionType.BUY);
        new Bid(stock2,7, TransactionType.SELL);
        new Bid(stock3,9, TransactionType.SELL);
    }
}
