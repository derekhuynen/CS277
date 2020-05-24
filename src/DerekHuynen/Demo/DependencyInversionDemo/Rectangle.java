package DerekHuynen.Demo.DependencyInversionDemo;

public class Rectangle implements TwoDimensionalGeometricObject{
    /** The width of the rectangle */
    double width;
    /** the length of the rectangle */
    double length;
    /** The location of the upper left hand corner */
    Point upperLeft;

    public Rectangle (Point upperLeft, double Width, double Length) {
        this.upperLeft = upperLeft;
        if (Width < 0) {
            throw new IllegalArgumentException ("Width has to be > 0!");
        }
        this.width = Width;
        if (Length < 0) {
            throw new IllegalArgumentException ("Length has to be > 0!");
        }
        this.length = Length;
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    @Override
    public double getPerimeter() {
        return (Math.abs(this.getLength()) + Math.abs(this.getWidth())) * 2;
    }


    @Override
    public double getArea() {
        return Math.abs(this.getLength()) * Math.abs(this.getWidth());
    }

    @Override
    public String toString() {
        return "Rectangle: Upper left corner at: " + this.getUpperLeft() + " Width: " + this.getWidth() +
                " Length: " + this.getLength();
    }

}