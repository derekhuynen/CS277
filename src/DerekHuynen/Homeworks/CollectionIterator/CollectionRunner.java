/**
 * CollectionRunner
 * Homework Assignment: Collection
 *
 * @author Derek Huynen
 * @author David
 * @date 4/16/2020
 * @version 1.00
 */
package DerekHuynen.Homeworks.CollectionIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * Test the difference between Tree map and HashMap
 */
public class CollectionRunner {

    public static void main(String[] args) {

        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> hashMap = new HashMap<>();

        System.out.println("Using a TreeMap:\n");
        readFile(treeMap);

        System.out.println("********************************************************************");

        System.out.println("Using a HasMap:\n");
        readFile(hashMap);

    } //End


    /**
     * Reads the File and Puts all words ina  map and Counts the amount of times the word occurs
     *
     * @param map to put the words into
     */
    public static void readFile(Map<String, Integer> map) {

        //Counter for total words in file
        int totalWords = 0;

        //try catch with resource to creat a scanner with specific file name
        try (Scanner scanner = new Scanner(new File("src\\DerekHuynen\\CollectionIterator\\War and Peace.txt"))) {
            //Create an instance before we start putting items into Map
            Instant now = Instant.now();

            //Loop through entire File word by word
            while (scanner.hasNext()) {

                //set word to lowercase and remove all non alpha chars
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");

                //Increase total words by 1
                totalWords += 1;

                //Put words into map.
                if (map.containsKey(word)) {
                    int temp = map.get(word);
                    map.replace(word, temp + 1);
                } else {
                    map.put(word, 1);
                }
            }

            //Create a second instance after done reading entire file.
            Instant after = Instant.now();


            System.out.println("Total number of words: " + totalWords);
            System.out.println("Time: " + (float) Duration.between(now, after).toMillis()/1000 + " seconds");


            //Create an iterator of whole map
            Iterator<String> iterator = map.keySet().iterator();

            //Loop through iterator
            while (iterator.hasNext()) {
                String temp = iterator.next();
                System.out.printf("%-25s : %5d %s\n", temp + " occurred", map.get(temp), (map.get(temp) == 1 ? "time" : "times"));
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file War and Peace could not be found.");
        }

    }

}//End

