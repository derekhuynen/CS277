/**
 * Circle class.
 * Homework Assignment: IPI
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Homeworks.Ipi;

public class Circle extends GeometricObject{

    /**
     * Radius of the Circle
     */
    private double radius;

    /**
     * Constructor used to set all variables
     * @param center the Center of the Circle as a Point Object
     * @param radius the Radius of the Circle as a double
     */
    public Circle(Point center, double radius){
        if(radius < 0 ){
            throw new IllegalArgumentException("Radius must be greater than 0.");
        }
        super.setPoint(center);
        this.radius = radius;
        super.setArea(this.calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    /**
     * Calculates and sets the Area of a Circle
     * @return Area of Circle as a double
     */
    private double calculateArea(){
        return Math.PI * (radius * radius);
    }

    /**
     * Calculates and sets the Perimeter of a Circle Object
     * @return Perimeter of Cirlce as double
     */
    private double calculatePerimeter(){
        return Math.PI * 2 * radius;
    }

    /**
     * Converts the Circle Object to a String
     * @return Circle as a String
     */
    @Override
    public String toString() {
        return String.format("Circle: center: %s, Radius: %.2f, %s",super.getPoint().toString(), this.radius, super.toString());
    }

}
