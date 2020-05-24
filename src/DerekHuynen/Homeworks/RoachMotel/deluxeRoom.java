/**
 * RoachMotel
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
 *
 */
public class deluxeRoom extends motelRooms {

    //Cost of the Room
    private double roomCost;
    //Room Number of the room
    private int roomNumber;

    /**
     * Default constructor, sets room cost = 75.00
     */
    public deluxeRoom() {
        roomCost = constants.DELUXE_ROOM_PRICE;
    }

    /**
     * Description of room
     * @return String "deluxe"
     */
    @Override
    public String getDescription() {
        return "DeluxeRoom";
    }

    /**
     * Returns the cost of the room
     * @return room cost + amenities cost
     */
    @Override
    public double getCost() {
        return this.roomCost + getAmenitiesCost();
    }

    /**
     * Returns room number
     * @return roomNumber
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Setter method for room number
     * @param roomNumber
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * function to indicate that rooms have been cleaned
     * @return String
     */
    @Override
    public String cleanRoomsString(){
        return "All linens have been cleaned and all of the towels will be changed";
    }

    /**
     * Override toString method
     * @return String
     */
    public String toString() {
        StringBuilder str = new StringBuilder("Room Number: " + this.roomNumber + " " + getDescription() + ", Amenities: ");
        for (amenitiesDecorator ad : this.amenities) {
            str.append(ad.getDescription()).append(", ");
        }
        return String.format("%s. Cost: $%.2f",str.toString().substring(0,str.length()-2),getCost());
    }
}