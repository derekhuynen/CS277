/**
 * Triangle class.
 * Homework Assignment: IPI
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Homeworks.Ipi;

public class Triangle extends GeometricObject{
    /**
     * The two Addition Coordinates of a Triangle as Point Objects
     */
    private Point point2, point3;

    /**
     * Constructor used to set all variables
     * @param point1 First Point of the Triangle
     * @param point2 Second Point of the Triangle
     * @param point3 Third Point of the Triangle
     */
    public Triangle(Point point1, Point point2, Point point3){
        super.setPoint(point1);
        this.point2 = point2;
        this.point3 = point3;
        super.setArea(this.calculateArea());
        super.setPerimeter(this.calculatePerimeter());
    }

    /**
     * Calculates and sets the Area of a Triangle
     * @return Area of a Triangle as a double
     */
    private double calculateArea(){
        double side1 = super.getPoint().distance(point2),
                side2 = point2.distance(point3),
                side3 = point3.distance(super.getPoint()),
                s = (side1 + side2 + side3 ) / 2;

        return Math.sqrt(s*(s-side1)*(s-side1)*(s-side3));
    }

    /**
     * Calculates and sets the Perimeter of a Triangle
     * @return Perimeter of a TRriangle as a double
     */
    private double calculatePerimeter(){
        return ( super.getPoint().distance(point2) +
                    point2.distance(point3) +
                    point3.distance( super.getPoint()));
    }

    /**
     *  Converts Triangle Object to a Sting
     * @return Triangle as a String ("Triangle: Point1: %s, Point 2: %s, Point3: %s, %s")
     */
    @Override
    public String toString() {
        return String.format("Triangle: Point1: %s, Point 2: %s, Point3: %s, %s",super.getPoint().toString(),this.point2.toString(),this.point3.toString(),super.toString());
    }
}
