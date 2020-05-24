package DerekHuynen.Homeworks.VendingMachine;

import javax.naming.InsufficientResourcesException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

    /**
     * Runs the Menu for the Instance of the Vending Machine
     * @param vendingMachine That needs a Menu
     */
    public static void menu(VendingMachine vendingMachine){
        Container container;
        String userInput;
        int userInputInt;
        boolean run = true;

        do {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\nS)how Products I)nsert Coins B)uy A)dd Product R)emove Coins Q)uit");
            try {
                switch (scanner.nextLine().toLowerCase()) {

                    case "show":
                    case "s":
                        System.out.println(vendingMachine.displayProducts());
                        break;

                    case "insert":
                    case "i":
                        System.out.println(vendingMachine.displayTill());
                        System.out.print("Insert Coin Enter Coin Name: ");
                        container = vendingMachine.insertCoin(scanner.nextLine());
                        System.out.printf("\nYou added a %s, Total: $%.2f.\n", container.getItem(), container.getTotal());
                        break;

                    case "buy":
                    case "b":
                        System.out.println(vendingMachine.displayProducts());
                        System.out.print("Buy Product Enter Product Name: ");
                        container = vendingMachine.buyProduct(scanner.nextLine());
                        System.out.printf("\nYou bought, Product: %s, %d left.\n", container.getItem(), (int)container.getTotal());
                        break;

                    case "add":
                    case "a":
                        System.out.println(vendingMachine.displayProducts());
                        System.out.print("Add Product Enter Product Name: ");
                        userInput = scanner.nextLine();

                        System.out.printf("How many %ss are you adding? --> ", userInput);
                        try {
                            userInputInt = scanner.nextInt();
                            container = vendingMachine.addProduct(userInput, userInputInt);
                            System.out.printf("\nYou added %d %s. Total Amount is Now %d.\n", (int) container.getTotal(), container.getItem(), userInputInt);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Quantity Not an Integer. Try Again with an Integer.");
                        }
                        break;

                    case "remove":
                    case "r":
                        System.out.println(vendingMachine.displayProfit());
                        System.out.print("Remove Coin Enter Coin Name: ");
                        container = vendingMachine.removeCoin(scanner.nextLine());
                        System.out.printf("\nYou Removed %d %s, Total: $%.2f\n",(int) (container.getTotal()/container.getItem().getValue()), container.getItem(), container.getTotal());
                        break;

                    case "quit":
                    case "q":
                        System.out.println("\n\nQuit. Please Come Back Again Soon!\n\n");
                        run = false; //quit program
                        break;

                    default:
                        System.out.println("Please Enter a valid Command.");
                }
            } catch (InsufficientResourcesException | NoSuchElementException | CloneNotSupportedException e) {
                System.out.println(e.getMessage());
            }
        } while(run);
    }
}
