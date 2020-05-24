package DerekHuynen.Labs.Factory;

public class Circle2Points extends CircleAbstractClass
{

    Point [] points;

    public Circle2Points (Point [] points) {
        //Make a deep copy of the set of points passed in.
        this.points = Point.clone(points);
    } // End of the LineSegment2Points constructor



    @Override
    public Point[] getPoints() {
        return Point.clone(this.points);
    }
}