package DerekHuynen.Demo.BinaryIODemo;

/**
 * Demonstration enumeration for serialization exercise.
 * @author	Dave Brown
 * @date	10/15/2019
 */
public enum Gender {
    MALE ("male"), FEMALE("female"), UNSPECIFIED ("unspecified");

    /** A more friendly name of the gender */
    String name;

    /** Constructor */
    private Gender (String name) {
        this.name = name;
    }

    @Override
    public String toString() { return this.name; }
}
