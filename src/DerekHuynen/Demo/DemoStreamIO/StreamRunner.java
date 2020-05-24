package DerekHuynen.Demo.DemoStreamIO;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StreamRunner {

    /**
     * Read all of the objects from the supplied input stream and list them out.
     * @param in		The ObjectInputStream to read from.
     * @param message	The message to print with each record.
     * @throws IOException
     */
    public static <E> void readGeneric (ObjectInputStream in, String message) throws IOException {
        E Clone = null;		//Temp area for the object read in
        try {
            boolean stillReading = true;		//Flag to tell whether we've hit the end of the file.
            while (stillReading) {
                try {
                    Clone = (E) in.readObject();
                    System.out.println(message + Clone);
                } catch (EOFException EOFE) {
                    System.out.println("Found the end of the file.");
                    stillReading = false;		//Exit stage left
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to find the class that you are reading in.");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //Create some basic instances of Person to play with
        Person Dave = new Person ("Brown", "David", Gender.MALE, Profession.COMPUTER_GEEK);
        Person Mary = new Person ("Brown", "Mary", Gender.FEMALE, Profession.RETAIL_MANAGEMENT);
        Person Jean = new Person ("Denni", "Jean", Gender.FEMALE, Profession.DECEASED);
        Person Bob = new Person ("Denni", "Robert", Gender.MALE, Profession.DECEASED);
        /*
         * The Couple is just a pair of Persons.  The intent of this demonstration/experiment is to
         * answer the question: if we write out an object, Couple in this case, and that has a
         * reference to another object, Person in this case, then create another Couple that references
         * the same Person, and write that second Couple out, does the ObjectOutputStream write
         * out just one Person or two?
         * Who cares?  If a PersonMemento just has a reference to a Person instance, and you write
         * out an instance of PersonMemento in the caretaker, then alter that Person instance, and
         * create a "new" memento and have the caretaker write that out, does the ObjectOutputStream
         * have one Person instance, or two?
         */
        Couple DaveMary = new Couple (Dave, Mary);
        System.out.println("Dave & Mary");
        System.out.println(DaveMary);
        try (ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream ("couple.bin"))){
            out.writeObject(DaveMary);
            //Change my profession to demonstrate that the shallow copy is inadequate
            Dave.setProfession(Profession.DECEASED);
            //Create a SHALLOW copy of the DaveMary couple and call it DaveMary2
            Couple DaveMary2 = new Couple (DaveMary);
            //Write out the shallow copy.  Since his points to the same instance of Person (Dave),
            //the write will not put out a new (updated) copy of that Person.
            out.writeObject(DaveMary2);
            //Write out a DEEP copy of the DaveMary couple.
            out.writeObject(DaveMary.clone());
            //Reset the profession because I don't particularly want to stay dead for long
            Dave.setProfession(Profession.COMPUTER_GEEK);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        //Read the couples back in again and display them.
        try (ObjectInputStream in = new ObjectInputStream (new FileInputStream ("couple.bin"))) {
            System.out.println("Experiment with couples");
            readGeneric (in, "Next couple is: ");
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Mary.setFather(Bob);
        Mary.setMother(Jean);
        Person Tom = new Person ("Brown", "Thomas", Gender.MALE, Profession.DECEASED);
        Person Priscilla = new Person ("Brown", "Priscilla", Gender.FEMALE, Profession.HUMAN_RESOURCES);
        Person William = new Person ("Brown", "William", Gender.MALE, Profession.DECEASED);
        Person Mildred = new Person ("Brown", "Mildred", Gender.FEMALE, Profession.DECEASED);
        Tom.setFather(William);
        Tom.setMother(Mildred);
        Dave.setFather(Tom);
        Dave.setMother(Priscilla);
        Person Rachel = new Person ("Burris", "Rachel", Gender.FEMALE, Profession.TEACHER);
        Rachel.setFather(Dave);
        Rachel.setMother(Mary);
        try { //(ObjectInputStream in = new ObjectInputStream (new FileInputStream ("stream.bin"))){
            ObjectInputStream in = new ObjectInputStream (new FileInputStream ("stream.bin"));
            System.out.println("Reading the ObjectInputStream before writing to it.");
            readGeneric (in, "Next person is: ");
            ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream ("stream.bin"));
            out.writeObject (Dave);
            in = new ObjectInputStream (new FileInputStream ("stream.bin"));
            readGeneric (in, "Next person is: ");
            out.writeObject(Mary);
            in = new ObjectInputStream (new FileInputStream ("stream.bin"));
            readGeneric (in, "Next person is: ");
            out.writeObject(Rachel);
            System.out.println("After three writes");
            in = new ObjectInputStream (new FileInputStream ("stream.bin"));
            readGeneric (in, "Next person is: ");
            out.close();
        } catch (IOException e) {
            System.out.println ("Unable to access input stream file");
            e.printStackTrace();
        }
    }
}