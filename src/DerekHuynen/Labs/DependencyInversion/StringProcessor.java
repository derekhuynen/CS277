/**
 * String Processor
 * Lab: CECS 277 Lab Dependency Inversion
 *
 * @author Derek Huynen
 * @version 1.00 2/18/2020
 */

package DerekHuynen.Labs.DependencyInversion;

public class StringProcessor {
    /** The object that will do the reading for us */
    private final StringReader stringReader;
    /** The object that will do the writing for us */
    private final StringWriter stringWriter;

    /**
     * Dependency injecting constructor.
     * @param stringReader	The reader that we'll use.
     * @param stringWriter	The writer that we'll use.
     */
    public StringProcessor(StringReader stringReader, StringWriter stringWriter) {
        this.stringReader = stringReader;
        this.stringWriter = stringWriter;
    }

    /**
     * Take a record from the input, and immediately write it to the output.
     */
    public void printString() {
        stringWriter.write(stringReader.getValue());
    }

}