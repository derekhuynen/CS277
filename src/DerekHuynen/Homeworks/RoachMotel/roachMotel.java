/**
 * Roach Motel
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Singleton Class
 * And Subject Class
 * Check in, check out methods
 * 	Ameneities added to rooms in check in method
 * Notify roach colony if no rooms available
 */
public class roachMotel implements Subject {

    //Name of the Hotel
    private String name;
    private volatile static roachMotel instance;
    // ArrayList of colonies on the wait list
    private ArrayList<Observer> waitList;
    // ArrayList of residents in the motel represented as a string
    private ArrayList<roachColony> motelResidents;
    // ArrayList of rooms available in the motel
    private ArrayList<Integer> rooms;
    // ArrayList of the transaction log
    private ArrayList<String> transactionLog;
    //Date Formatter
    private String pattern = "MM-dd-yyyy HH:mm:ss.SSS";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.pattern);

    /**
     * Default constructor
     * No instance variables needed to be initialized when the motel is constructed
     */
    private roachMotel(String name) {
        this.name = name;
        this.waitList = new ArrayList<>();
        this.motelResidents = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.transactionLog = new ArrayList<>();
    }

    /**
     * the getInstance() method
     * @param name of the Hotel
     * @return instance
     */
    public static roachMotel getInstance(String name)
    {
        if (instance == null) {
            // To make thread safe
            synchronized (roachMotel.class) {
                // Check again as multiple threads
                // Can reach above step
                if (instance == null)
                    instance = new roachMotel(name);
            }
        }
        return instance;
    }

    /**
     * this will create the room
     */
    public void createRooms() {

        for (int i = 100; i <= constants.NUMBER_OF_ROOMS + 100; i++) {
            rooms.add(i);
        }
    }

    /**
     * method to notify that there are no rooms
     * @param colony to be added to wait list
     */
    public void noVacancy(roachColony colony) {
        System.out.println("There are no rooms available, " + colony.getColonyName() + " will be added to the wait list.");
        addObserver(colony);
    }

    /**
     * void function to show vacancy
     */
    public void vacancy() {
        System.out.printf("Check-in: Room available: %s\n", this.rooms.toString());
    }

    /**
     * displays amenities included with room
     * @param room
     */
    public void displayCheckIn(motelRooms room, roachColony colony) {

        System.out.printf("Check-In: The colony: %s was assigned to room: %s\n",colony.toString(),room.toString() );

    }

    /**
     * method to check in someone to the hotel
     * @param colony being checked in
     * @param roomType being checked into
     * @return
     */
    public void checkIn(roachColony colony, String roomType, ArrayList <amenitiesDecorator> amenities) {
        String transaction = "";

        if (rooms.size() == 0) {
            noVacancy(colony);
            transaction = String.format("%s No room at the motel for: %s",simpleDateFormat.format(new Date()),colony);

        } else {

            // Displays there are rooms available
            vacancy();

            // Uses the factory class to create a room based on the type provided
            motelRooms myRoom = roomFactory.createRoom(roomType);

            for (amenitiesDecorator ad : amenities) {
                myRoom.addAmenity(ad);
            }

            // Adds the colony and their respective room to the motelResidents ArrayList
            motelResidents.add(colony);
            // Sets the room to the first open room number
            myRoom.setRoomNumber(rooms.get(0));
            // Removes the first room in the list of room's available
            rooms.remove(0);
            // Sets the room the colony is staying in
            colony.setRoom(myRoom);

            for (int i = 0; i < waitList.size(); i++){
                if (waitList.get(i).equals(colony)) {
                    removeObserver(colony);
                }
            }
            // Display the amenities being added to the room
            displayCheckIn(myRoom, colony);

            transaction = String.format("%s Colony: %s safely registered with amenities: %s",simpleDateFormat.format(new Date()),colony.toString(),colony.getRoom().getAmenities().toString());
        }
        writeTransactionLog(transaction);
    }

    /**
     * method to check someone out
     * @param colony being checked out
     * @param numDays number of Days at the Hotel
     * @param roachPayment how the Colony with pay for room
     */
    public void checkOut(roachColony colony, int numDays, paymentMethod roachPayment) {
        System.out.println("A customer is checking out. Right now available rooms: " + rooms.toString());
        motelRooms room = colony.getRoom();
        motelRoomVisitor cashier = new motelRoomVisitorImp();

        // Once the colony checks out, add the room number back to the list of available rooms
        rooms.add(rooms.size(), room.getRoomNumber());
        // Once the colony checks out, remove that colony from the list of motel residents
        motelResidents.removeIf(word -> word.equals(colony));

        double checkOutCost = room.accept(cashier) * numDays;
        roachPayment.pay(checkOutCost);

        // Notifies a colony if there is an available room
        if (rooms.size() == 1) {
            notifyObservers();
        }

        roachPayment.setPaymentType(roachPayment);

        String transaction = String.format("%s Colony: %s checking out of room: %s using %s",simpleDateFormat.format(new Date()),colony.toString(),colony.getRoom(),roachPayment.toString());
        writeTransactionLog(transaction);
    }


    /**
     * Adds to the transaction log
     * @param transaction
     */
    // Add to the transaction log
    public void writeTransactionLog(String transaction) {
        this.transactionLog.add(transaction);
    }

    /**
     * Add a colony to the wait list
     * @param o observer to be added
     */
    @Override
    public void addObserver(Observer o) {
        this.waitList.add(o);
    }

    /**
     * Remove a colony from the wait list
     * @param o Observer to be removed
     */
    @Override
    public void removeObserver(Observer o) {
        this.waitList.remove(o);
    }

    /**
     * notifies observer of any changes
     */
    @Override
    public void notifyObservers() {
        for (Observer obs : this.waitList) {
            obs.update(obs);
        }
    }

    /**
     * void function to clean rooms
     */
    public void cleanRooms() {
        StringBuilder cleaningTime = new StringBuilder("Time to clean the rooms today! Rooms to be cleaned: ");
        StringBuilder cleaningDone = new StringBuilder("Cleaning Done:\n ");
        for (roachColony colony : motelResidents) {
            cleaningTime.append(colony.getRoom().getRoomNumber()).append(" ");

            if (!colony.getRoom().getDoNotDisturb()) {
                cleaningDone.append(String.format("Room %d: %s\n",colony.getRoom().getRoomNumber(),colony.getRoom().cleanRoomsString()));
            } else {
                cleaningDone.append(String.format("Room %d does not want to be disturbed and will not be cleaned.\n",colony.getRoom().getRoomNumber()) );
            }
        }
        System.out.println(cleaningTime);
        System.out.println(cleaningDone);
    }

    /**
     * Displays transaction log
     */
    public void displayLog() {
        StringBuilder str = new StringBuilder("Transaction Log\n");
        for (String s : transactionLog) {
            str.append(s).append("\n");
        }
        System.out.println(str.toString());
    }

    /**
     * Displays transaction log
     *
     */
    public void displayRoster() {
        StringBuilder rooms = new StringBuilder("Motel: " + this.name + " Room Roster:\n");
        StringBuilder hosting = new StringBuilder("Motel: " + this.name + " Is hosting: ");
        for (roachColony colony : motelResidents) {
            rooms.append(colony.getRoom().toString()).append("\n");
            hosting.append(colony.toString()).append(", ");
        }
        System.out.printf("%s%s\n",rooms.toString(),hosting.toString().substring(0,hosting.length()-2));
    }

    public void displayMotel(){
        System.out.println(this.toString());;
    }

    /**
     * toString function
     * @return a String of this class
     */
    public String toString() {
        return String.format("MOTEL: %s The only Motel is town: Available rooms: %s\n",this.name,this.rooms.toString());
    }

    /**
     * Method for checking if the room has a shower and reducing the colony's population
     * @param roachColony the colony throwing the party
     */
    public static void hoseTheRoaches(roachColony roachColony) {

        //Get amenities of the room the colony is staying in
        ArrayList<amenitiesDecorator> amenities = roachColony.getRoom().getAmenities();

        //Loop through the amenities
        for(amenitiesDecorator ad : amenities) {
            //Checks to see if the amenities contains an instance of the shower
            if(ad instanceof shower) {
                System.out.println("Room has Spray Resistant Shower");

                //reduce population by 25%
                roachColony.setPopulation(roachColony.getPopulation() * 0.75);
                return;
            }
        }

        System.out.println("No Spray Resistant Shower");
        //reduce colony by 50%
        roachColony.setPopulation(roachColony.getPopulation() * 0.5);
    }
}