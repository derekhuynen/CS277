package DerekHuynen.Labs.Factory;

public abstract class CircleAbstractClass extends GeometricShape
{
    @Override
    public double getArea()
    {
        double diameter = this.getPoints()[0].distance(this.getPoints()[1]);
        double radius = diameter/2;
        return (radius*radius)*Math.PI;
    }

    @Override
    public double getPerimeter() {
        return this.getPoints()[0].distance(this.getPoints()[1]);
    }

    @Override
    public Point getLocation() {
        return this.getPoints()[0].between(this.getPoints()[1]);				//The first point is the location of the line segment
    }

    @Override
    public abstract Point[] getPoints();

    @Override
    public String toString () {
        return "2 point circle: Circle - Located at: " + this.getPoints()[0] + " to " + this.getPoints()[1] + " Area: " + this.getArea() + " Radius: " + (this.getPerimeter())/2+" Center: "+getLocation();
    } // End of the toString method

}

