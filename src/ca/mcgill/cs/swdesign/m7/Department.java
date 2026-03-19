package ca.mcgill.cs.swdesign.m7;

public class Department {
    private final String aName;
    public Department(String pName) {
        assert pName!=null;
        aName = pName;
    }

    public String getName() {
        return  aName;
    }

}
