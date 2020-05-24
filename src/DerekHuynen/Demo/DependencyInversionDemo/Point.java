package DerekHuynen.Demo.DependencyInversionDemo;

public class Point implements TwoDimensionalGeometricObject {

    private double x;
    private double y;
    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() { return this.x; }
    double getY() { return this.y; }

    public String toString () {
        return "Point: X: " + this.getX() + " Y: " + this.getY();
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }

}
