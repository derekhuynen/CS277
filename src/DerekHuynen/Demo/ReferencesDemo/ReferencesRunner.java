package DerekHuynen.Demo.ReferencesDemo;

/**
 * Demonstration of a many to many between Students and Courses.  This is an over simplification
 * since one student can enroll in the same course more than once as long as it's a different
 * semester/year.  The critical thing to prove is that the two parent "tables" are referenced
 * by the association table's rows.  Those parent "rows" do not get duplicated.
 * @author	David Brown
 * @date	07/24/2019
 */
public class ReferencesRunner {

    public static void main(String[] args) {
        //Create our "table" of students
        Student [] kids = {	new Student (1, "Figgalily", "Phoebe"),
                new	Student (2, "Wierd", "Howe"),
                new Student (3, "Reagan", "Nancy")};
        //Test out the toString method
        for (Student stu: kids) {
            System.out.println (stu);
        }
        System.out.println("Printing the courses");
        //Build some of the courses that I teach.
        Course [] courses = {new Course (new Course.CourseID(Department.CECS, 323), "Database Fundamentals"),
                new Course (new Course.CourseID(Department.CECS, 225), "Hardware Architecture Design"),
                new Course (new Course.CourseID(Department.CECS, 277), "Object Oriented Programming & Design")};
        //Test out the toString method for courses
        for (Course course: courses) {
            System.out.println (course);
        }
        System.out.println("Enrollments");
        //Build some demonstration enrollments where we connect one student to one course.
        Enrollment [] signUps =
                {	new Enrollment (courses[0], kids[0], 2019, Semester.FALL),
                        new Enrollment (courses[0], kids[1], 2018, Semester.SPRING)
                };
        for (Enrollment rolls: signUps) {
            System.out.println (rolls);
        }
        //Change the name of one of the courses that we have an enrollment for, and see
        //if the enrollment reflects that change to the course definition.
        System.out.println("Changing the name of a course");
        courses[0].setName("RDBMS Database Fundamentls");
        System.out.println("Enrollment now: " + signUps[0]);
    }
}