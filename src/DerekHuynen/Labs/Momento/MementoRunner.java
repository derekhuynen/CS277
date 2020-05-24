package DerekHuynen.Labs.Momento;



/**
 * MementoRunner
 * Lab Assignment: Memento
 *
 * @author Derek Huynen
 * @date 3/20/2020
 * @version 1.00
 */
public class MementoRunner {

    public static void main(String[] args) {
        Section CECS277 = new Section("CECS 277", 5, Time.EIGHT, Time.NINE, "VEC", "330", "TeacherName", Days.MONDAY_WEDNESDAY);
        System.out.println("CECS277 originally:\n" + CECS277);
        CareTaker ct = new CareTaker();
        //saveStatetoMemento is a Section member function that uses the Memento constructor
        //to "pickle" the current state of CECS277 into a memento, which is a nested class
        //within Section, the originator.
        ct.add(CECS277.saveStatetoMemento());				//Save the current state.
        CECS277.setBuilding("ECS");							//Update the state of CECS277
        CECS277.setRoom("414");
        CECS277.setInstructorName("Bob Marley");
        ct.add(CECS277.saveStatetoMemento());				//Save the state again
        CECS277.setStartTime(Time.THREE_THIRTY);			//Update the state of CECS277
        CECS277.setEndTime(Time.FOUR_THIRTY);
        ct.add(CECS277.saveStatetoMemento()); 				//Save the state yet again
        System.out.println("After changing the time and location.\n" + CECS277);
        CECS277.getStateFromMemento(ct.get(1));
        System.out.println("Rolling back by one notch.\n" + CECS277);
        CECS277.getStateFromMemento(ct.get(0));
        System.out.println("Rolling back by another notch.\n" + CECS277);
        CECS277.getStateFromMemento(ct.get(2));	 			//Put back to last state
        System.out.println("And back the way it was before we rolled anything back:\n" + CECS277);
    }

}
