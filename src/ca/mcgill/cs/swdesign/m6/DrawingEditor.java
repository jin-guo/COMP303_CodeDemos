package ca.mcgill.cs.swdesign.m6;


public class DrawingEditor {
    KeyboardShortcut aShortcut;

    void setKeyboardShortcut(KeyboardShortcut pShortcut) {
        assert pShortcut != null;
        aShortcut = pShortcut;
    }
    void respondToShortcut(){
        aShortcut.clicked();
    }


    public static void main(String[] args) {
        DrawingEditor drawingEditor = new DrawingEditor();
        Line lineObj = new Line(5, 5, 10, 10);

        System.out.println(lineObj.toString());

        KeyboardShortcut ks1 = new MoveShortcut(lineObj,1, 1 );

        drawingEditor.setKeyboardShortcut(ks1);

        drawingEditor.respondToShortcut();
        System.out.println(lineObj.toString());


    }
}
