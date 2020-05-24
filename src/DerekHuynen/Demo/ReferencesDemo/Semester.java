package DerekHuynen.Demo.ReferencesDemo;

/**
 * Enumeration of the possible semesters.  This is better than just using a string because
 * a) it is less overhead than a string, and b) it protects from data corruption.
 * @author	David Brown
 * @date	07/24/2019
 */
public enum Semester {
    FALL, SPRING, WINTER, SUMMER1, SUMMER2
}