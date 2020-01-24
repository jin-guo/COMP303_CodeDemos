package ca.mcgill.cs.swdesign.m2.demo;

public class Grade {
    private String aCourseID;
    private Student aStudent;
    private double aScore;

    public Grade(Student pStudent, String pCourseID, double pScore) {
        this.aStudent = pStudent;
        this.aCourseID = pCourseID;
        this.aScore = pScore;
    }

    public String getCourseID() {
        return aCourseID;
    }

    public Student getStudent() {
        return aStudent;
    }

    public double getaScore() {
        return aScore;
    }
}
