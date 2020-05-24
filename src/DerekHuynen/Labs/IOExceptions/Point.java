package DerekHuynen.Labs.IOExceptions;

public class Point {
    /**
     * The X and Y Coordinates of a Point
     */
    private double x, y;


    /**
     * Constructor used to set all variables.
     * @param x the X coordinate
     * @param y the Y coordinate
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Calculates the Distance between this point and another.
     * @param other the other point being used to calculate the distance.
     * @return the distance between the two points
     */
    public double distance(Point other){
        return Math.sqrt((other.x-this.x)*(other.x-this.x) + (other.y-this.y)*(other.y-this.y));
    }

    /**
     * Converts the Point Object to a String
     * @return Point as a String
     */
    @Override
    public String toString() {
        return String.format("X: %.2f, Y: %.2f",this.x, this.y);
    }
}