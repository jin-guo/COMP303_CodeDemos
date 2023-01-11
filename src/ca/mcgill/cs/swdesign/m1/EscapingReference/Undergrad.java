package ca.mcgill.cs.swdesign.m1.EscapingReference;

public class Undergrad {
    private int year;
    final private String aID;
    private String aFirstName;
    private String aLastName;

    public Undergrad(String pID, String pFirstName, String pLastName) {
        assert pID != null && pFirstName != null && pLastName != null;
        this.aID = pID;
        this.aFirstName = pFirstName;
        this.aLastName = pLastName;
    }

    public Undergrad(Undergrad pUG) {
        assert pUG!=null;
        this.aID = pUG.aID;
        this.aFirstName = pUG.aFirstName;
        this.aLastName = pUG.aLastName;
    }

    public static Undergrad getCopy(Undergrad pUG) {
        assert pUG != null;
        Undergrad copy = new Undergrad(pUG.aID, pUG.aFirstName, pUG.aFirstName);
        return copy;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFirstName() {
        return aFirstName;
    }

    public void setFirstName(String pFirstName) {
        assert pFirstName != null;
        this.aFirstName = pFirstName;
    }

    public String getLastName() {
        return aLastName;
    }

    public void setLastName(String pLastName) {
        assert pLastName != null;
        this.aLastName = pLastName;
    }

    public String getID() {
        return aID;
    }

    public String toString() {
        return aID + ", " + aFirstName + ", " + aLastName;
    }
}
