package ca.mcgill.cs.swdesign.m6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpecialCircle extends Circle{
    public enum Style {
        ART, COMIC, CLASSIC, NEW_AGE
    }
    final private String aText;
    private Set<Style> styles;

    public SpecialCircle(int x_center, int y_center, int pRadius, String pText, Style[] pStyles) {
        super(x_center, y_center, pRadius);
        aText = pText;
        pStyles.clone();
        styles = new HashSet<>(Arrays.asList(pStyles.clone()));
    }


    @Override
    public SpecialCircle clone() {
        SpecialCircle clone = (SpecialCircle) super.clone();
        clone.styles = new HashSet<>(this.styles);
        return clone;
    }


    @Override
    public String toString() {
        return "SpecialCircle{" +
                "aText='" + aText + '\'' +
                ", styles=" + styles +
                '}';
    }

    public static void main(String[] args) {
        Style[] styles = new Style[]{Style.ART, Style.NEW_AGE};
        Circle c = new SpecialCircle(10, 10, 5, "Circle with Text", styles);
        SpecialCircle c1 = (SpecialCircle) c;


        Circle copy = c1.clone();
        System.out.println(copy.toString());
    }

}
