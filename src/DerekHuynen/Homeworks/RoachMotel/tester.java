package DerekHuynen.Homeworks.RoachMotel;

import java.util.ArrayList;

public class tester {

    public static void main(String[] args) {

        roachMotel motel = roachMotel.getInstance("RoachMotel"); // creating a new roach motel
        motel.createRooms();
        motel.displayMotel();

        amenitiesDecorator foodBar = new foodBar();
        amenitiesDecorator spa = new spa();
        amenitiesDecorator refillBar = new refillBar();
        amenitiesDecorator shower = new shower();

        ArrayList<amenitiesDecorator>amenities = new ArrayList<amenitiesDecorator>(); // creates an ArrayList of type amenitiesDecorator
        amenities.add(foodBar); // add foodbar
        amenities.add(spa); // add spa
        amenities.add(refillBar); // add refillable bar
        amenities.add(shower); // add shower


        roachColony rc1 = new roachColony("first colony",100,200); // creating a new roach colony

        motel.checkIn(rc1, "suite",amenities); // create a new suite room and put rc1 in it


        motel.displayRoster();
        //r1.setDoNotDisturb(true);

        roachColony rc2 = new roachColony("Second colony",1000,0.2); // create a 2nd roach colony
        motel.displayMotel();
        motel.checkIn(rc2,"deluxe",amenities);
        rc2.addAmenity(shower);
        rc2.removeAmenity(shower);
        rc2.roachParty();

        motel.checkOut(rc1,3,new masterRoach(rc1.getColonyName(), "12345", "111", "08/20"));
        motel.displayRoster();
        motel.displayMotel();


        roachColony rc3 = new roachColony("Third colony",1000,0.2);
        motel.checkIn(rc3,"deluxe",amenities);

        rc3.roachParty();


        roachColony rc4 = new roachColony("Fourth colony",1000,0.2);
        motel.checkIn(rc4,"deluxe",amenities);


        motel.checkOut(rc3,3,new masterRoach(rc3.getColonyName(), "12345", "111", "08/20"));

        motel.cleanRooms();

        motel.displayLog();
    }

}
