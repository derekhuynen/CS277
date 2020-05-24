/**
 * Roach pal
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
 * Pypal email transaction
 */
public class roachPal implements paymentMethod{

    protected String name;
    protected String email;
    protected String paymentType;

    public roachPal(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public String getColonyName() {
        return this.name;
    }

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(paymentMethod method) {
        this.paymentType = "roachPal";
    }

    public void pay(double amount) {
        System.out.printf("Email: %s, Payment: $%.2f completed.",this.email,amount);
    }
}