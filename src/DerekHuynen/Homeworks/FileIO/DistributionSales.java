/**
 * DistributionSales
 * Homework Assignment: File I/O
 *
 * @author Derek Huynen
 * @date 3/12/2020
 * @version 1.00
 */

package DerekHuynen.Homeworks.FileIO;


import java.io.*;
import java.util.Scanner;

public  class DistributionSales {


    /**
     * Default Constructor
     *
     * Not Sure if I really need this
     */
    public DistributionSales(){
        //Empty
    }

    /**
     * Read the Input Service FIle Line by Line and Create Service Objects
     *
     */
    public static void readFile(File saleFile) {

        try {
            Scanner scanner = new Scanner(saleFile);
            while (scanner.hasNextLine()) {

                try{
                    String[] entries = scanner.nextLine().split(";");
                    String name = entries[0];
                    String service = entries[1];
                    String amount = entries[2];
                    String date = entries[3];

                    if(!(name.length() > 0) || !Service.checkService(service) ||  !Service.checkAmount(amount) || !Service.checkDate(date)){
                        throw new UnknownTransactionException();
                    }



                    String baseUrl = saleFile.getAbsolutePath().replace(saleFile.getName(),"");
                    outputFile(new Service(name, service, Double.parseDouble(amount), date),baseUrl);

                }catch (UnknownTransactionException e){
                    System.out.println("The Service Entry is not in a Valid Format. Skipping This Entry.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Trouble Reading Input File.");
        }
    }

    /**
     * Check to see If Service FIle already Exists,
     * Then either create a new Service File to write entry to
     * Or append to existing file
     *
     * @param service entry that is being added to Output File
     */
    public static void outputFile(Service service,String path){

        File file = new File(path + service.getService() + ".txt");

        if(!file.exists()) {
            try{
                PrintWriter pw = new PrintWriter(file);
                pw.println(service.toString());
                pw.close();

            } catch (FileNotFoundException e) {
                System.out.printf("Trouble Creating New File for service %s",service.getService());
            }

        }else {
            try {
                FileWriter fileAppend = new FileWriter(service.getService() + ".txt", true);
                PrintWriter pw = new PrintWriter(fileAppend);
                pw.println(service.toString());
                pw.close();
            } catch (IOException e) {
                System.out.printf("Trouble Appending to existing file for service %s", service.getService());
            }
        }
    }
}