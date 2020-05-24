/**
 * masterRoach
 * Homework Assignment: Term Project
 *
 * @author Derek Huynen
 * @author David Chan
 * @author Serenity Brown
 * @author Justin Girgis
 *
 * @date 5/7/2020
 * @version 1.00
 */
package DerekHuynen.Homeworks.RoachMotel;

/**
 * Class for credit card payments
 */
public class masterRoach implements paymentMethod {

    protected String name;
    protected String cardNumber;
    protected String cvv;
    protected String dateOfExpir;
    protected String paymentType;

    /**
     * Default Constructor
     */
    public masterRoach(){
        //Empty
    }
    /**
     * Constructor with params
     * @param name of Card
     * @param cardNumber Number of the card
     * @param cvv on the Card
     * @param dateOfExpir on the Card
     */
    public masterRoach(String name, String cardNumber, String cvv, String dateOfExpir) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpir = dateOfExpir;
    }

    /**
     * Getter for the name on the Card
     * @return name on the Card
     */
    public String getColonyName() {
        return this.name;
    }

    /**
     * Getter for the Payment Type
     * @return the type of payment
     */
    public String getPaymentType() {
        return this.paymentType;
    }

    /**
     * Setter for Payment Type
     * @param method of payment
     */
    public void setPaymentType(paymentMethod method) {
        this.paymentType = "masterRoach";
    }

    /**
     * The method that does that actual payment.
     * @param amount being paid as a double
     */
    public void pay(double amount) {
        System.out.printf("%s paid: $%.2f with a credit/debit card.\n",this.name,amount);
    }
}
