package ca.mcgill.cs.swdesign.m3;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Objects;

public class CourseSchedule {
    final private Semester aSemester;
    final private DayOfWeek[] aDayOfWeek;
    final private LocalTime aStartTime;
    final private LocalTime aEndTime;

    public CourseSchedule(Semester pSemester, DayOfWeek[] pDayOfWeek, LocalTime pStartTime, LocalTime pEndTime) {
        aSemester = pSemester;
        aDayOfWeek = pDayOfWeek.clone();
        aStartTime = pStartTime;
        aEndTime = pEndTime;
    }

    public CourseSchedule(CourseSchedule pSchedule) {
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
