package DerekHuynen.Demo.DependencyInversionDemo;

public class GeometricStatisticsRunner {

    public static void main(String[] args) {
        Point p1 = new Point (1, 2);
        Point p2 = new Point (5, 4);
        TwoDimensionalGeometricObject hiddenFigures [] = {
                p1,
                new Circle (p1, 5),
                new Rectangle (p2, 3, 2),
                new Circle (p2, 3)
        };
        System.out.println ("The sum of areas is: " + GeometricStatistics.sumArea(hiddenFigures));
        System.out.println("The sum of perimeters is: " + GeometricStatistics.sumPerimeter(hiddenFigures));
    }

}