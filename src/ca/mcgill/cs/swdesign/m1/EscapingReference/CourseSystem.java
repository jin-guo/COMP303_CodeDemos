package ca.mcgill.cs.swdesign.m1.EscapingReference;

import java.util.ArrayList;
import java.util.List;

public class CourseSystem {
    public static void main(String[] args) {
        Undergrad s1 = new Undergrad("00001", "James", "Harris");
        Undergrad s2 = new Undergrad("00002", "Benny", "Will");
        List<Undergrad> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        Course comp302 = new Course("COMP 302", 200);
        Course comp303 = new Course("COMP 303", 200);

        // Students who are enrolled in COMP 302 are enrolled in COMP 303 by default.
        comp302.setEnrollment(students);
        comp303.setEnrollment(students);

        comp302.printEnrolledStudent();
        comp303.printEnrolledStudent();

        // James decides to withdraw comp 302 only.
        comp302.withdraw(s1);

        System.out.println("****After withdraw*****");

        comp302.printEnrolledStudent();
        comp303.printEnrolledStudent();
    }
}
