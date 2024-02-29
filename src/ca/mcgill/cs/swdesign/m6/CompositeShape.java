package ca.mcgill.cs.swdesign.m6;

import java.util.ArrayList;
import java.util.List;

public class CompositeShape implements Shape {
    List<Shape> aElements = new ArrayList<>();

    public void addShape(Shape pShape) {
        assert pShape != null;
        aElements.add(pShape);
    }

    @Override
    public void move(int pX, int pY) {
        for(Shape element: aElements) {
            element.move(pX, pY);
        }
    }

    @Override
    public CompositeShape clone() {
        try {
            CompositeShape clone = (CompositeShape) super.clone();
            clone.aElements = new ArrayList<>();
            for (Shape sp:aElements) {
                clone.aElements.add(sp.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            assert false;
            return null;
        }
    }
}
