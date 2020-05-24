/**
 * payment Method Interface
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
 * Interface for payment Method
 */
public interface paymentMethod {

    public abstract void pay(double x);
    public abstract String getPaymentType();
    public abstract void setPaymentType(paymentMethod method);
    public abstract String getColonyName();
}
