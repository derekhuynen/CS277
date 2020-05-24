package DerekHuynen.Labs.StreamIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StreamRunner {

    public static void main(String[] args) {
        Person Dave = new Person ("Brown", "David", Gender.MALE, Profession.COMPUTER_GEEK);
        Person Mary = new Person ("Brown", "Mary", Gender.FEMALE, Profession.RETAIL_MANAGEMENT);
        Person Jean = new Person ("Denni", "Jean", Gender.FEMALE, Profession.DECEASED);
        Person Bob = new Person ("Denni", "Robert", Gender.MALE, Profession.DECEASED);
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


        try (ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream ("stream.bin"))){

            out.writeObject (Dave);
            out.writeObject(Mary);
            out.writeObject(Rachel);



            try (ObjectInputStream in = new ObjectInputStream (new FileInputStream ("stream.bin"))){

                Person Clone = null;
                try {
                    boolean stillReading = true;
                    while (stillReading) {
                        try {
                            Clone = (Person) in.readObject();
                            System.out.println("Next person is: " + Clone);
                        } catch (EOFException EOFE) {
                            System.out.println("Found the end of the file.");
                            stillReading = false;		//Exit stage left
                        }
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Unable to find the class that you are reading in.");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println ("Unable to access input stream file");
                e.printStackTrace();
            }
        } catch (IOException e) {
            System.out.println("Unable to access outupt stream file");
            e.printStackTrace();
        }
    }

}
