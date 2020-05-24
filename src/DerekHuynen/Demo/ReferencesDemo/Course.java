package DerekHuynen.Demo.ReferencesDemo;


import java.util.ArrayList;

/**
 * The course catalog.
 * @author	David Brown
 * @date	07/24/2019
 */
public class Course {
    /**
     * A composite key for the Course class composed of the Department name and the Course
     * number. I built this to encapsulate the primary key just a bit.
     * @author	David Brown
     */
    //Make this a static class so that I don't have to have an enclosing instance to create an instance
    //of CourseID.  I need to make this less visible to the outside world.  Perhaps make a factory for these
    //as a method for Course.
    public static class CourseID {
        /** The name of the department as an enumeration. */
        private Department department;
        public Department getDepartment () { return this.department; }
        //This is just part of the course PK since more than department can offer their own
        //course with a given course number.  For instance, just about everyone has a 100 level course.
        private int number;
        public int getNumber () { return this.number; }
        /**
         * CourseID constructor.
         * @param department	The identifier of the department offering the course.
         * @param number		The number of the course.
         */
        public CourseID (Department department, int number) {
            this.department = department;
            this.number = number;
        } //End of the CourseID constructor

        /**
         * Compare two instances of CourseID for equality.  Need that for the
         * ArrayList contains method.
         * @param	other	The other CourseID to compare to.
         * @return			Flag to tell whether they equal or not.
         */
        public boolean equals (Object other) {
            return (this.getDepartment() == ((CourseID) other).getDepartment() &&
                    this.getNumber() == ((CourseID) other).getNumber());
        } //End of the equals function for CourseID

        @Override
        public String toString () {
            return "CourseID - Department: " + this.department + " Course Number: " + this.number;
        } //End of CourseID toString.
    } //End of the CourseID class

    CourseID id;								//The primary key of the course rolled into one object.
    String name;								//The textual name of the course.

    /*
     * Changes the name of the course.
     * @param	newName		The new name for the course.
     */
    public void setName (String newName) {this.name = newName; }

    /**
     * The list of Course PKs that we have built so far. I used an ArrayList because
     * all that I have to implement in CourseID is the equals method.  A TreeMap Set
     * would have worked nicely, but I would have had to implement the Comparable
     * interface, which would have been more work.
     */
    static ArrayList <CourseID > courses = new ArrayList <CourseID> ();
    /**
     * Constructor for the course itself.
     * @param id		The PK for the course.
     * @param name		The textual name of the course.  We should treat this as a
     * 					candidate key, but I'll leave that as an exercise for the
     * 					student.
     */
    public Course (CourseID id, String name) {
        //Check for duplicate values of the Dept/Course ID combo.
        if (courses.contains(id)) {
            throw new IllegalArgumentException ("Duplicate course ID entered.");
        } else {
            courses.add(id);				//log this ID as used.
            this.id = id;
            this.name = name;
        } //We do not have duplicate Courses
    } //End of the Course constructor.

    @Override
    public String toString () {
        //Use the toString for the Course PK in the Course toString.
        return "Course - " + this.id + " name: " + this.name;
    } //End of the Course toString method
} //End of the Course Class
