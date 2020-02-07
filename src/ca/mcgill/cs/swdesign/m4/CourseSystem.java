package ca.mcgill.cs.swdesign.m4;

import ca.mcgill.cs.swdesign.m2.demo.Undergrad;

public class CourseSystem {

    public static void main(String[] args) {
        Course comp303 = new Course("COMP 303", 1);
        Undergrad s1 = new Undergrad("00009", "James", "Harris");
        Undergrad s2 = new Undergrad("00002", "Benny", "Will");
        try {
            comp303.enroll(s1);
            comp303.enroll(s2);
            System.out.println("Done with enrolling students.");
        } catch (CourseFullException e){
            e.printStackTrace();
        }
        comp303.printEnrolledStudent();

        CoursePrinter printer = new CoursePrinter();
        printer.writeToFile1(comp303,"testCourseEnrollment.txt");
    }
}
