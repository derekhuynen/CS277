/**
 * ErrorThrower
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */
package DerekHuynen.Homeworks.DesigningClasses;


import DerekHuynen.Homeworks.DesigningClasses.Items.Inventory;
import DerekHuynen.Homeworks.DesigningClasses.Items.Item;

import javax.naming.InsufficientResourcesException;
import java.util.NoSuchElementException;

public  class ErrorThrower {

    /**
     * Search Inventory Map for a certain Item
     * @param inventory the being searched
     * @param userInput the item being searched for as a String
     * @return Item being searched
     * @throws NoSuchElementException if Item can't be found
     */
    public static Item search(Inventory inventory, String userInput) throws NoSuchElementException {
        Item result = inventory.getInventory().get(userInput.toLowerCase().trim());
        if(result == null)
            throw new NoSuchElementException(String.format("No %s found in %s.",userInput,inventory.getName()));
        return result;
    }

    /**
     * Make Sure User Has Enough Money to Buy a Product
     * @param item the Product being purchased
     * @param balance the users Total Balance
     * @throws InsufficientResourcesException if User Doesn't have enough funds
     */
    public static void checkBalance(Item item, double balance) throws InsufficientResourcesException {
        if (balance < item.getItem().getValue())
            throw new InsufficientResourcesException(String.format("Not Enough Money. %s. User has $%.2f",item.getItem(),balance));
    }

    /**
     * Check to Make Sure Item Quantity is greater than 0
     * @param item being checked
     * @throws InsufficientResourcesException if Item Quantity is greater than Zero
     */
    public static void checkQuantity(Item item) throws InsufficientResourcesException {
        if (item.getQuantity() < 1)
            throw new InsufficientResourcesException(String.format("Vending Machine has Zero %ss",item.getItem().getName()));
    }
}
