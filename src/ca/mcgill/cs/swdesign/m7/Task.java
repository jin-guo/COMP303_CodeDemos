package ca.mcgill.cs.swdesign.m7;

public class Task {
    private final String aName;
    private int aLength;

    public Task(String pName) {
        aName = pName;
    }

    public String getName() {
        return  aName;
    }

    public int getLength() {
        return aLength;
    }

    public void setLength(int pLength) {
        aLength = pLength;
    }
}
