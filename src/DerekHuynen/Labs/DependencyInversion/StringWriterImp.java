/**
 * String Writer Imp
 * Lab: CECS 277 Lab Dependency Inversion
 * One of perhaps many StringReader interface implementations that we could build.
 *
 * @author	David Brown
 * @date	07/22/2019
 */

package DerekHuynen.Labs.DependencyInversion;

public class StringWriterImp implements StringWriter{

    /**
     Write user output console.
     */
    @Override
    public void write(String value) {
        System.out.println(value);
    }
}