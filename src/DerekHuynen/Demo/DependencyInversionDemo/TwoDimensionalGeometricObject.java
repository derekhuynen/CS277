package DerekHuynen.Demo.DependencyInversionDemo;

public interface TwoDimensionalGeometricObject {
    /**
     * Find the area of the TowDimensionalGeometricObject.
     * @return	Its area.
     */
    public double getArea ();

    /**
     * Find the perimeter (the length around the outside)
     * of the TowDimensionalGeometricObject.
     * @return	Its perimeter.
     */
    public double getPerimeter ();
}