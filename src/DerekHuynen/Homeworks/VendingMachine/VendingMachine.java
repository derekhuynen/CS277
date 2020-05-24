/**
 * VendingMachine
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.VendingMachine;

import DerekHuynen.Homeworks.VendingMachine.Items.Coin;
import DerekHuynen.Homeworks.VendingMachine.Items.Inventory;
import DerekHuynen.Homeworks.VendingMachine.Items.Item;
import DerekHuynen.Homeworks.VendingMachine.Items.Product;

import javax.naming.InsufficientResourcesException;
import java.util.NoSuchElementException;

public class VendingMachine {

    /**
     * Inventory of Coins being Inserted into Vending Machine
     */
    private Inventory till;

    /**
     * Inventory of Coins being Inserted into Vending Machine
     */
    private Inventory profit;

    /**
     * Inventory of Products in the Vending Machine
     */
    private Inventory products;

    /**
     * Default Constructor for Vending Machine
     */
    public VendingMachine() {
        this.till = new Inventory("Till", Coin.values());
        this.profit = new Inventory("Profit", Coin.values());
        this.products = new Inventory("Products", Product.values());
    }

    /**
     * Add a Product to the Vending Machine
     * @param userInput of the product to be added as a String
     * @param quantity of the product to be added as a Int
     * @return a Container of the Product and the Total Amount in Vending Machine
     * @throws NoSuchElementException If no product can be Found
     */
    public Container addProduct(String userInput,int quantity) throws NoSuchElementException {
        Item item = ErrorThrower.search(products,userInput);
        item.setQuantity(item.getQuantity() + quantity);
        return new Container(item.getItem(),item.getQuantity());
    }

    /**
     * Buy a Product from the Vending Machine
     * @param userInput of the Product to be Bought as a String
     * @return Container of the Item being Bought and the Total Amount Left in Vending Machine
     * @throws InsufficientResourcesException Product is sold out
     * @throws NoSuchElementException If product cant be found
     */
    public Container buyProduct(String userInput) throws InsufficientResourcesException, NoSuchElementException {
        Item item = ErrorThrower.search(products,userInput);
        ErrorThrower.checkBalance(item,this.till.total());
        ErrorThrower.checkQuantity(item);
        item.setQuantity(item.getQuantity() - 1 );
        this.transferCoins();
        return new Container(item.getItem(),item.getQuantity());
    }

    /**
     * Insert Coin into the Vending Machine
     * @param userInput of the Coin being inserted into the Till as a String
     * @return Container of Coin being Inserted and the Total amount in Till
     * @throws NoSuchElementException If Coin cant be found
     */
    public Container insertCoin(String userInput) throws NoSuchElementException {
        Item item = ErrorThrower.search(till,userInput);
        item.setQuantity(item.getQuantity() + 1);
        return new Container(item.getItem(),till.total());
    }

    /**
     * Remove a Specific Coin from the Vending Machine
     * @param userInput of the coin being removed from the vending Machine as a String
     * @return Container of the Coin and the Total Value of those Coins
     * @throws CloneNotSupportedException if item can't be cloned
     * @throws InsufficientResourcesException if there zero Coin in Vending Machine
     */
    public Container removeCoin(String userInput) throws CloneNotSupportedException, InsufficientResourcesException{
        Item item = ErrorThrower.search(profit,userInput);
        ErrorThrower.checkQuantity(item);
        Item result = (Item) item.clone();
        item.setQuantity(0);
        return new Container(result.getItem(),result.getQuantity() * result.getItem().getValue());
    }

    /**
     * Transfer all Coins from till to Profit. Dont need to Calculate Change
     */
    private void transferCoins(){
        for( Item item : this.profit.getInventory().values()){
            Item profitItem = this.till.getInventory().get(item.getItem().getName().toLowerCase());
            item.setQuantity(item.getQuantity() + profitItem.getQuantity());
            profitItem.setQuantity(0);
        }
    }

    /**
     * Check to See if One Vending Machine is Equal to Another.
     * @param o Object being Compared
     * @return true if Vending Machine is the same
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VendingMachine))
            return false;
        VendingMachine c = (VendingMachine) o;
        return this.products.equals(c.products) && this.till.equals(c.till) && this.profit.equals(c.profit);
    }

    //PRINTERS
    /**
     * Proxy Till toString instead of Getter to Limit Access.
     * @return Till as a String
     */
    public String displayTill() {
        return this.till.toString();
    }

    /**
     * Proxy Product toString instead of Getter to Limit Access.
     * @return Product to String
     */
    public String displayProducts() {
        return this.products.toString();
    }

    /**
     * Proxy Profit toString instead of Getter to Limit Access.
     * @return Profit to String
     */
    public String displayProfit() {
        return this.profit.toString();
    }

    /**
     * Display Menu
     */
    public void menu(){
        Menu.menu(this);
    }

    /**
     * Vending Machine to a String
     * @return Vending Machine as a String
     */
    @Override
    public String toString() {
        return String.format("%s\n%s",products.toString(), till.toString());
    }

}


