package ca.mcgill.cs.swdesign.m3;

import java.util.*;

public class Course {
    private final String aID;
    private boolean aIsActive;
    private int aCap;
    private final List<Student> aEnrollment;
    private Optional<CourseSchedule> aSchedule;
    private Comparator<Student> aStudentComparator;

    /**
     * Initialize a course object with the course ID and is cap.
     * @param pID course ID
     * @param pCap the maximum enrollment
     * @pre pID != null && pCap>0
     */
    public Course(String pID, int pCap) {
        assert pID != null && pCap>0;
        aID = pID;
        aCap = pCap;
        aEnrollment = new ArrayList<>();
        aIsActive = false;
        aSchedule = Optional.empty();
        aStudentComparator = new NullComparator();
    }

    /**
     * Set the course schedule
     * @param pSchedule the schedule of the course
     * @pre pSchedule != null
     */
    public void setSchedule(CourseSchedule pSchedule) {
        assert pSchedule != null;
        aSchedule =  Optional.of(new CourseSchedule(pSchedule));
    }

    public Optional<CourseSchedule> getSchedule(){
        return aSchedule;
    }

    public void setActive(boolean pIsActive){
        aIsActive = pIsActive;
    }

    public String getID() {
        return aID;
    }
    public int getCap(){
        return aCap;
    }

    /**
     * Enroll a single student if the course is active and the cap is not reached yet.
     * @param pStudent the student to be enrolled
     * @pre pStudent != null
     * @return  true if the student is added to the course enrollment
     *          false if the student is not added to the course enrollment
     */
    public boolean enroll(Student pStudent) {
        assert pStudent != null;
        if(aIsActive && aEnrollment.size()<aCap && !aEnrollment.contains(pStudent)) {
            aEnrollment.add(pStudent);
            return true;
        }
        return false;
    }

    public void printEnrolledStudent() {
        System.out.println(aID + ": ");
        for(Student s:aEnrollment) {
            System.out.println(s);
        }
    }

    /**
     * Withdraw a student from the course if the student is currently enrolled.
     * If the student is not enrolled, there is no change in the course enrollment.
     * @param pStudent the student to withdraw
     * @pre pStudent != null
     * @return  true if this student is contained in the course
     *          false if the student is not contained in the course
     */
    public boolean withdraw(Student pStudent) {
        assert pStudent != null;
        return aEnrollment.remove(pStudent);
    }

    public Comparator<Student> getStudentComparator() {
        return aStudentComparator;
    }

    public void setStudentComparator(Comparator<Student> aStudentComparator) {
        assert aStudentComparator != null;
        this.aStudentComparator = aStudentComparator;
    }

    public void sortStudent() {
        Collections.sort(aEnrollment, aStudentComparator);
    }

}
