/**
 * GeometricObjectRunner Class.
 * Homework Assignment: IPI
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Homeworks.Ipi;
import java.util.Arrays;

public class GeometricObjectRunner {

    public static void main(String[] args) {

        try{
            /**
             Create 3 points to be used for the GeometricObjects
             */
            Point point0 = new Point(0.0, 0.0),
                    point1 = new Point(1.0, 2.0),
                    point2 = new Point(2.0, 0.0);

            /**
             Create an array of GeometricObjects (at least one rectangle, circle, triangle)
             */
            GeometricObject[] geometricObjects = new GeometricObject[]{
                    new Rectangle(point0, 10, 2),
                    new Rectangle(point1, 8, 2),
                    new Circle(point0, 10),
                    new Triangle(point0, point1, point2)
            };

            printArray(geometricObjects);
            Arrays.parallelSort(geometricObjects);
            System.out.println("\nAfter Sort Sort:");
            printArray(geometricObjects);
            System.out.printf("\nLargest found was: %s",max(geometricObjects).toString());

        }catch(Exception e){
            System.out.println(e);
        }

    }

    /**
     * Calculates the Larger of two Geometric Objects by their Area
     * @param geometricObjects array of objects
     * @return The Larger Geometric Object by their Area
     */
    private static GeometricObject max(GeometricObject[] geometricObjects){
        GeometricObject result = geometricObjects[0];

        for (int i = 1; i < geometricObjects.length; i++){
            result = result.max(geometricObjects[i]);
        }
        return result;
    }

    /**
     * Prints the array
     * @param geometricObjects array of objects
     */
    private static void printArray(GeometricObject[] geometricObjects){
        for( GeometricObject geometricObject : geometricObjects)
            System.out.println(geometricObject);
    }
}
