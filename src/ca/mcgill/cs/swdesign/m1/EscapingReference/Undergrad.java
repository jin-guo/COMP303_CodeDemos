package ca.mcgill.cs.swdesign.m1.EscapingReference;

public class Undergrad {
    private String aID;
    private String aFirstName;
    private String aLastName;

    public Undergrad(String pID, String pFirstName, String pLastName) {
        this.aID = pID;
        this.aFirstName = pFirstName;
        this.aLastName = pLastName;
    }

    public String getFirstName() {
        return aFirstName;
    }

    public void setFirstName(String pFirstName) {
        this.aFirstName = pFirstName;
    }

    public String getLastName() {
        return aLastName;
    }

    public void setLastName(String pLastName) {
        this.aLastName = pLastName;
    }

    public String getID() {
        return aID;
    }

    public void setID(String pID) {
        this.aID = pID;
    }

    public String toString() {
        return aID + ", " + aFirstName + ", " + aLastName;
    }
}
