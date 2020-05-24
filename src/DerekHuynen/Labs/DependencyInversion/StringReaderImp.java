/**
 * String Reader Imp
 * Lab: CECS 277 Lab Dependency Inversion
 * One of perhaps many StringReader interface implementations that we could build.
 *
 * @author	David Brown
 * @date	07/22/2019
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Labs.DependencyInversion;

import java.util.Scanner;

public class StringReaderImp implements StringReader{

    //For this simple example, we build our own Scanner object to read in lines of text.
    //This creates a dependency of StringReaderImp on the System.in and Scanner classes,
    //and we could have had them passed in as arguments to the constructor to reduce the
    //dependency.
    Scanner in;
    public StringReaderImp () {
        //squirrel away our input scanner for later.  Ideally, we would use a
        //factory here to make sure that we only have one System.in scanner
        //at a time since multiple System.in Scanners never seems to work right.
        MyScanner temp = new MyScanner();
        this.in = temp.getScanner();
    }

    /**\
     * Get Input from user
     * @return user input as String
     */
    @Override
    public String getValue() {
        String line;
        line = this.in.nextLine();
        return line;
    }

    /**
     * Check if there is next word
     * @return true if has next
     */
    @Override
    public boolean hasNext() {
        return this.in.hasNextLine();
    }
}