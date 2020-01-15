package ca.mcgill.cs.swdesign.m1.EscapingReference;

public class Undergrad implements Student {
    private String aID;
    private String aFirstName;
    private String aLastName;

    public Undergrad(String pID, String pFirstName, String pLastName) {
        this.aID = pID;
        this.aFirstName = pFirstName;
        this.aLastName = pLastName;
    }

    @Override
    public String getFirstName() {
        return aFirstName;
    }

    @Override
    public void setFirstName(String pFirstName) {
        this.aFirstName = pFirstName;
    }

    @Override
    public String getLastName() {
        return aLastName;
    }

    @Override
    public void setLastName(String pLastName) {
        this.aLastName = pLastName;
    }

    @Override
    public String getID() {
        return aID;
    }

    @Override
    public void setID(String pID) {
        this.aID = pID;
    }

    @Override
    public String toString() {
        return aID + ", " + aFirstName + ", " + aLastName;
    }
}
