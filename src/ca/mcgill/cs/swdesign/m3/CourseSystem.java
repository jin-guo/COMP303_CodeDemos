package ca.mcgill.cs.swdesign.m3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Comparator;

public class CourseSystem {
    public static void main(String[] args) {
        optionalSchedule();
        checkSemesterUniqueness();


    }

    private static void optionalSchedule() {
        Course comp303 = new Course("COMP 303", 200);
        printSchedule(comp303);

        comp303.setSchedule(createSchedule());
        printSchedule(comp303);
    }

    private static void checkSemesterUniqueness() {
        Semester s1 = Semester.getSemester(Semester.Term.Fall, 2020);
        Semester s2 = Semester.getSemester(Semester.Term.Fall, 2020);
        Semester s3 = Semester.getSemester(Semester.Term.Winter, 2100);
        Semester s4 = Semester.getSemester(Semester.Term.Winter, 2100);


        System.out.println(s1 == s2); // Should be true;
        System.out.println(s1 == s3); // Should be false;
        System.out.println(s3 == s4); // Should be false;
    }


    private static CourseSchedule createSchedule() {
        DayOfWeek[] pDayOfWeek = new DayOfWeek[2];
        pDayOfWeek[0] =  DayOfWeek.WEDNESDAY;
        pDayOfWeek[1] =  DayOfWeek.FRIDAY;
        LocalTime startTime = LocalTime.of(14,35,00);
        LocalTime endTime  = LocalTime.of(15,55,00);

        return  new CourseSchedule(Semester.getSemester(Semester.Term.Fall, 2020), pDayOfWeek,
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
