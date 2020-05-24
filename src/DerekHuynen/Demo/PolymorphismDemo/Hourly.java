package DerekHuynen.Demo.PolymorphismDemo;

public class Hourly extends Employee {

    /** The average number of hours/week that this employee typically works. */
    private int averageHoursPerWeek;
    /** The $ that this employee earns/hour. */
    private float hourlyRate;

    public Hourly (String lName, String fName, String mailAddress, String eMailAddress,
                   int averageHoursPerWeek, float hourlyRate) {
        //Get the first 4 parameters stored using the supertype's constructor.
        //Note that this statement must be the first in this constructor.
        super (lName, fName, mailAddress, eMailAddress);
        //I could have just set these member variables directly, but this makes more
        //sense, particularly if there is any sort of checking on these parameter values.
        this.setAverageHoursPerWeek(averageHoursPerWeek);
        this.setHourlyRate(hourlyRate);
    } // End of the Hourly constructor.

    /**
     * The average weekly rate of an hourly employee is just a guess based on the number of
     * hours that they typically put in during a week and their hourly rate.
     */
    @Override
    public float averageWeeklyRate() {
        return hourlyRate * (float) averageHoursPerWeek;
    }

    /*
     * Build a complete string for the textual description of the Hourly employee by starging with
     * the toString from the supertype and adding some adornments to either end.
     */
    @Override
    public String toString () {
        return "Hourly " + super.toString() + " Average Hours/Week: " + this.getAverageHoursPerWeek() +
                " Hourly Rate: " + this.getHourlyRate();
    }

    //Generated getters and setters
    public int getAverageHoursPerWeek() {
        return averageHoursPerWeek;
    }

    public void setAverageHoursPerWeek(int averageHoursPerWeek) {
        this.averageHoursPerWeek = averageHoursPerWeek;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

}
