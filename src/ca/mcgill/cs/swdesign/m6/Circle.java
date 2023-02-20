package ca.mcgill.cs.swdesign.m6;

public class Circle implements Shape{
    private int x_center;
    private int y_center;
    private int radius;
    private Color currentColor = new Color(0.5f, 0.5f,0.5f);


    public Circle(int x_center, int y_center, int pRadius) {
        assert x_center>0 && y_center>0 && radius>0;
        this.x_center = x_center;
        this.y_center = y_center;
        this.radius = pRadius;
    }

    @Override
    public void changeColor(Color pColor) {
        assert pColor != null;
        currentColor = pColor;
    }

    @Override
    public Color getColor() {
        return currentColor;
    }

    @Override
    public void move(int x, int y) {
        x_center = x_center + x;
        y_center = y_center + y;
    }

    @Override
    public Circle clone() {
        try
        {
            Circle clone = (Circle) super.clone();

            return clone;
        }
        catch (CloneNotSupportedException e)
        {
            assert false;
            return null;
        }
    }

    static Circle newInstance(Shape pShape) {
        Circle c = (Circle) pShape;
        return new Circle(c.x_center, c.y_center, c.radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(10, 10, 2);
        Shape c2 = Circle.newInstance(c1);
        System.out.println(c1 == c2);
    }
}
