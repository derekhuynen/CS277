/**
 * Inventory
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.DesigningClasses.Items;


import java.util.HashMap;
import java.util.Map;


public class Inventory {

    /**
     * HashMap of Name of Item and Item Itself
     */
    private Map<String, Item> inventory = new HashMap<>();

    /**
     * Name of Inventory For Easy Console Outputs
     * Could maybe change to get ClassName() or maybe instance of
     */
    private String name;

    /**
     * Default Constructor
     */
    public Inventory(){
        //Empty
    }

    /**
     * Inventory Constructor
     * Create a HashHap of the Items Name and the Items themselves
     * @param items to be added to Inventory as an array
     */
    public Inventory(String name, ItemInterface[] items) {
        this.name = name;
        for (ItemInterface item : items){
            this.inventory.put(item.getName().toLowerCase() , new Item(item));
        }
    }

    /**
     * Inventory getter
     * @return inventory
     */
    public Map<String, Item> getInventory() {
        return this.inventory;
    }

    /**
     * Name Getter
     * @return Name of Inventory
     */
    public String getName() {
        return name;
    }

    /**
     * Calculates Total Value of All Items
     * @return the total Value of all items as a double
     */
    public double total() {
        double total = 0;
        for (Item item : this.inventory.values()){
            total += (item.getItem().getValue() * item.getQuantity());
        }
        return total;
    }

    /**
     * Check to see if one Inventory Equals Another
     * @param o Other Inventory being Compared
     * @return true if the Inventories are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Inventory))
            return false;
        Inventory c = (Inventory) o;
        return this.name.equals(c.name) && this.inventory.equals(c.inventory);
    }

    /**
     * Inventory to a String
     * @return Inventory to a String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n").append(this.name).append(":");
        for(Item item : this.inventory.values()){
            result.append("\n").append(item.toString());
        }
        return result.toString();
    }
}

