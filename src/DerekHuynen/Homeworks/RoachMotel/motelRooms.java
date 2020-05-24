/**
 * motelRooms
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

import java.util.ArrayList;

/**
 * Abstract class for Room factory
 *
 */
public abstract class motelRooms {

    //List of amenities for the room
    protected ArrayList<amenitiesDecorator> amenities;
    //Room Number
    private int roomNumber;
    //Whether or not the room wants to be disturbed
    private boolean doNotDisturb;


    /**
     * Default Constructor
     */
    public motelRooms() {
        this.amenities = new ArrayList<>();
        this.doNotDisturb = false;
    }


    /**
     * abstract method that gets the description
     * @return String
     */
    public abstract String getDescription();

    /**
     * Will be overridden by each amenity class to get the cost
     * of each individual one
     * @return cost
     */
    public abstract double getCost();

    /**
     * Adds an amenity to the ArrayList
     * @param amenity to be added
     */
    public void addAmenity(amenitiesDecorator amenity) {
        try{
            if(this.amenities.contains(amenity))
            for(amenitiesDecorator temp : this.amenities){
                if(temp.toString().equals(amenity.toString()))
                    throw new IllegalArgumentException("Error, you tried to add the amenity " + amenity + " twice.");
            }
            this.amenities.add(amenity);

        }catch(IllegalArgumentException e){
            System.out.println("Message from exception: " + e.getMessage());
        }
    }

    /**
     * Remove from from the list of Amenities
     * @param amenity to be removed
     */
    public void removeAmenity(amenitiesDecorator amenity) {
        this.amenities.remove(amenity);
        System.out.printf("Amenity %s was removed from the room.\n",amenity);
    }

    /**
     * Calculates the total cost of all the amenities associated with the room
     * @return the total cost
     */
    public double getAmenitiesCost() {
        double totalAmenitiesCost = 0.0;
        for (amenitiesDecorator amenity : this.amenities) {
            totalAmenitiesCost += amenity.getCost();
        }
        return totalAmenitiesCost;
    }

    /**
     * returns the amenities ArrayList
     * @return ArrayList
     */
    public ArrayList<amenitiesDecorator> getAmenities() {
        return this.amenities;
    }

    /**
     * Overrides the toString method
     * @return String
     */
    public String toString() {
        StringBuilder str = new StringBuilder("Room Number :" + this.roomNumber + " " + getDescription() + ". Amenities: ");
        for (amenitiesDecorator ad : this.amenities) {
            str.append(ad.getDescription()).append(". ");
        }
        return str.toString();
    }

    /**
     * Returns string of clean rooms
     * @return ""
     */
    public String cleanRoomsString() {
        return "";
    }

    /**
     * boolean function for do not disturb
     * @return doNotDisturb
     */
    public boolean getDoNotDisturb() {
        return this.doNotDisturb;
    }

    /**
     * void setter function for do not disturb
     */
    public void setDoNotDisturb(boolean doNotDisturb) {
        this.doNotDisturb = doNotDisturb;
    }

    /**
     * Accept method part of the Visitor design implementation
     * @param visitor the motel room as a Visitor
     * @return this room
     */
    public double accept(motelRoomVisitor visitor) {
        return visitor.visit(this);
    }

    /**
     * returns room number
     * @return roomNumber
     */
    public int getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * setter method for room number
     * @param roomNumber to be set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}