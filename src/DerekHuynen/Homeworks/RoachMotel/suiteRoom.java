/**
 * SuiteRoom
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
 * @author Parth
 */
public class suiteRoom extends motelRooms {

    //Cost of the Room
    private double roomCost;

    //Room Number of Room
    private int roomNumber;

    //Default Constructor
    public suiteRoom() {
        this.roomCost = constants.SUITE_ROOM_PRICE;
    }

    /**
     * Getter for the Description of the Room
     * @return the description of the room
     */
    @Override
    public String getDescription() {
        return "Suite";
    }

    /**
     * Getter for Cost of the room
     * @return cost of room
     */
    @Override
    public double getCost() {
        double amenityCosts = getAmenitiesCost();
        return this.roomCost + amenityCosts;
    }

    /**
     * Getter for room number
     * @return room number
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * setter for Room Number
     * @param roomNumber to be set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Cleaning room string for this room
     */
    @Override
    public String cleanRoomsString(){
        return "All linens will be cleaned, all towels will be changed and a hamburger will be place on each pillow.";
    }

    /**
     * Convert this class to a String
     * @return string version of this class
     */
    public String toString() {
        StringBuilder str = new StringBuilder("Room Number: " + this.roomNumber + " " + getDescription() + ", Amenities: ");
        for (amenitiesDecorator ad : this.amenities) {
            str.append(ad.getDescription()).append(", ");
        }
        return String.format("%s. Cost: $%.2f",str.toString().substring(0,str.length()-2),getCost());
    }
}
