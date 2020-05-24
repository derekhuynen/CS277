package DerekHuynen.Demo.DemoStreamIO;

import java.io.Serializable;

public class Couple implements Serializable, Cloneable {
    private static final long serialVersionUID = 123;

    private Person one;
    private Person theOther;

    /**
     * Normal Couple constructor.
     * @param one		The first Person in the couple.
     * @param theOther	The second Person in the couple.
     */
    public Couple (Person one, Person theOther) {
        this.one = one;
        this.theOther = theOther;
    }

    @Override
    public Object clone () {
        return new Couple (new Person (this.getOne()), new Person (this.getTheOther()));
    }
    /**
     * Retrieve the first person in the couple.
     * @return	The first person in the couple.
     */
    public Person getOne () { return this.one; }

    /**
     * Retrieve the second person in the couple.
     * @return	The second person in the couple.
     */
    public Person getTheOther () { return this.theOther; }

    /**
     * Shallow copy constructor.  I intentionally do not clone person here to prove a point.
     * @param one		The first person in the couple.
     * @param theOther	The second person in the couple.
     */
    public Couple (Couple other) {
        this.one = other.getOne();
        this.theOther = other.getTheOther();
    }

    @Override
    public String toString () {
        return "Couple: " + one + "\nthe other: " + theOther;
    }
}
