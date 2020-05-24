package DerekHuynen.Demo.ReferencesDemo;

import java.util.ArrayList;

public class Student {
    /**
     * The list of student IDs that we've already used so far so that we can
     * be sure that there are no duplicates.
     */
    static ArrayList<Integer> usedIDs = new ArrayList<Integer> ();
    int studentID;
    public int getStudentId () {return studentID;}
    String lName;
    String fName;

    /**
     * Constructor for the Student class.
     * @param ID		The unique ID for this student.  We don't generate it, you have to supply it.
     * @param lName		The last name of the student.
     * @param fName		The first name of the student.
     */
    public Student (int ID, String lName, String fName) {
        if (usedIDs.contains(ID)) {
            throw new IllegalArgumentException("Duplicate ID entered.");
        } else {
            usedIDs.add(ID);					//Remember that we've used this ID now.
            this.studentID = ID;
            this.lName = lName;
            this.fName = fName;
        } //No duplicate key values found.
    } //End of the Student Constructor.

    /**
     * Compare two Students to see whether they equal.
     * @param	other	The other Student to compare to.
     * @return			Flag to show whether they are the same student or not.
     */
    @Override
    public boolean equals (Object other) {
        return (this.getStudentId() == ((Student) other).getStudentId());
    }

    @Override
    public String toString () {
        return "Student- ID: " + this.getStudentId() + " Name: " + this.lName + ", " + this.fName;
    } //End of toString method
} //End of the Student
