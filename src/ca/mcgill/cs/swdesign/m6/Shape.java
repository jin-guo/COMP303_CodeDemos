package ca.mcgill.cs.swdesign.m6;

public interface Shape extends Cloneable {
    void move(int x, int y);
    Shape clone();

}
