/**
 * roomFactory
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

public class roomFactory {

    public static motelRooms createRoom(String roomType) {
        motelRooms myRoom = null;
        if (roomType.contentEquals("regular"))
            myRoom = new regularRoom();
        else if (roomType.contentEquals("deluxe"))
            myRoom = new deluxeRoom();
        else if (roomType.contentEquals("suite"))
            myRoom = new suiteRoom();
        return myRoom;
    }
}
