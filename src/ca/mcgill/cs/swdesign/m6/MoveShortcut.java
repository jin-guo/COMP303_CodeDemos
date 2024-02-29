package ca.mcgill.cs.swdesign.m6;

public class MoveShortcut implements KeyboardShortcut {
    private Shape aShape;
    private int x;
    private int y;

    MoveShortcut(Shape pShape, int x, int y) {
        this.aShape = pShape;
        this.x = x;
        this.y = y;

    }
    @Override
    public void clicked() {
        aShape.move(x, y);
    }

    @Override
    public void undo() {
        aShape.move(-x, -y);
    }
}
