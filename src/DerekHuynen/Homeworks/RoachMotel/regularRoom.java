/**
 * motelRoomVisitorImp
 * Homework Assignment: Term Project
 *
 * @author Derek Huynen
 * @author David Chan
 * @author Serenity Brown
 * @author Justin Girgis
 *
 * @date 5/7/2020
 * @version 1.00
 */
package DerekHuynen.Homeworks.RoachMotel;

/**
 * This creates a concrete instance of the motelRooms class
 * Similar to the "Chocolate" class from Factory Project
 */
public class regularRoom extends motelRooms {

    //Cost of the Room
    private double roomCost;
    //Room Number
    private int roomNumber;

    /**
     * Default Constructor
     */
    public regularRoom() {
        this.roomCost = constants.REGULAR_ROOM_PRICE;
    }

    /**
     * Getter for the Description
     * @return the Description of the room as A String
     */
    @Override
    public String getDescription() {
        return "RegularRoom";
    }

    /**
     * Getter for the Cost
     * @return the cost of the Room
     */
    @Override
    public double getCost() {
        double amenityCosts = getAmenitiesCost();
        return this.roomCost + amenityCosts;
    }

    /**
     * Convert Regular Room class to a String
     * @return This class as a String
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Room Number: " + this.roomNumber + " " + getDescription() + ", Amenities: ");
        for (amenitiesDecorator ad : this.amenities) {
            str.append(ad.getDescription()).append(", ");
        }
        return String.format("%s. Cost: $%.2f",str.toString(),getCost());

    }

    /**
     * The Cleaning room String for this Room
     * @return A String for how this room is cleaned
     */
    @Override
    public String cleanRoomsString(){
        return "All linens have been cleaned and all of the towels on floor will be replaced";
    }

    /**
     * Getter for Room Number
     * @return roomNumber for this room
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Setter for Room Number
     * @param roomNumber to be set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}