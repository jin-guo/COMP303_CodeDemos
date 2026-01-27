package ca.mcgill.cs.swdesign.m3;


import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Comparator;


public class CourseSystem {
    public static void main(String[] args) {
        checkSemesterUniqueness();
        optionalSchedule();
        enrollAndRankStudent();
    }


    public static void enrollAndRankStudent() {
        Student s1 = new Undergrad("020","Jason", "Mill");
        Student s2 = new Undergrad("001","Lily", "Joe");
        Student s3 = new Undergrad("003","Zak", "Sullivan");
        Course comp303 = new Course("COMP 303", 200);
        comp303.setActive(true);
        comp303.enroll(s1);
        comp303.enroll(s2);
        comp303.enroll(s3);

        comp303.printEnrolledStudent();

        System.out.println("No sorting yet:");
        comp303.sortStudent(); //using nullcomparator;
        comp303.printEnrolledStudent();

        System.out.println("Sort by first name:");
        comp303.setStudentComparator(new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });//using the comparator by first name using anonymous class;
        comp303.sortStudent();
        comp303.printEnrolledStudent();

        System.out.println("Sort by last name:");
        comp303.setStudentComparator((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));//using the comparator by last name using lambda expression
        comp303.sortStudent();
        comp303.printEnrolledStudent();


    }

    private static void optionalSchedule() {
        Course comp303 = new Course("COMP 303", 200);
        printSchedule(comp303);

        comp303.setSchedule(createSchedule());
        printSchedule(comp303);
    }

    private static void checkSemesterUniqueness() {
        Semester s1 = Semester.getSemester(Semester.Term.Fall, 2021);
        Semester s2 = Semester.getSemester(Semester.Term.Fall, 2021);
        Semester s3 = Semester.getSemester(Semester.Term.Winter, 2100);
        Semester s4 = Semester.getSemester(Semester.Term.Winter, 2100);

        System.out.println(s1 == s2); // Should be true;
        System.out.println(s1 == s3); // Should be false;
        System.out.println(s3 == s4); // Should be false;
        System.out.println(s3.equals(s4)); // Should be true;
    }


    private static CourseSchedule createSchedule() {
        DayOfWeek[] pDayOfWeek = new DayOfWeek[2];
        pDayOfWeek[0] =  DayOfWeek.MONDAY;
        pDayOfWeek[1] =  DayOfWeek.WEDNESDAY;
        LocalTime startTime = LocalTime.of(13, 5, 0);
        LocalTime endTime  = LocalTime.of(14,25, 0);

        return new CourseSchedule(Semester.getSemester(Semester.Term.Winter, 2023), pDayOfWeek,
                startTime, endTime);
    }

    private static void printSchedule(Course pCourse) {
        if(pCourse.getSchedule().isPresent()) {
            CourseSchedule schedule = pCourse.getSchedule().get();
            System.out.println(schedule);
        } else {
            System.out.println("Schedule unavailable.");
        }
    }

}
