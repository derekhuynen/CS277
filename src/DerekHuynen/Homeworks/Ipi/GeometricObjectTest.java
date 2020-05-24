/**
 * GeometricObjectRunner Class.
 * Homework Assignment: IPI
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Homeworks.Ipi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GeometricObjectTest {


    private Point point0 = new Point(0.0, 0.0),
                point1 = new Point(1.0, 2.0),
                point2 = new Point(2.0, 0.0);


    private GeometricObject[] geometricObjects = new GeometricObject[]{
            new Rectangle(point0, 10, 2),
            new Rectangle(point1, 8, 2),
            new Circle(point0, 10),
            new Triangle(point0, point1, point2)
    };

    private GeometricObject[] geometricObjectsSorted = new GeometricObject[]{
            new Triangle(point0, point1, point2),
            new Rectangle(point1, 8, 2),
            new Rectangle(point0, 10, 2),
            new Circle(point0, 10)


    };


    /**
     *      Test Print
     *      NOT DYNAMIC
     */
    @Test
    @DisplayName(value = "Test Print")
    public void testPrint() {
        printArray(geometricObjects);

    }

    /**
     * Test to test the sort method
     * NOT DYNAMIC
     */
    @Test
    @DisplayName(value = "Test Sort")
    public void testSort() {

        GeometricObject[]geometricObjectsCopy = geometricObjects.clone();
        Arrays.parallelSort(geometricObjectsCopy);

        assertEquals(Arrays.toString(geometricObjectsSorted), Arrays.toString(geometricObjectsCopy));
    }

    /**
     * Test Max
     */
    @Test
    @DisplayName(value = "Test Max")
    public void testMax() {

        assertEquals(geometricObjects[2].toString(), GeometricObjectTest.max(geometricObjects).toString());
    }

    /**
     * Calculates the Larger of two Geometric Objects by their Area
     * @param geometricObjects array of objects
     * @return The Larger Geometric Object by their Area
     */
    private static GeometricObject max (GeometricObject[]geometricObjects){
        GeometricObject result = new GeometricObject();

        for (GeometricObject geometricObject : geometricObjects) {
            result = result.max(geometricObject);
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