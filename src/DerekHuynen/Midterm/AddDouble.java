package DerekHuynen.Midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Add Double
 * @author	Derek Huynen
 * @date	3/26/2020
 */
public class AddDouble {

    public static void main(String[] args) {

        double tally= 0;
        File file = new File("src\\DerekHuynen\\Midterm\\Double.txt");

        try(Scanner scanner = new Scanner(file)){

            while(scanner.hasNextDouble()){
                tally += scanner.nextDouble();
            }

            System.out.print(tally);
        }catch (FileNotFoundException FNFE){
            System.out.print("Could not find file.");
        }
    }


}
