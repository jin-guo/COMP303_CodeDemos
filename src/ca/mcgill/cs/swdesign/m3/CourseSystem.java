package ca.mcgill.cs.swdesign.m3;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.demo.Student;
import ca.mcgill.cs.swdesign.m2.demo.Undergrad;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CourseSystem {
    public static void main(String[] args) {
        Course comp303 = new Course("COMP 303", 200);
        printSchedule(comp303);

        comp303.setSchedule(createSchedule());
        printSchedule(comp303);

    }


    private static CourseSchedule createSchedule() {
        DayOfWeek[] pDayOfWeek = new DayOfWeek[2];
        pDayOfWeek[0] =  DayOfWeek.WEDNESDAY;
        pDayOfWeek[1] =  DayOfWeek.FRIDAY;
        LocalTime startTime = LocalTime.of(14,35,00);
        LocalTime endTime  = LocalTime.of(15,55,00);

        return  new CourseSchedule(new Semester(Semester.Term.Fall, 2020), pDayOfWeek,
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
