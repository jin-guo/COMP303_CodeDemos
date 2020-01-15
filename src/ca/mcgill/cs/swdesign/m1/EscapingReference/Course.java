package ca.mcgill.cs.swdesign.m1.EscapingReference;

import java.util.ArrayList;
import java.util.List;

public class Course {

    private String aID;
    private int aCap;
    private List<Undergrad> enrollment;

    public Course(String pID, int pCap) {
        this.aID = pID;
        this.aCap = pCap;
        this.enrollment = new ArrayList<>();
    }

    public int getCap(){
        return aCap;
    }

    public boolean setEnrollment(List<Undergrad> pEnrollment) {
        if(pEnrollment.size()<=aCap) {
            enrollment = pEnrollment;
            return true;
        }
        return false;
    }

    public List<Undergrad> getEnrolledStudent() {
        return enrollment;
    }

    public boolean enroll(Undergrad pStudent) {
        if(enrollment.size()<aCap) {
            enrollment.add(pStudent);
            return true;
        }
        return false;
    }

    public boolean enroll(List<Undergrad> pStudents) {
        if(enrollment.size() + pStudents.size()<=aCap) {
            enrollment.addAll(pStudents);
            return true;
        }
        return false;
    }

    public void printEnrolledStudent() {
        System.out.println(aID + ": ");
        for(Undergrad s: enrollment) {
            System.out.println(s);
        }
    }

    public boolean withdraw(Undergrad pStudent) {
        return enrollment.remove(pStudent);
    }

}
