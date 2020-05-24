package DerekHuynen.Demo.DependencyInversionDemo;

public class Circle implements TwoDimensionalGeometricObject {

    /** Location of the Circle. */
    Point center;
    /** Radius of the Circle */
    double radius;

    /**
     * Create an instance of Circle.
     * @param center	The center point for the circle.
     * @param radius	The radius of the circle.
     */
    public Circle (Point center, double radius) {
        this.center = center;
        if (radius < 0) {
            throw new IllegalArgumentException ("Circle radii must be > 0!");
        }
        this.radius = radius;
    }

    public Point getCenter () { return this.center; }

    public double getRadius () { return this.radius; }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "Circle: Center at: " + this.getCenter() + " Radius: " + this.getRadius();
    }
}