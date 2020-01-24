package ca.mcgill.cs.swdesign.m2.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseSystem {
    public static void main(String[] args) {
        Undergrad s1 = new Undergrad("00009", "James", "Harris");
        Undergrad s2 = new Undergrad("00002", "Benny", "Will");
        Undergrad s3 = new Undergrad("00007", "Caden", "Chalse");
        Undergrad s4 = new Undergrad("00004", "Travis", "Harper");
        Undergrad s5 = new Undergrad("00015", "Abby", "Fitzgerald");
        Undergrad s6 = new Undergrad("00006", "Niba", "Davis");



        Course comp303 = new Course("COMP 303", 200);

        // Students who are enrolled in COMP 302 are enrolled in COMP 303 by default.
        comp303.enroll(s1);
        comp303.enroll(s2);
        comp303.enroll(s3);
        comp303.enroll(s4);
        comp303.enroll(s5);
        comp303.enroll(s6);

        comp303.printEnrolledStudent();






    }

}
