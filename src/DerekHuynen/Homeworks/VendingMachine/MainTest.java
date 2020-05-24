/**
 * VendingMachine Test Class
 * Homework Assignment: Vending Machine
 *
 * @author Derek Huynen
 * @date 2/20/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.VendingMachine;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.naming.InsufficientResourcesException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    VendingMachine vendingMachine = new VendingMachine();


    @Test
    @DisplayName(value = "Test Inserting Coin")
    public void testAddProduct()  {

        String test = "Water"; //Can Change Here to test Different Ones.
        int quantity = 1;

        Container container = vendingMachine.addProduct(test,quantity);
        assertEquals(container.getItem().getName(),test);
    }

    @Test
    @DisplayName(value = "Test Inserting Coin")
    public void testAddProductTwo()  {

        String product = "Water"; //Can Change Here to test Different Ones.
        int quantity = 2;

        Container container = vendingMachine.addProduct(product,quantity);
        assertEquals(container.getTotal(),quantity);
    }

    @Test
    @DisplayName(value = "Test Inserting Coin")
    public void testInsertCoinOne()  {
        String test = "Penny"; //Can Change Here to test Different Ones.
        Container container = vendingMachine.insertCoin(test);
        assertEquals(container.getItem().getName(),test);
    }

    @Test
    @DisplayName(value = "Test Inserting Coin Upper and Lower Case")
    public void testInsertCoinUpperAndLower()  {

        vendingMachine.insertCoin("Dollar");
        vendingMachine.insertCoin("dOlLaR");
        vendingMachine.insertCoin("DoLlAr");
        vendingMachine.insertCoin("dollar");
        Container container = vendingMachine.insertCoin("dOLLAr");

        assertEquals(container.getTotal(),5.00,0.001);
    }


    @Test
    @DisplayName(value = "Test Exception: Item Sold Out")
    public void testBuyQuantityInsufficientResourcesException() {
        vendingMachine.insertCoin("Dollar");
        vendingMachine.insertCoin("dollar");
        vendingMachine.insertCoin("DoLlAr");

        Assertions.assertThrows(InsufficientResourcesException.class, () -> {
            vendingMachine.buyProduct("popcorn");
        });
    }


    @Test
    @DisplayName(value = "Test Exception: Not Enough Money")
    public void testBuyPriceInsufficientResourcesException() {
        vendingMachine.addProduct("popcorn",1);

        Assertions.assertThrows(InsufficientResourcesException.class, () -> {
            vendingMachine.buyProduct("popcorn");
        });
    }


    @Test
    @DisplayName(value = "Test Exception: No Product Found")
    public void testBuyNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            vendingMachine.buyProduct("asd");
        });
    }


    @Test
    @DisplayName(value = "Test Exception: No Coin Found")
    public void testInsertCoinNoSuchElementException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            vendingMachine.insertCoin("asd");
        });
    }

}