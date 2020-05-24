/**
 * EnterSales
 * Homework Assignment: File I/O
 *
 * @author Derek Huynen
 * @date 3/12/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.FileIO;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Main Runner and get User Input for Sales
 */
public class EnterSales {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        JFileChooser chooser = new JFileChooser();

        boolean done = false;
        PrintWriter pw = null;

        chooser.setDialogTitle("Select File to Record Sales");
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);


        while(! done){
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                try{

                    if(!getFileExtension(chooser.getSelectedFile()))
                        throw new FileNotFoundException("Not a txt File");

                    pw = new PrintWriter (chooser.getSelectedFile());
                    done = true;

                } catch ( FileNotFoundException e){
                    System.out.printf("Error with %s. Try Creating Another File with \".txt\" Extension\n",chooser.getSelectedFile());
                }
            }
        }


        //A Menu to Run as Long as User wants to keep entering New Services
        boolean run = false;
        do {

            System.out.println("\nWould you like to Insert a Service.");
            System.out.print("Press \"Enter\" to continue. Type \"exit\" to Exit:");

            //Exit Menu if user types exit
            if (userInput.nextLine().equalsIgnoreCase("exit")) {
                run = true;
                userInput.close();
            }
            else
                //Get User Input and Write to File
                pw.println(getInput().toString());

        } while (!run);
        pw.close();


        DistributionSales.readFile(chooser.getSelectedFile());
    }


    public static Service getInput() {

        Scanner userInput = new Scanner(System.in);
        String name, service, amount, date;


        //Keep asking User for Valid Name
        do {
            System.out.print("\nEnter Customer Name: ");
            name = userInput.nextLine().trim();

        } while (name.isEmpty());


        //Keep asking User for Valid Service
        do {
            System.out.print("Enter Service: ");
            service = userInput.nextLine().trim();

        } while (!Service.checkService(service));



        //Keep asking User for Valid Amount
        do {
            System.out.print("Enter amount: $");
            amount = userInput.nextLine().trim();

        } while (!Service.checkAmount(amount));


        //Keep asking User for Valid Date
        do {
            System.out.print("Enter Date: ");
            date = userInput.nextLine().trim();

        } while (!Service.checkDate(date));


        //All inputs should be Valid
        return new Service(name, service, Double.parseDouble(amount), date);

    }


    private static boolean getFileExtension(File file) {
        String fileName = file.getName();
        return fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0;
    }

}



