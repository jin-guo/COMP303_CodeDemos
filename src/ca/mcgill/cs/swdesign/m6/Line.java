package ca.mcgill.cs.swdesign.m6;


public class Line implements Shape {
    private int x_start;
    private int y_start;
    private int x_end;
    private int y_end;
    private Color currentColor = new Color(0.5f, 0.5f,0.5f);

    public Line(int x_start, int y_start, int x_end, int y_end) {
        this.x_start = x_start;
        this.y_start = y_start;
        this.x_end = x_end;
        this.y_end = y_end;
    }

    public  Line(Line pLine) {
        this.x_start = pLine.x_start;
        this.y_start = pLine.y_start;
        this.x_end = pLine.x_end;
        this.y_end = pLine.y_end;
        this.currentColor = pLine.currentColor;
    }

    @Override
    public void changeColor(Color pColor) {
        currentColor = pColor;
    }

    @Override
    public Color getColor() {
        return currentColor;
    }

    @Override
    public void move(int x, int y) {
        x_start = x_start + x;
        y_start = y_start + y;
        x_end = x_end + x;
        y_end = y_end + y;
    }

    @Override
    public Line clone() {
        try
        {
            Line clone = (Line) super.clone();

            return clone;
        }
        catch (CloneNotSupportedException e)
        {
            assert false;
            return null;
        }
    }

    /**
     * Create and return an command object that implements the KeyboardShortcut interface.
     * The command object is able to access the fields of the Line object to perform the undo.
     * @param x move x pixel to the right.
     * @param y move y pixel down.
     */
    public KeyboardShortcut getMoveShortcut(int x, int y) {
        return new KeyboardShortcut() {
            private int pre_x_start;
            private int pre_y_start;
            private int pre_x_end;
            private int pre_y_end;

            @Override
            public void clicked() {
                pre_x_start = x_start;
                pre_y_start = y_start;
                pre_x_end = x_end;
                pre_y_end = y_end;
                move(x, y);
            }
            @Override
            public void undo() {
                x_start = pre_x_start;
                y_start = pre_y_start;
                x_end = pre_x_end;
                y_end = pre_y_end;
            }
        };
    }

    @Override
    public String toString() {
        return "Line{" +
                "x_start=" + x_start +
                ", y_start=" + y_start +
                ", x_end=" + x_end +
                ", y_end=" + y_end +
                ", currentColor=" + currentColor +
                '}';
    }
}
