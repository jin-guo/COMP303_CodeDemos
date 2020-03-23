package ca.mcgill.cs.swdesign.m6;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Shape {
    List<Shape> aElements = new ArrayList<>();

    @Override
    public void changeColor(Color pColor) {
        for(Shape element: aElements) {
            element.changeColor(pColor);
        }
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void move(int pX, int pY) {
        for(Shape element: aElements) {
            element.move(pX, pY);
        }
    }

    @Override
    public CompositeShape clone() {
        try
        {
            CompositeShape clone = (CompositeShape) super.clone();
            clone.aElements = new ArrayList<>();
            for(Shape element : aElements )
            {
                clone.aElements.add(element.clone());
            }
            return clone;
        }
        catch (CloneNotSupportedException e)
        {
            assert false;
            return null;
        }
    }
}
