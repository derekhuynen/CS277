package DerekHuynen.Midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * CountMixed
 * @author	Derek Huynen
 * @date	3/26/2020
 */
public class CountMixed {


    public static void main(String[] args) {
        File file = new File("src\\DerekHuynen\\Midterm\\Mixed.txt");
        String temp = "";
        boolean found = false;
        int tally = 0;

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                temp = scanner.nextLine();
                char [] charArray = temp.toCharArray();

                for(int i = 0; i < charArray.length; i++){
                    if(Character.isUpperCase(charArray[i]) || Character.isLowerCase(charArray[i])){
                        tally++;
                        break;
                    }
                }
            }


        } catch (FileNotFoundException FNFE) {
            System.out.print("Could not find file.");
        }
    System.out.println("Number of Lines with Letters " + tally);
    }
}
