/**
 * Basic File IO
 * Lab Assignment: Basic File IO
 *
 *
 * I don't think it is very accurate. However I feel like i learned more about IO
 *
 * @author Derek Huynen
 * @date 3/05/2020
 * @version 1.00
 */

package DerekHuynen.Labs.BasicFileIO;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int records = 0;
        int wordCount = 0;
        int characterCount = 0;
        int upperCharacterCount = 0;
        int lowerCharacterCount = 0;
        int digits = 0;
        int numbers= 0;
        int specialChar = 0;
        ArrayList<String> specialChars = new ArrayList<>();


        //Pick a File
        JFileChooser jfc = new JFileChooser(new File("ReadFile.txt"));
        int returnValue = jfc.showOpenDialog(null);

        //Make sure choice is valid
        if(returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();

            //Attempt to read file
            try {
                Scanner fileScanner = new Scanner(selectedFile);
                while (fileScanner.hasNextLine()) {

                    String line = fileScanner.nextLine();

                    //Special Characters
                    for (int i = 0; i < line.length(); i++) {
                        if (line.substring(i, i+1).matches("[^A-Za-z0-9 ]")) {
                            if(!line.substring(i, i+1).trim().equals("")){
                                specialChar++;
                                if(!specialChars.contains(line.substring(i, i+1)))
                                    specialChars.add(line.substring(i, i+1));
                            }
                        }
                    }
                    //Remove all Special Chars to make things easier
                    line = line.replaceAll("[^a-zA-Z0-9]", "");

                    //Skip if Line isa Blank
                    if(!(line.equals(""))) {

                        // \\s+ is the space delimiter in java
                        String[] wordList = line.split("\\s+");

                        //Count Words
                        records += wordList.length;

                        //Check If it a number
                        for(String word : wordList) {

                            word = word.trim();
                            try {
                                Double.parseDouble(word);
                                numbers ++;
                                digits = digits + word.length();
                            } catch (NumberFormatException nfe) {
                                //Not an Number must be a Word
                                wordCount++;
                            }

                            //Checking each Char
                            for(int i = 0; i < word.length();i++){
                                if(Character.isLowerCase(word.charAt(i)))
                                    lowerCharacterCount++;

                                if (Character.isUpperCase(word.charAt(i)))
                                    upperCharacterCount++;

                                if(word.charAt(i) != ' ')
                                    characterCount++;

                                if(Character.isDigit(word.charAt(i)))
                                    digits++;

                            }
                        }
                    }
                }
                fileScanner.close();

                FileWriter myWriter = new FileWriter("output.txt");
                myWriter.write(String.format("%s Stats",selectedFile.getName()));
                myWriter.write(String.format("%-20s %s\n","Path:" ,selectedFile.getAbsolutePath()));
                myWriter.write(String.format("%-20s %d\n","Bytes:",selectedFile.length()));
                myWriter.write(String.format("%-20s %d\n","Records:",records));
                myWriter.write(String.format("%-20s %d\n","Word Count:",wordCount));
                myWriter.write(String.format("%-20s %d\n","Upper Characters:",upperCharacterCount));
                myWriter.write(String.format("%-20s %d\n","Lower Characters:",lowerCharacterCount));
                myWriter.write(String.format("%-20s %d\n","All Characters:",characterCount));
                myWriter.write(String.format("%-20s %d\n","Special Characters:",specialChar));
                myWriter.write(String.format("%-20s %d\n","Digit:",digits));
                myWriter.write(String.format("%-20s %d\n","Number:",numbers));
                myWriter.write(String.format("%-20s %s","Special Characters:",specialChars.toString()));
                myWriter.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
