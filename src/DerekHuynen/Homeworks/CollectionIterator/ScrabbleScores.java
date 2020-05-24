/**
 * ScrabbleScores
 * Homework Assignment: Collection
 *
 * @author Derek Huynen
 * @author David
 * @date 4/16/2020
 * @version 1.00
 */
package DerekHuynen.Homeworks.CollectionIterator;

import java.io.*;
import java.util.*;


public class ScrabbleScores
{
    public static void main(String[] args)
    {

        ScrabbleScores scrabbleScores = new ScrabbleScores();
        HashMap<Character, Integer> scrabbleScoreMap = scrabbleScores.getScrabbleScoreValues();
        scrabbleScores.computeScrabbleScores(scrabbleScoreMap);


    } // End of the main Method.

    /**
     * Get values for each letter of the word
     * @return Hashmap of Character and Values
     */
    public HashMap<Character, Integer> getScrabbleScoreValues()
    {
        HashMap<Character, Integer> scrabbleScoreMap = new HashMap<>();

        try (Scanner scanner = new Scanner(new File("src\\DerekHuynen\\CollectionIterator\\ScrabblePoints.txt"))){

            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                int scoreValue = Integer.parseInt(line.replaceAll("[\\D]", ""));
                String letters = line.replaceAll("\\d+","");
                for (char c : letters.toCharArray())
                {
                    scrabbleScoreMap.put(c, scoreValue);
                }

            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not find the file \"ScrabblePoints.txt\".");
        }

        return scrabbleScoreMap;

    } // End of the getScrabbleScoreValues Method.

    /**
     * Calculates the Value for each word
     * @param scrabbleScoreMap Hashmap of words and there total value.
     */
    public void computeScrabbleScores(HashMap<Character, Integer> scrabbleScoreMap)
    {


        try (Scanner scanner = new Scanner(new File("src\\DerekHuynen\\CollectionIterator\\Q words.txt"))) {

            while (scanner.hasNextLine())
            {
                int wordValue = 0;
                String qWord = scanner.nextLine();
                for (char c : qWord.toCharArray())
                {
                    char uppercaseC = Character.toUpperCase(c);
                    //System.out.println((scrabbleScoreMap));
                    wordValue = wordValue + scrabbleScoreMap.get(uppercaseC);

                }
                System.out.println("Score for word: " + qWord + " is: " + wordValue);

            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Could not find the file \"Q words.txt\"");
        }


    } // End of the computeScrabbleScores Method.

} // End of the Scrabble Class.