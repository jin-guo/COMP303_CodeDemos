package ca.mcgill.cs.swdesign.m3;


import ca.mcgill.cs.swdesign.m2.demo.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Course {

    private String aID;
    private boolean aIsActive;
    private int aCap;
    private List<Student> aEnrollment;
    private Optional<CourseSchedule> aSchedule;

    public Course(String pID, int pCap) {
        aID = pID;
        aCap = pCap;
        aEnrollment = new ArrayList<>();
        aIsActive = false;
        aSchedule = Optional.empty();
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


    public boolean enroll(Student pStudent) {
        if(aEnrollment.size()<aCap) {
            aEnrollment.add(pStudent);
            return true;
        }
        return false;
    }

    public boolean enroll(List<Student> pStudents) {
        if(aEnrollment.size() + pStudents.size()<=aCap) {
            aEnrollment.addAll(pStudents);
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

    public boolean withdraw(Student pStudent) {
        return aEnrollment.remove(pStudent);
    }

}
