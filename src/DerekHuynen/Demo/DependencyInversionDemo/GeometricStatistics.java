package DerekHuynen.Demo.DependencyInversionDemo;

/**
 * Perform some calculations on a collection of shapes.
 */
public class GeometricStatistics {
    /**
     * Return the sum of the area of all of the shapes passed in.
     * @param shapes	An array of shapes.
     * @return			The sum of their square area.
     */
    static final double sumArea (TwoDimensionalGeometricObject [] shapes) {
        double result = 0;
        for (int i = 0; i < shapes.length; i++) {
            result += shapes[i].getArea();
        }
        return result;
    }

    /**
     * Return the sum of the perimeters of all of the shapes passed in.
     * @param figures	An array of geometric shapes.
     * @return			The sum of all of their perimeters.
     */
    static final double sumPerimeter (TwoDimensionalGeometricObject [] figures) {
        double result = 0;
        for (int i = 0; i < figures.length; i++) {
            result += figures[i].getPerimeter();
        }
        return result;
    }
}