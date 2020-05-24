package DerekHuynen.Labs.Factory;

public class FactoryRunner
{
    public static String printPoints (Point [] points) {
        StringBuilder sb = new StringBuilder ("Points: ");
        for (Point next :points) {
            sb.append(next);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void checkPoints (Point [] points) {
        System.out.println ("Checking points: " + printPoints(points));
        try {
            RectangleAbstractClass.checkAngles(points);
            System.out.println ("Those points are AOK");
        } catch (InvalidShapeException ISE) {
            System.out.println (ISE.getMessage());
        }

    }
    public static void checkRectangle (String message, Point [] points) {
        System.out.println (message);
        try {
            RectanglePointWidthHeight rect = new RectanglePointWidthHeight (points);
            System.out.println ("Checked out angle-wise: " + rect);
        } catch (InvalidShapeException ISE) {
            System.out.println (ISE.getMessage());
        }
    }

    public static void main(String[] args) throws InvalidShapeException {
        Point P1 = new Point (0,0), P2 = new Point (5, 0), P3 = new Point (5, -10),
                P4 = new Point (0, -10), P5 = new Point (0, -11);
        Point [] corners1 = {P1, P2, P3, P4};
        checkPoints (corners1);
        Point [] corners2 = {P1, P2, P3, P5};
        checkPoints (corners2);
        Point [] corners3 = {P1, P3, P2, P4};
        checkPoints(corners3);
        Point [] corners4 = {P4, P3, P2, P1};
        System.out.println ("Checking reversed corners ");
        checkPoints (corners4);
        Point C1 = new Point (0, 0);
        Point C2 = new Point (5, 5);
        Point C3 = new Point (10, 0);
        Point C4 = new Point (5, -5);
        Point [] corners5 = {C1, C2, C3, C4};
        System.out.println ("Checking square at a 45 degree angle: ");
        checkPoints (corners5);
        checkRectangle ("Square rectangle: ", corners1);
        checkRectangle ("Reversed rectangle: ", corners4);
        Point P6 = new Point (0, 10), P7 = new Point(-5, -10), P8 = new Point(-5, 0), P9 = new Point(-5, 10);
        Point [] corners6 = {P1, P6, P7, P8};
        checkRectangle ("w and h both negative: ", corners6);
        Point [] corners7 = {P1, P6, P9, P8};
        checkRectangle ("w and h both negative: ", corners7);
        Point P10 = new Point (0, 5), P11 = new Point (10, -5);
        Point [] corners8 = {P8, P10, P11, P3};
        checkRectangle ("45 degree angle: ", corners8);
        System.out.println("Testing the factory!");
        AbstractFactory factory = FactoryProvider.getFactory(FactoryType.POINTS);
        GeometricShape rectangle = factory.getGeometricShape(ShapeType.RECTANGLE, corners1);
        System.out.println(rectangle);
        GeometricShape line = factory.getGeometricShape(ShapeType.LINE_SEGMENT, corners3);
        System.out.println(line);
        System.out.println ("Points and Dimensions");
        AbstractFactory factoryPD = FactoryProvider.getFactory(FactoryType.POINT_DIMENSIONS);
        rectangle = factoryPD.getGeometricShape(ShapeType.RECTANGLE, corners8);
        System.out.println ("45 Degree rectangle");
        System.out.println (rectangle);
        line = factoryPD.getGeometricShape(ShapeType.LINE_SEGMENT, corners3);
        System.out.println ("Line segment Point and Direction:");
        System.out.println (line);
        Point[] circlePoints = {P2,P3};
        GeometricShape circle = factory.getGeometricShape(ShapeType.CIRCLE, circlePoints);
        System.out.println (circle);
        System.out.println ("Completed satisfactorily");
        
    }

}

