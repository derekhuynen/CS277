package DerekHuynen.Demo.PolymorphismDemo;


public class EmployeeRunner {

    public static void main(String[] args) {
        // All of the elements in this array are the same variable type: Employee.  But
        // some belong to the Salaried category, and others belong to the Hourly category.
        // Each has a different override for the toString method, and each has a different
        // override for the averageWeeklyRate method.  But because those methods are
        // declared at the Employee class, I can reference them.
        Employee [] emps = {
                new Salaried ("Gates", "William", "123 Mockingbird Lane\nSan Francisco", "bill.gates@yahoo.com", (float) 250346.56),
                new Hourly ("Smith", "Kyle", "4000 Tile Rd.\nMayberry", "kylesm@gmail.com", 23, (float)15.0),
                new Salaried ("Burkhard", "Nick", "1000 Cherrywood\nPortland", "NickAtNight@verizon.net", (float) 123010)};
        //Take advantage of the fact that all of our emps instances belong to the same generic type.
        Employee previous = null;						//Pointer to the previous employee
        for (Employee next: emps) {						//Cycle through the array of Employees.
            System.out.println (next);
            System.out.println ("Average earnings/week: " + next.averageWeeklyRate());
            if (previous != null) {						//This is not the first one in the array
                System.out.println ("Comparing this one to the previous one, we get: " +
                        next.compareTo(previous));		//Show the output from our compareTo method
            } else {									//Just to demonstrate the == comparison
                System.out.println ("Comparing this one to itself: " + next.compareTo(next));
            }
            previous = next;							//Save the pointer to the next previous name in the array
        }
        //Test the check for invalid e-mail address
        try {
            Employee crash = new Salaried ("Vanderbuilt", "Peter", "111 Skid Row", "garbage", (float) 12500.56);
        } catch (IllegalArgumentException IAE) {
            System.out.println ("Error from attempted Salaried creation: " + IAE.getMessage());
        }
        System.out.println("Completed satisfactorily.");
    }

}
