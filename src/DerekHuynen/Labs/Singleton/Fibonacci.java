/**
 * Fibonacci
 * Lab Assignment: Singleton Pattern
 *
 * @author Derek Huynen
 * @author David
 * @date 4/16/2020
 * @version 1.00
 */

package DerekHuynen.Labs.Singleton;

import java.math.BigInteger;

public class Fibonacci {

public volatile static Fibonacci fibonacci = null;


static BigInteger prev1 =  BigInteger.ZERO;
static BigInteger prev2 =  BigInteger.ZERO;
private int counter = 0;


    /**
     * private Fibonacci
     */
    private Fibonacci(){ }


    /**
     *  Singleton Class
     * @return Fibonacci
     */
    public static Fibonacci getFibonacci(){

    if (Fibonacci.fibonacci == null) {
        Fibonacci.fibonacci = new Fibonacci();
    }

    return Fibonacci.fibonacci;
}

    /**
     * Calculates and returns the Next number in the Fibonacci sequence
     * @return BigInteger of next Fibonacci sequence
     */
    public BigInteger next(){
    BigInteger result;
    if(this.counter < 2){
        result = new BigInteger("" + counter);

        if(counter == 1) {
            Fibonacci.prev2 = BigInteger.ONE;
        }


    }else{
        result = new BigInteger(String.valueOf(Fibonacci.prev1.add(Fibonacci.prev2)));
        Fibonacci.prev1 = Fibonacci.prev2;
        Fibonacci.prev2 = result;
    }

    this.counter++;
    return result;
}

}
