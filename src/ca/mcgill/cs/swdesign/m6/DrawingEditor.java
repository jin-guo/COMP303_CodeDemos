package ca.mcgill.cs.swdesign.m6;


public class DrawingEditor {
    KeyboardShortcut aShortcut;

    void setKeyboardShortcut(KeyboardShortcut pShortcut) {
        aShortcut = pShortcut;
    }
    void respondToShortcut(){
        aShortcut.clicked();
    }


    public static void main(String[] args) {
        Line lineObj = new Line(5, 5, 10, 10);

        System.out.println(lineObj.toString());

        KeyboardShortcut ks = new MoveShortcut(lineObj,1, 1 );
        ks.clicked();
        System.out.println(lineObj.toString());

        ks.undo();
        System.out.println(lineObj.toString());
    }
}
