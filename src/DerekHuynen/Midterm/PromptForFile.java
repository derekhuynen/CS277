package DerekHuynen.Midterm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * PromterForFile
 * @author	Derek Huynen
 * @date	3/26/2020
 */
public class PromptForFile {


    public static void main(String[] args) {


        Scanner in = null;                //Input file
        boolean foundInFile = false;            //Flag that we don't have an input file.
        do {

            try {
                System.out.print("Enter a file name? ");
                Scanner userInput = new Scanner(System.in);

                File myObj = new File("src\\DerekHuynen\\Midterm\\"+ userInput.nextLine() + ".txt");
                if (myObj.exists()) {
                    in = new Scanner(myObj);
                    while(in.hasNextLine()){
                        System.out.println(in.nextLine());
                    }
                    foundInFile = true;

                } else {
                    throw new FileNotFoundException("File doesn't exist");
                }
            } catch (FileNotFoundException e) {
                System.out.printf("An error occurred. %s\n\n", e);
            }

        } while (!foundInFile);
    }


}
