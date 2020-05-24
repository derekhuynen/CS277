package DerekHuynen.Demo.ReferencesDemo;

import java.util.ArrayList;

public class Enrollment {
    public static class EnrollmentID{
        private Course		course;
        public Course getCourse () {return this.course; }
        private	int			studentID;
        public int getStudentID () {return this.studentID; }

        public EnrollmentID (Course course, int studentID) {
            this.course = course;
            this.studentID = studentID;
        }

        @Override
        public boolean equals (Object other) {
            return (this.course.equals(((EnrollmentID)other).getCourse()) &&
                    this.getStudentID() == ((EnrollmentID) other).getStudentID());
        }
    }

    private Course		course;
    private	Student		student;
    private	int			year;
    private Semester	semester;

    //This is the list of the key values for this association class if you want to think
    //of it that way.  I used an ArrayList because the contains method just needs for the
    //EnrollmentID class to override the equals method.  Had I used a HashSet Set, I would
    //have had to override equals and hash.  Had I used a TreeSet Set, I would have had
    //to implement the Comparable interface.  This is the easiest approach for a small
    //load of enrollments, and proves the point, without getting too complex.
    private static ArrayList <EnrollmentID> ids = new ArrayList <EnrollmentID>();

    @Override
    public boolean equals (Object other) {
        return (this.course == ((Enrollment) other).course &&
                this.student == ((Enrollment) other).student);
    }

    public Enrollment (Course course, Student student, int year, Semester semester) {
        EnrollmentID newEnrollmentID = new EnrollmentID (course, student.getStudentId());
        if (ids.contains(newEnrollmentID)) {
            throw new IllegalArgumentException ("This student already in the course!");
        } else {
            ids.add(newEnrollmentID);
            this.course = course;
            this.semester = semester;
            this.year = year;
        }
    }

    public String toString () {
        return "Enrollment - " + this.course + " year: " + this.year + " semester: " + this.semester.name();
    }
}
