package ca.mcgill.cs.swdesign.m4;

import ca.mcgill.cs.swdesign.m2.demo.Student;
import ca.mcgill.cs.swdesign.m3.CourseSchedule;
import ca.mcgill.cs.swdesign.m3.NullComparator;

import java.util.*;

public class Course implements Iterable<Student> {
    private String aID;
    private int aCap;
    private List<Student> aEnrollment;
    private Optional<CourseSchedule> aSchedule;
    private Comparator<Student> aStudentComparator;

    public Course(String pID, int pCap) {
        aID = pID;
        aCap = pCap;
        aEnrollment = new ArrayList<>();
        aSchedule = Optional.empty();
        aStudentComparator = new NullComparator();
    }

    public void setSchedule(CourseSchedule pSchedule) {
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
     * @throws IllegalArgumentException if pStudent == null
     *         CourseFullException if isFull()
     */

    public void enroll(Student pStudent) throws CourseFullException {
        if (pStudent == null)
            throw new IllegalArgumentException();
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

    public boolean withdraw(Student pStudent) {
        return aEnrollment.remove(pStudent);
    }

    public Comparator<Student> getStudentComparator() {
        return aStudentComparator;
    }

    public void setStudentComparator(Comparator<Student> aStudentComparator) {
        this.aStudentComparator = aStudentComparator;
    }

    public void sortStudent() {
        Collections.sort(aEnrollment, aStudentComparator);
    }

    @Override
    public Iterator<Student> iterator() {
        return aEnrollment.iterator();
    }
}
