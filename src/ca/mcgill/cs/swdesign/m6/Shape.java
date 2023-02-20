package ca.mcgill.cs.swdesign.m6;

public interface Shape extends Cloneable {
    void changeColor(Color pColor);
    Color getColor();
    void move(int x, int y);
    Shape clone();

}
