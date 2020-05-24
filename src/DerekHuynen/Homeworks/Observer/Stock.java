/**
 * Stock Class
 * Homework Assignment: Observer
 *
 * @author Derek Huynen
 * @version 1.00 4/30/2020
 */
package DerekHuynen.Homeworks.Observer;

import java.util.ArrayList;

/**
 * Stock class that implements Subject
 *  Contains a lists of agents that have subscribed and notifies them when stock gets a new bid
 */
public class Stock implements Subject{

    /**
     * List of agents/Subjects that have registered to this stock
     */
    private ArrayList<Observer> observers;

    /**
     * The latest bid placed on this stock
     */
    private Bid bid;


    /**
     * Nam eof the Stock
     */
    private String stockName;

    /**
     * Amount the stock is worth **Never changes**
     */
    private double dollarAmount;


    /**
     * Stock Constructor
     * @param stockName name of the stock
     * @param dollarAmount Amount the stock is worth
     */
    public Stock(String stockName, double dollarAmount){
        this.stockName = stockName;
        this.dollarAmount = dollarAmount;
        this.observers = new ArrayList<>();
    }

    /**
     * Updates bbid to the latest bid for this stock
     * @param bid to be updated in stock class
     */
    public void trade(Bid bid){
        this.bid = bid;
        this.notifyObservers();
    }

    /**
     * Bid getter
     * @return the instance of bid
     */
    public Bid getBid(){
        return this.bid;
    }

    /**
     * Getter for stock amount
     * @return the dollar amount of this stock
     */
    public double getDollarAmount(){

        return this.dollarAmount;
    }

    /**
     * Subscribe an Agent to this stock
     * @param observer The Agent being subscribed as type Observer
     * @return True if agent is added False if agent already exists
     */
    @Override
    public boolean registerObserver(Observer observer) {
        if(observers.contains(observer)){
            return false;
        }else{
            observers.add(observer);
            return true;
        }
    }

    /**
     * UnSubscribe an Agent to this stock
     * @param observer The Agent being unsubscribed as type Observer
     * @return True if agent is removed False if agent doesn't exist
     */
    @Override
    public boolean removeObserver(Observer observer) {
        if(observers.contains(observer)){
            observers.remove(observer);
            return true;
        }else{
            return false;
        }
    }

    /**
     * Notify all Observers subscribed that Stock has been updated
     */
    @Override
    public void notifyObservers() {
        for(Observer next: this.observers){
            next.update(this);
        }
    }

    /**
     * Stock to a String
     * @return stock as a String
     */
    @Override
    public String toString() {
        return String.format("%s",this.stockName);
    }
}
