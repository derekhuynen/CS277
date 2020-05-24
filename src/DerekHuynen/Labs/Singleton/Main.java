/**
 * SingletonPattern
 * Lab Assignment: Singleton Pattern
 *
 * @author Derek Huynen
 * @author David
 * @date 4/16/2020
 * @version 1.00
 */

package DerekHuynen.Labs.Singleton;

public class Main {

    public static void main(String[] args) {
	for( int i = 0; i < 200; i++ ){
        System.out.println(i + "the Fibonacci number is: " + Fibonacci.getFibonacci().next());

        }
    }
}
