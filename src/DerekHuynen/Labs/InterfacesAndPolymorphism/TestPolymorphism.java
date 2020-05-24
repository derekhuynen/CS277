/**
 * Testing Class
 * Lab: CECS 277 Lab Interfaces And Polymorphism
 * @author Derek Huynen
 */

package DerekHuynen.Labs.InterfacesAndPolymorphism;


import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLOutput;
import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TestPolymorphism {

    private final Person[] people = new Person[]{
            new Person("Derek","Huynen",25),
            new Person("Jake","Smith",18),
            new Person("Marc","Jones",40)
    };

    /**
     * Simple Test to use as an example.
     * Counts the number of Person in array of people.
     */
    @Test
    @DisplayName(value = "Test Count")
    public void testCount() {

        int expectedCount = 0;
        for (; expectedCount < this.people.length; expectedCount++);

        assertEquals (expectedCount, this.people.length);
    }

    /**
     * Test to see if Sort Works.
     */
    @Test
    @DisplayName(value = "Test Sort")
    public void testSort() {

        Person[] peopleCopy = deepCopy(this.people);
        Arrays.parallelSort(peopleCopy);

        assertTrue (testSorted(peopleCopy));
    }

    /**
     * Test to see if Average Works of array of Measurable
     */
    @Test
    @DisplayName(value = "Test Average")
    public void testAverage() {
        double average;
        double sum = 0;
        for (Person person : this.people) {
            sum += person.getAge();
        }
        average =  (this.people.length > 0 ? sum / this.people.length : 0);

        assertEquals ( average, Data.average(this.people));
    }

    /**
     * Tests the return value of youngest person
     */
    @Test
    @DisplayName(value = "Test Smallest")
    public void testSmallest() {
        double smallest = 0;

        for(Person person: this.people) {
            if(person.getMeasure() < smallest){
                smallest = person.getMeasure();
            }
        }

        assertEquals ( smallest, Data.smallest(this.people));
    }

    /**
     * Check to see if array is sorted Least to Greatest
     * @param people array of person
     * @return true if array is sorted
     */
    public static boolean testSorted(Person[] people){
        boolean sorted = true;
        int i = 0;
        while (i < people.length - 1 && sorted ){
            if(people[i].compareTo(people[i + 1]) > 0)
                sorted = false;
            i++;
        }
        return sorted;
    }

    /**
     * returns a Deep copy of the Array
     * @param people array of person
     * @return a deep copy of People.
     */
    public Person[] deepCopy(Person[] people){
        return people.clone();
    }
}