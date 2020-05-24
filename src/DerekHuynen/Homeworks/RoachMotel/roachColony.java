/**
 * RoachColony
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
 * A class for a Roach Colony that also implements Observer
 */
public class roachColony implements Observer {

    // the name of the colony
    private String name;
    // the population of the colony
    private double population;
    // the growth rate of the colony
    private double growthRate;
    // the room the colony is checked in to
    private motelRooms colonyRoom;

    /**
     * Default constructor of the roachColony class
     */
    public roachColony() {}

    /**
     * Overload constructor of the roachColony class
     * @param name - the name of the colony
     * @param population - the population of the colony
     * @param growthRate - the growth rate of the colony
     */
    public roachColony(String name, double population, double growthRate) {
        this.name = name;
        this.population = population;
        this.growthRate = growthRate;
    }

    /**
     * getter for Colony Name
     * @return name of this colony
     */
    public String getColonyName() {
        return this.name;
    }

    /**
     * Setter for Colony Name (If name ever Needs to be Changed)
     * @param name to Change the Colony name too
     */
    public void setColonyName(String name) {
        this.name = name;
    }

    /**
     * Getter for Population
     * @return population for this Colony
     */
    public double getPopulation() {
        return this.population;
    }

    /**
     * Setter for current Population
     * @param population
     */
    public void setPopulation(double population) {
        this.population = population;
    }

    /**
     * Getter for Growth Rate
     * @return Tgrowth Rate for this colony
     */
    public double getGrowthRate() {
        return this.growthRate;
    }

    /**
     * Setter for Growth Rate
     * @param growthRate for this colony
     */
    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

    /**
     * Getter for Colony Room
     * @return motelRoom of the Colony
     */
    public motelRooms getRoom() {
        return this.colonyRoom;
    }

    /**
     * Setter for Motel Room
     * @param room that the Colony is in
     */
    public void setRoom(motelRooms room) {
        this.colonyRoom = room;
    }

    /**
     * Roaches are Throwing a Party!
     */
    public void roachParty() {
        System.out.println("Roach Party! " + this.name + " is throwing a party");
        System.out.println("The roaches have partied! New population: " + roachPartyCalc());

        roachMotel.hoseTheRoaches(this);
    }

    /**
     * Calculator for Roach Party
     * @return Population after the Party
     */
    public double roachPartyCalc() {
        return this.population += (this.population * this.growthRate);
    }


    /**
     * Updater for Observer Pattern
     * @param obs that needs to be updated
     */
    public void update(Object obs) {
        System.out.println(this.name + " has been notified that a room is available at the Roach Motel.");
    }

    /**
     * Covert this class to a String
     * @return String version of a this class
     */
    public String toString() {
        return String.format("Name: %s, Population: %s",this.getColonyName(),this.getPopulation());
    }

    /**
     * Add Amenities to the Room the Colony is staying in
     * @param amenity The amenity to be added
     */
    public void addAmenity(amenitiesDecorator amenity){
        try{
            this.colonyRoom.addAmenity(amenity);
        }catch(NullPointerException npe){
            System.out.printf("ERROR: Colony: %s is currently not assigned to a Room. Can't add amenity.\n",this.toString());
        }
    }

    /**
     * Remove amenity from the room the colony is staying in
     * @param amenity to be removed
     */
    public void removeAmenity(amenitiesDecorator amenity){
        try{
            this.colonyRoom.removeAmenity(amenity);
        }catch(NullPointerException npe){
            System.out.printf("ERROR: Colony: %s is currently not assigned to a Room. Can't add amenity.\n",this.toString());
        }
    }
}