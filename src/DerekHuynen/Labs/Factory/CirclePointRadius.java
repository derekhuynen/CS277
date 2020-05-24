package DerekHuynen.Labs.Factory;

public class CirclePointRadius extends CircleAbstractClass
{

    private Point center;
    private double radius;

    public CirclePointRadius(Point[] points)
    {
        this.center = points[0].between(points[1]);
        this.radius = points[0].distance(points[1]) /2 ;
    }


    @Override
    public Point[] getPoints() {
        Point [] points = {new Point(this.center.getX(), (this.center.getY() + this.radius)),
                            new Point ( this.center.getX(), (this.center.getY() - this.radius)) };

        return points;
    }


    public double getRadius(){
        return this.radius;
    }

    public Point getCenter(){
        return this.center;
    }

}