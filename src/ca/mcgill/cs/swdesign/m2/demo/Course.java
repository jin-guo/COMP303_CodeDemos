package ca.mcgill.cs.swdesign.m2.demo;

import java.util.*;

public class Course {

    private String aID;
    private int aCap;
    private List<Student> aEnrollment;

    public Course(String pID, int pCap) {
        this.aID = pID;
        this.aCap = pCap;
        this.aEnrollment = new ArrayList<>();
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
