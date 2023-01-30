package ca.mcgill.cs.swdesign.m3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;

public class CourseSchedule {
    final private Semester aSemester;
    final private DayOfWeek[] aDayOfWeek;
    final private LocalTime aStartTime;
    final private LocalTime aEndTime;

    /**
     * Create a schedule for a course
     * @param pSemester the semester of the course
     * @param pDayOfWeek days of the week of the course
     * @param pStartTime the start time of the course
     * @param pEndTime the end time of the course
     * @pre pSemester!= null && pDayOfWeek!=null && pStartTime!= null && pEndTime!= null
     */
    public CourseSchedule(Semester pSemester, DayOfWeek[] pDayOfWeek, LocalTime pStartTime, LocalTime pEndTime) {
        assert pSemester!= null && pDayOfWeek!=null && pStartTime!= null && pEndTime!= null;
        aSemester = pSemester;
        aDayOfWeek = pDayOfWeek.clone();
        aStartTime = pStartTime;
        aEndTime = pEndTime;
    }

    /**
     * Create a course schedule that is the same with the provided schedule object
     * @param pSchedule the schedule to be copied
     */
    public CourseSchedule(CourseSchedule pSchedule) {
        assert pSchedule!=null;
        aSemester = pSchedule.aSemester;
        aDayOfWeek = pSchedule.aDayOfWeek.clone();
        aStartTime = pSchedule.aStartTime;
        aEndTime = pSchedule.aEndTime;
    }

    public Semester getSemester() {
        return aSemester;
    }

    public DayOfWeek[] getDayOfWeek() {
        return aDayOfWeek.clone();
    }

    public LocalTime getStartTime() {
        return aStartTime;
    }

    public LocalTime getEndTime() {
        return aEndTime;
    }

    @Override
    public String toString() {
        return "Schedule: " + aSemester +
                ", " + Arrays.toString(aDayOfWeek) +
                ", from " + aStartTime +
                " to " + aEndTime;
    }
}
