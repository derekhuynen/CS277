/**
 * Person Class
 * Lab: CECS 277 Lab Interfaces And Polymorphism
 * @author Derek Huynen
 */

package DerekHuynen.Labs.InterfacesAndPolymorphism;

public class Person implements Comparable<Person>,Measurable {
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Constructor with 2 params
     * @param firstName of the Person as a String
     * @param lastName of the Person as a String
     */
    public Person(String firstName, String lastName) {
        this(firstName,lastName,0);
    }

    /**
     * Constructor with 3 params
     * @param firstName of the Person as a String
     * @param lastName pf the Person as a String
     * @param age of the person as a int
     */
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * First Name getter
     * @return first name of person as a String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Last Name Getter
     * @return last name of the person as a String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Age getter
     * @return age of the Person as a int
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns the age of the person.
     * @return the age of the person.
     */
    @Override
    public double getMeasure() {
        return this.getAge();
    }

    /**
     * Return a String version of the person's age.
     * Note, this is a really bad idea, we should have stored their birthday and
     * calculated the age, but this is simpler for now.
     *
     * @return String version of this person.
     */
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + " Age: " + age;
    }

    /**
     * Compare one instance of Person (the implicit parameter) to another
     * instance of Person (the explicit parameter that we're calling "Other".
     *
     * @param    Other    The second Person in the comparison.
     * @return            < 1 if this person < the other person.
     * = 0 if they are equal
     * > 1 if this person > the other person.
     * Note, we compare by last name first, then the first name.
     * Note, we ignore the case in this particular implementation.
     */
    @Override
    public int compareTo(Person Other) {
        int nameComp = this.getLastName().compareToIgnoreCase(Other.getLastName());
        if (nameComp == 0) {                    //Last names match, so we have to go to the first name.
            nameComp = this.getFirstName().compareToIgnoreCase(Other.getFirstName());
        }
        return nameComp;
    }
}