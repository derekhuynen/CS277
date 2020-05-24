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

public class motelRoomVisitorImp implements motelRoomVisitor {

    /**
     * Gets the Cost or the Room
     * @param room to be looked up
     * @return cost of room as a double
     */
    public double visit(motelRooms room) {
        return room.getCost();
    }
}
