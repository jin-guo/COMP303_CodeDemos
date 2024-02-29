package ca.mcgill.cs.swdesign.m6;

public class Rectangle implements Shape {
    private int x_center;
    private int y_center;
    private int width;
    private int height;
    private Color currentColor = new Color(0.5f, 0.5f,0.5f);

    public Rectangle(int x_center, int y_center, int width, int height) {
        this.x_center = x_center;
        this.y_center = y_center;
        this.width = width;
        this.height = height;
    }

    public void changeColor(Color pColor) {
        currentColor = pColor;
    }

    public Color getColor() {
        return currentColor;
    }

    @Override
    public void move(int x, int y) {
        x_center = x_center + x;
        y_center = y_center + y;
    }

    @Override
    public Rectangle clone() {
        try {
            Rectangle clone = (Rectangle) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            assert false;
            return null;
        }
    }
}
