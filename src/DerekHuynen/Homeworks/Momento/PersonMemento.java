/**
 * Person Memento Class
 * Homework Assignment: Memento
 *
 * @author Derek Huynen
 * @date 4/09/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.Momento;

import java.io.Serializable;

public class PersonMemento implements Serializable
{
    private Person person;
    private static final long serialVersionUID = 123;


    /**
     * Constructor that takes just one argument: the Person instance that you want to preserve into an instance of PersonMemento.
     * @param person you want to save
     */
    public PersonMemento (Person person)
    {
        this.person = new Person(person);
    }


    /**
     * Method that returns an instance of Person with the same values as the Memento
     * @return person from Memento Class
     */
    public Person getSavedPerson()
    {
        return this.person;
    }

} // End of the PersonMemento class
