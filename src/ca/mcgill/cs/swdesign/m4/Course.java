package ca.mcgill.cs.swdesign.m4;

import ca.mcgill.cs.swdesign.m3.Student;
import ca.mcgill.cs.swdesign.m3.CourseSchedule;
import ca.mcgill.cs.swdesign.m3.NullComparator;

import java.util.*;

public class Course implements Iterable<Student> {
    private String aID;
    private int aCap;
    private List<Student> aEnrollment;
    private Optional<CourseSchedule> aSchedule;
    private Comparator<Student> aStudentComparator;

    /**
     * Initialize a course object with the course ID and is cap. The cap should be above zero.
     * @param pID course ID
     * @param pCap the maximum enrollment
     * @pre pID != null && pCap>0
     */
    public Course(String pID, int pCap) {
        if (pID == null)
            throw new NullPointerException();
        if (pCap<=0)
            throw new IllegalArgumentException();
        aID = pID;
        aCap = pCap;
        aEnrollment = new ArrayList<>();
        aSchedule = Optional.empty();
        aStudentComparator = new NullComparator();
    }

    /**
     * Set the course schedule
     * @param pSchedule the schedule of the course
     * @pre pSchedule != null
     */
    public void setSchedule(CourseSchedule pSchedule) {
        if (pSchedule == null)
            throw new NullPointerException();
        aSchedule =  Optional.of(new CourseSchedule(pSchedule));
    }

    public Optional<CourseSchedule> getSchedule(){
        return aSchedule;
    }

    public String getID() {
        return aID;
    }
    public int getCap(){
        return aCap;
    }

    /**
     * Enroll the student to the course if the course currently is not full
     * @param pStudent to be enrolled to the Course
     * @pre pStudent!=null && !isFull()
     * @throws  CourseFullException if isFull()
     */

    public void enroll(Student pStudent){
        if (pStudent == null)
            throw new NullPointerException();
        if (isFull())
            throw new CourseFullException("Current capacity reached: " + aCap);
        aEnrollment.add(pStudent);
    }

    public boolean isFull() {
        return aEnrollment.size() == aCap;
    }

    public void printEnrolledStudent() {
        System.out.println(aEnrollment.size() + " students enrolled: ");
        System.out.println(aID + ": ");
        for(Student s:aEnrollment) {
            System.out.println(s);
        }
    }


    @Override
    public Iterator<Student> iterator() {
        return aEnrollment.iterator();
    }
}
