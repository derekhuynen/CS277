/**
 * Item
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.VendingMachine.Items;


public class Item implements Cloneable{

    /**
     * An Item
     */
     private ItemInterface item;

    /**
     * The Quantity of the Item
     */
    private int quantity;

    /**
     * Default Constructor
     */
    public Item(){
        //Empty
    }

    /**
     * Item Constructor
     * Create a new Item for the Vending Machine
     * @param item of type ItemInterface
     */
    public Item(ItemInterface item){
        this.item = item;
        this.quantity = 0;
    }

    /**
     * Quantity Getter
     * @return quantity of item as an int
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * Quantity Setter
     * @param quantity to be set as Item Quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Clone Item
     * @return clone of the Item
     * @throws CloneNotSupportedException if Item Can't be cloned
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
            return super.clone();
    }

    /**
     * Proxy Item Name Getter
     * @return Name of the Item
     */
    public ItemInterface getItem() {
        return this.item;
    }

    /**
     * Checks to see if one Item Equals Another
     * @param o Other Item being Compared
     * @return true if Items are equal
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Item))
            return false;

        Item c = (Item) o;
        return this.item.getName().equals(c.item.getName()) && Double.compare(this.item.getValue(),c.item.getValue()) == 0;
    }

    /**
     * Item to a String
     * @return Item as a String
     */
    @Override
    public String toString() {
        return String.format("%s, Quantity: %d.",this.item.toString(), this.getQuantity());
    }
}
