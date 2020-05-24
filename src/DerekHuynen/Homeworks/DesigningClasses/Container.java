/**
 * Container
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */
package DerekHuynen.Homeworks.DesigningClasses;


import DerekHuynen.Homeworks.DesigningClasses.Items.ItemInterface;

public class Container {

    /**
     * Item in Vending Machine
     */
    ItemInterface item;

    /**
     * Total meaning Different things
     */
    double total;

    /**
     * Default Constructor
     */
    public Container(){
        //Empty
    }

    /**
     * Container Constructor with ItemInterface and total
     * @param item in the Vending Machine
     * @param total Means different things
     */
    public Container(ItemInterface item, double total){
        this.item = item;
        this.total = total;
    }

    /**
     * Total Getter
     * @return Total
     */
    public double getTotal() {
        return total;
    }

    /**
     * Item Getter
     * @return item in Vending Machine
     */
    public ItemInterface getItem() {
        return item;
    }


    /**
     * Check and see if one Container equals Another
     * @param o the Object being Compared
     * @return true if Containers are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Container))
            return false;

        Container c = (Container) o;

        return this.item.equals(c.getItem()) && Double.compare(this.total,c.getTotal()) == 0;
    }

    /**
     * Container to a String
     * @return String of a Container
     */
    @Override
    public String toString() {
        return String.format("%s, Total:%s",this.item,total);
    }

}
