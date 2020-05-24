package DerekHuynen.Demo.PolymorphismDemo;

public class Salaried extends Employee {

    /** The compensation this employee earns in a year. */
    private float annualSalary;

    public Salaried (String lName, String fName, String mailAddress, String eMailAddress,
                     float annualSalary) {
        //Get the first 4 parameters stored using the supertype's constructor.
        //Note that this statement must be the first in this constructor.
        super (lName, fName, mailAddress, eMailAddress);
        //Set the quantities that are unique to Salaried Employees.
        this.setAnnualSalary(annualSalary);
    }

    public float getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(float annualSalary) {
        this.annualSalary = annualSalary;
    }

    /**
     * If every year has WEEKS_PER_YEAR weeks in it, so we can calculate the average
     * weekly rate of a salaried person.  Of course, this doesn't take into account
     * the amount of uncompensated overtime that they work.  It never does.
     */
    @Override
    public float averageWeeklyRate() {
        return annualSalary/WEEKS_PER_YEAR;
    }

    @Override
    public String toString () {
        return "Salaried " + super.toString() + " Annual Salary: " + this.getAnnualSalary();
    }

}