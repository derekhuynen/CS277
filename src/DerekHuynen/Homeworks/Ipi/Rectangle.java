/**
 * Rectangle class.
 * Homework Assignment: IPI
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Homeworks.Ipi;

public class Rectangle extends GeometricObject{

    /**
     * The width of a Rectangle
     */
    private double width;
    /**
     * The height of a Rectangle
     */
    private double height;

    /**
     * Constructor used to set all variables
     * @param point Upper left Coordinate of the Rectangle
     * @param width the width of a the Rectangle
     * @param height the height of the Rectangle
     */
    public Rectangle(Point point, double width, double height){
        super.setPoint(point);
        if(width < 0 ) {
            throw new IllegalArgumentException("Width has to be greater than 0.");
        }
        if(height < 0 ) {
            throw new IllegalArgumentException("Height has to be greater than 0.");
        }

        this.width = width;
        this.height = height;
        super.setArea(calculateArea());
        super.setPerimeter(calculatePerimeter());
    }

    /**
     * Calculates and sets the Area of a Rectangle.
     * @return Area of a Rectangle as a double
     */
    private double calculateArea(){
        return this.width * this.height;
    }

    /**
     * Calculates and sets the Perimeter of a Rectangle.
     * @return Perimeter of a Rectangle as a double
     */
    private double calculatePerimeter(){
        return width * 2 +  height * 2;
    }

    /**
     * Converts the Rectangle Object to a String
     * @return Rectangle as a String
     */
    @Override
    public String toString() {
        return String.format("Rectangle: Left Corner: %s, Width: %.2f, Height: %.2f. %s",super.getPoint().toString(), this.width, this.height, super.toString());
    }
}
