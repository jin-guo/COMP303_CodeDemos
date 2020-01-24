package ca.mcgill.cs.swdesign.m2.demo;

import java.util.List;

public class Undergrad implements Student {
    private String aID;
    private String aFirstName;
    private String aLastName;
    private List<Grade> aGrades;

    public Undergrad(String pID, String pFirstName, String pLastName) {
        this.aID = pID;
        this.aFirstName = pFirstName;
        this.aLastName = pLastName;
    }

    @Override
    public String getFirstName() {
        return aFirstName;
    }

    public void setFirstName(String pFirstName) {
        this.aFirstName = pFirstName;
    }

    @Override
    public String getLastName() {
        return aLastName;
    }

    public void setLastName(String pLastName) {
        this.aLastName = pLastName;
    }

    @Override
    public String getID() {
        return aID;
    }

    public void setID(String pID) {
        this.aID = pID;
    }

    @Override
    public String toString() {
        return aID + ", " + aFirstName + ", " + aLastName;
    }

}
