/**
 * DependencyInversionRunner
 * Lab: CECS 277 Lab Dependency Inversion
 *
 * Loosely borrowed from: https://www.baeldung.com/java-dependency-inversion-principle.
 * @author	Derek Huynen
 * @date	07/23/2019
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Labs.DependencyInversion;

public class DependencyInversionRunner {

    public static void main(String[] args) {
        //get an instance of the reader and writer interfaces.  The sr and sw
        //variables only "know" about the methods that those respective interfaces
        //include.  Any other methods that the concrete implementations include
        //will not be available.
        StringReader sr = new StringReaderImp ();
        StringWriter sw = new StringWriterImp ();
        StringProcessor SPD = new StringProcessor (sr, sw);
        while (sr.hasNext()) {
            SPD.printString();
        }
        sw.write("Completed successfully");
    }
}