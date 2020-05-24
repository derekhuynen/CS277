/**
 * Memento Runner
 * Homework Assignment: Memento
 *
 * @author Derek Huynen
 * @date 4/09/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.Momento;

import java.util.Scanner;

public class MementoRunner
{
    public static void main(String[] args)
    {
        String finished = "n";
        Scanner scanner= new Scanner(System.in);
        String lname,fname,fileName;
        int hairColor,heightInFoot,heightInInches;


        //Prompt Use for File Name
        do{
            System.out.print("Enter File Name: ");
            fileName = scanner.nextLine() + ".bin";
        }while(fileName.isEmpty());

        PersonCaretaker personCaretaker = new PersonCaretaker(fileName); //Create a personCaretaker

        //Ask User for lName,fName
        do{
            System.out.print("prompting you for persons: ");
            System.out.print("\nEnter the person's last name: ");
            lname = scanner.nextLine().trim();
            System.out.print("Enter the person's first name: ");
            fname = scanner.nextLine().trim();

        }while(lname.isEmpty() || fname.isEmpty());

        Person person = new Person(lname,fname);

        //Ask User for other Attributes
        do{
            System.out.print("0: BLACK\n" +
                    "1: BLONDE\n" +
                    "2: RED\n" +
                    "3: AUBURN\n" +
                    "4: SALT_AND_PEPPER\n" +
                    "5: GREY\n" +
                    "6: WHITE\n" +
                    "7: BALD\n" +
                    "Please enter the # corresponding to the hair color: ");
            hairColor = scanner.nextInt();
            person.setHairColor(Person.HairColor.getColor(hairColor));
            System.out.print("You entered color: " + Person.HairColor.getColor(hairColor));
            System.out.print("\nPerson's height in feet: ");
            heightInFoot = scanner.nextInt();
            System.out.print("And the inches? For instance, 5'10\" would be 10: ");
            heightInInches = scanner.nextInt();
            person.setHeight(heightInFoot,heightInInches);
            System.out.print("Their weight in pounds: ");
            person.setWeight(scanner.nextInt());

            personCaretaker.addMemento( person.saveState());

            System.out.println(person);
            System.out.println("Are we done here (Y/N)?: ");
            finished = scanner.next().trim();

        }while(!finished.equalsIgnoreCase("Y"));

        //Return Skinniest person
        System.out.println("Skinniest Person is " + personCaretaker.getMemento().getSavedPerson());

        //Ask user for a weight and return that person
        System.out.print("What weight do you want to search for: ");
        int searchWeight = scanner.nextInt();

        String result = personCaretaker.getMemento(searchWeight) == null
                ? "No person found with weight: " + searchWeight
                : "Person with weight " + searchWeight + " is: " + personCaretaker.getMemento(searchWeight).getSavedPerson();

        System.out.println(result);

        //End of class
        System.out.println("Completed Satisfactorily");
    }
} //End of PersonRunner Class