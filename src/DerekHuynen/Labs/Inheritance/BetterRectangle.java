/**
 * Better Rectangle
 *
 * Lab: CECS277 Lab Inheritance
 *
 * @author Julien Delane
 * @author Derek Huynen
 * @version 1.00 28/01/2020
 */
package DerekHuynen.Labs.Inheritance;

public class BetterRectangle extends java.awt.Rectangle {

    /**
     *
     * @param x The X coordinate of the upper-left corner of the Rectangle.
     * @param y The Y coordinate of the upper-left corner of the Rectangle.
     * @param width The width of the rectangle
     * @param height The Height of the rectangle
     */
    public BetterRectangle(int x,int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * Calculates the perimeter of the rectangle
     *
     * @return the perimeter of the rectangle
     */
    public int getPerimeter() {
        return super.width * 2 + super.height * 2;
    }

    /**
     *Calculates the Area of the rectangle
     * @return the area of the rectangle
     */
    public int getArea() {
        return super.width * super.height;
    }

    /**
     * Overrides the parents toString();
     * @return A Better format of toString that includes Area and perimeter
     */
    @Override
    public String toString() {
        return String.format("Better Rectangle toString: \n" +
                "%s\n" +
                "area of Better Rectangle: %d\n" +
                "perimeter of Better Rectangle: %d"
                ,super.toString() ,getArea(), getPerimeter());
    }
}
