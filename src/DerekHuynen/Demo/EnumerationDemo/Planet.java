package DerekHuynen.Demo.EnumerationDemo;

/**
 * Enumeration of the available planets in the Sol solar system.
 * @author Java Tutorial at URL:
 * https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 *
 */
public enum Planet {
    //Create all of the planets.  None can be added or removed during execution.
    //These statements are using the constructor for this class.
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    /**
     * mass of the planet
     */
    private final double mass;   // in kilograms
    /**
     * Radius of the planet in meters
     */
    private final double radius; // in meters
    /**
     * Constructor
     * @param mass Mass in kg
     * @param radius Radius in Km
     */
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    /**
     * Accessor method for the planet's mass.
     * @return Mass of the planet in kg.
     */
    private double mass() { return mass; }
    /**
     * Accessor method for the planet's radius.
     * @return Planet radius in km.
     */
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    public String toString() {
        String lower = this.name().toLowerCase();
        String first = lower.substring(0, 1);
        String rest = lower.substring(1);
        return first.toUpperCase() + rest;
    }
}