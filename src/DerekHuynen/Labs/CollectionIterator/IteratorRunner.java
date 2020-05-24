/**
 * Iterator Lab
 * @author	Derek Huynen
 * @date	10/15/2019
 */
package DerekHuynen.Labs.CollectionIterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class IteratorRunner {

    public static void main(String[] args) {
        //Using a TreeMap will sort words in Alphabetical order
        Map<String, Integer> map = new TreeMap<>();

        try (Scanner scanner = new Scanner(new File("Pride and Prejudice.txt"))){
            while (scanner.hasNext()){
                String word = scanner.next().toLowerCase().replaceAll("[^a-z]","");

                if(map.containsKey(word)){
                    int temp = map.get(word);
                    map.replace(word,temp+1);
                }else{
                    map.put(word,1);
                }
            }

            //This is not efficient at all? could get whole Set
            Iterator<String> iterator = map.keySet().iterator();

            //Could use advance for loop instead or lambda
            // map.forEach((key, value) -> System.out.println(key + " : " + value));
            while( iterator.hasNext()){
                String temp = iterator.next();
                System.out.println(temp + " : " + map.get(temp));
            }


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
