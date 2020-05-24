package DerekHuynen.Demo.PolymorphismDemo;

public abstract class Employee implements Comparable <Employee> {

    //Sure, 52 weeks in a year is not going to change soon, but just using the magic number 52
    //in calculations later will be confusing.  This way, the variable name tells my readers
    //what 52 signifies.
    static final int WEEKS_PER_YEAR = 52;
    //Same argument for the number of hours in a week.  Although we could put more hours in a
    //week to get over the slump in productivity we're facing.
    static final int HOURS_PER_WEEK = 40;

    public Employee(String lName, String fName, String mailAddress, String eMailAddress) {
        this.setlName(lName);
        this.setfName(fName);
        this.setMailAddress(mailAddress);
        this.seteMailAddress(eMailAddress);
    }

    /**
     * Last name (surname) of the employee
     */
    private String lName;

    /**
     * First name (given) of the employee
     */
    private String fName;

    /**
     * Snail mail address, with embedded \n s to make it print pretty
     */
    private String mailAddress;

    /**
     * E-mail address
     */
    private String eMailAddress;

    /**
     * Calculate the average weekly pay rate of an employee.
     *
     * @return Average rate in dollars and cents.
     */
    public abstract float averageWeeklyRate();

    //Generated getters and setters
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String geteMailAddress() {
        return eMailAddress;
    }

    public void seteMailAddress(String eMailAddress) {
        if (eMailAddress.endsWith("com") || eMailAddress.endsWith("net")) {
            this.eMailAddress = eMailAddress;
        } else {
            throw new IllegalArgumentException("E-mail address does not end with .com or .net");
        }
    }

    /**
     * Compare two employees for sorting purposes.  The left employee is this employee,
     * the right hand one in the comparison is the passed in Employee.  I'm making
     * this final so that I can make sure that the subtypes don't change the algorithm.
     *
     * @param other The other Employee Instance.
     * @return An integer < 1 if this < other, 0 if they = and > 1 if this > other
     * The comparison goes by last name, then if that is =, then first name.
     */
    @Override
    public final int compareTo(Employee other) {
        //Check the two last names first.
        int result = this.getlName().compareToIgnoreCase(other.getlName());
        if (result == 0) {                    // Last names match, check the first names.
            result = this.getfName().compareToIgnoreCase(other.getfName());
        } // If the last names are =
        return result;
    } // End of compareTo override

    @Override
    public String toString() {
        return "Employee: " + this.getlName() + ", " + this.getfName() + " E-mail: " + this.geteMailAddress();
    }
}