/**
 * GeometricObject Class.
 * Homework Assignment: IPI
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Homeworks.Ipi;

public class GeometricObject implements Comparable<GeometricObject> {

    private Point point;

    /**
        Area of a Geometric Object
     */
    private double area;

    /**
     * Default constructor
     */
    public GeometricObject(){
        //Empty
    }

    /**
     * Point Shared for all shapes
     * @param point of the Geometric Object
     */
    public void setPoint(Point point) {
        this.point = point;
    }

    /**
     * Getter for the point of a Geometric Object
     * @return point of geometric object
     */
    public Point getPoint() {
        return point;
    }

    /**
        Perimeter of a Geometric Object
     */
    private double perimeter;

    /**
     * Sets the Area of a geometric Object
     * @param area is a double of area of a geometric Object.
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * Sets the perimeter of a geometric Object
     * @param perimeter is a double of perimeter of a geometric Object.
     */
    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    /**
     * Gets the area of a geometric figure.
     * @return area is a double of the area of a geometric figure.
     */
    public double getArea() {
        return area;
    }

    /**
     * Gets the perimeter of a geometric figure.
     * @return area is a double of the perimeter of a geometric figure.
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Determines the Larger of 2 geometric Objects Based on their Area()
     * @param other Geometric Object to be compared
     * @return Larger geometricObject
     */
    public GeometricObject max(GeometricObject other){
        return (this.compareTo(other) > 0) ? this : (this.compareTo(other) < 0) ? other : null;
    }

    /**
     * Compare this geometricObject to another based on their Area();
     * @param geometricObject the object to be compared.
     * @return int value. (-1) (0) (1)
     */
    @Override
    public int compareTo(GeometricObject geometricObject) {
         return Double.compare(this.area, geometricObject.getArea() );
    }

    /**
     * Converts Geometric Object to a String
     * @return String ("Area: 1, Perimeter: 1")
     */
    @Override
    public String toString() {
        return String.format("Area: %.2f, Perimeter: %.2f",getArea(),getPerimeter());
    }
}
