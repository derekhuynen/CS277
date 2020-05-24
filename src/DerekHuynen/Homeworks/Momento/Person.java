/**
 * Person Class
 * Homework Assignment: Memento
 *
 * @author Derek Huynen
 * @date 4/09/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.Momento;


import java.io.Serializable;

public class Person implements Serializable {

    /**
     * Demonstration class that we will preserve into an instance of Memento.
     * @author David Brown
     *
     */
    /** Height of the person in inches.  Note that we do not STORE the height in feet, that's calculated.
     */
    private int heightInches;
    /** The weight of the person in pounds.  Ounces not significant. */
    private int weightPounds;
    /** Last Name of the person. */
    private String lName;
    /** First Name of the person.*/
    private String fName;
    /** The person's hair color */
    private HairColor hairColor;
    /** Ratio of inches to feet. */
    public static final int inchesPerFoot = 12;
    /** Maximum believable height in inches.*/
    private static final int maxHeight = 7 * inchesPerFoot;
    /** Minimum believable height in inches. */
    private static final int minHeight = 1 * inchesPerFoot;
    /** Maximum believable weight in pounds.*/
    public static final int maxWeight = 400;
    /** Minimum believable weight in pounds.*/
    private static final int minWeight = 20;


    public enum HairColor {
        BLACK, BLONDE, RED, AUBURN, SALT_AND_PEPPER, GREY, WHITE, BALD; //each is an instance of Color
        public static HairColor getColor (int colorNumber) {
            int currentColor = 0;
            boolean found = false;
            HairColor results = HairColor.BLACK;
            for (HairColor color:values() ) {
                if (currentColor == colorNumber) {
                    results = color;
                    found = true;
                    break;
                }
                currentColor++;
            }
            if (found) {
                return results;
            } else {
                throw new IllegalArgumentException ("Color number outside of range!");
            }
        }
    }

    /**
     * Build a new person.
     * @param lName				Last name.
     * @param fName 			First name.
     * @param color				Color of the person's hair.
     * @param heightInFeet		Height of the person in feet.
     * @param heightInInches	Inches portion of their height.
     * @param weightInPounds	Weight of the person, in pounds.
     */
    public Person (String lName, String fName, HairColor color, int heightInFeet, int heightInInches, int weightInPounds) {
        setHeight (heightInFeet, heightInInches);					//Update the height
        setWeight (weightInPounds);
        this.lName = lName;
        this.fName = fName;
        this.hairColor = color;
    }


    /**
     * Constructor
     * @param lName last name of the person
     * @param fName first name of the Person
     */
    public Person( String lName, String fName){
        this.lName = lName;
        this.fName = fName;
    }


    /**
     * constructor take from Memento lab
     * @param orig person
     */
    public Person ( Person orig) {
        this(orig.lName, orig.fName, orig.hairColor, orig.getHeightFeet(), orig.getHeightInches()%12, orig.getWeightPounds());
    }

    /**
     * Returns the person last name
     * @return last Name of the person
     */
    public String getlName () {
        return this.lName;
    }

    /**
     * Returns the person first name
     * @return first Name of the person
     */
    public String getfName () {
        return this.fName;
    }

    /**
     * Retrieve the person's hair color.
     * @return	Their current hair color.
     */
    public HairColor getHairColor () {return this.hairColor;}

    /**
     * Set the person's hair color.
     * @param newColor	Their new hair color.
     */
    public void setHairColor (HairColor newColor) {this.hairColor = newColor;}

    /**
     * Set Height for the person in inches
     * @param feet on the person
     * @param inches of the person
     */
    public void setHeight (int feet, int inches) {
        int totalInches = netHeight (feet, inches);
        if (totalInches < minHeight || totalInches > maxHeight) {
            throw new IllegalArgumentException("Height out of bounds!");
        } else {
            this.heightInches = totalInches;
        }
    }

    /**
     * Sets the weight of the person
     * @param pounds of the person
     */
    public void setWeight (int pounds) {
        if (pounds < minWeight || pounds > maxWeight) {
            throw new IllegalArgumentException ("Weight out of bounds!");
        } else {
            this.weightPounds = pounds;
        }
    }

    /**
     * Give the height of the person in inches.
     * @return Height in inches.
     */
    public int getHeightInches () {
        return this.heightInches;
    }

    /**
     * Return the feet (floor) of the person.
     * @return the height of person in feet only
     */
    public int getHeightFeet () {
        return this.getHeightInches()/inchesPerFoot;
    }

    /**
     * Return the number of lbs the person weighs.
     * @return	The number of pounds that the person weighs.
     */
    public int getWeightPounds () {
        return this.weightPounds;
    }

    /**
     * Calculate height from feet & inches.
     * @param feet	The feet in height.
     * @param inches	The inches above the last foot that need to be added to get height in inches.
     * @return	Total height in inches.
     */
    private static int netHeight(int feet, int inches) {
        return feet * inchesPerFoot + inches;
    }

    /**
     * Return string version of the Person.
     * @return	Display string of the person.
     */
    @Override
    public String toString () {
        return String.format("Name: %s, %s, Hair Color: %s, Height:%d'%d, Weight #: %d",
                this.lName, this.fName, "" + this.hairColor, this.getHeightFeet(),
                this.getHeightInches()%inchesPerFoot,
                this.weightPounds);//So we can print the Person.
    }

    /**
     * Restore Person state
     * @param archive of the current person
     */
    public Person restore(PersonMemento archive) {
        Person archivePerson = archive.getSavedPerson();

        this.setHairColor(archivePerson.getHairColor());
        this.setHeight(archivePerson.getHeightFeet(),
                archivePerson.getHeightInches() % 12);
        this.setWeight(archivePerson.getWeightPounds());

        return archive.getSavedPerson();
    }

    /**
     * Save a Person State to Memento
     * @return this instance of person
     */
    public PersonMemento saveState() {
        return new PersonMemento(this);
    }

} //End of the Person Class