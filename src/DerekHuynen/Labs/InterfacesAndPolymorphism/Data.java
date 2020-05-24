/**
 * Data Class
 * Lab: CECS 277 Lab Interfaces And Polymorphism
 * @author Derek Huynen
 */

package DerekHuynen.Labs.InterfacesAndPolymorphism;

public class Data
{
    /**
     Computes the average of the measures of the given objects.
     @param objects an array of Measurable objects
     @return the average of the measures
     */
    public static double average(Measurable[] objects)
    {
        double sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }
        return (objects.length > 0) ? sum / objects.length : 0;
    }


    /**
     * Finds the Object with the smallest value
     * @param objects being searched
     * @return value of the smallest Object in Array
     */
    public static double smallest(Measurable[] objects){
        double smallest = 0;

        for(Measurable obj : objects) {
            if(obj.getMeasure() < smallest){
                smallest = obj.getMeasure();
            }
        }
        return smallest;
    }
}