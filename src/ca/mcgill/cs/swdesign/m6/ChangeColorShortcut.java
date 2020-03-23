package ca.mcgill.cs.swdesign.m6;

public class ChangeColorShortcut  implements KeyboardShortcut {
    private Shape aShape;
    private Color aColor;
    private Color previousColor;

    ChangeColorShortcut(Shape pShape, Color pColor) {
        aShape = pShape;
        aColor = pColor;

    }

    @Override
    public void clicked() {
        previousColor = aShape.getColor();
        aShape.changeColor(aColor);
    }

    @Override
    public void undo() {
        aShape.changeColor(previousColor);
    }

}