package ca.mcgill.cs.swdesign.m5;

import ca.mcgill.cs.swdesign.m2.Card;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;


public class Reflection {
    public static void main(String[] args) {

        Card card1 = new Card(Card.Rank.ACE, Card.Suit.CLUBS);
        Card card2 = new Card(Card.Rank.FIVE, Card.Suit.CLUBS);

        Class<Card> class1 = (Class<Card>) card1.getClass();
        Class<Card> class2 = (Class<Card>) card2.getClass();
        Class<Card> class3 = Card.class;
        Class<Integer> class4 = int.class;

        out.println(class1);
        out.println(class2);
        out.println(class3);
        out.println(class4);

        try {
            Class<Card> class5 = (Class<Card>) Class.forName("ca.mcgill.cs.swdesign.m2.Card");
            out.println(class5);
            out.println(class1 == class5);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Method[] methods = class1.getDeclaredMethods();
        for(Method m:methods) {
            out.println(m.toString());
        }
        out.println("Done printing methods.");

        try {
            Method privateMethod = BrightnessFlashlight.class.getDeclaredMethod("incrementBrightness");
            privateMethod.setAccessible(true);
            BrightnessFlashlight flashlight =  new BrightnessFlashlight();
            privateMethod.invoke(flashlight);
            out.println("Current brightness:");
            out.println(flashlight.getBrightness());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Field testFinalField  = BrightnessFlashlight.class.getDeclaredField("brightness");
            testFinalField.setAccessible(true);
            BrightnessFlashlight flashlight =  new BrightnessFlashlight();
            testFinalField.set(flashlight, 3);
            out.println(Modifier.toString(testFinalField.getModifiers()));
            out.println("Above are modifiers for the field");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


        Constructor<Card>[] constructors = (Constructor<Card>[]) class1.getDeclaredConstructors();
        for(Constructor c:constructors) {
            out.println(c.toString());
            try {
                Object constructedThroughReflection = c.newInstance(card1.getRank(), card1.getSuit());
                out.println(constructedThroughReflection==card1);
                out.println(constructedThroughReflection.equals(card1));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        try {
            Field rankOfCard = class1.getDeclaredField("aRank");
            rankOfCard.setAccessible(true);
            rankOfCard.set(card1, Card.Rank.JACK);
            out.println(card1.getRank());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static void printInfo(Object t){

            Class<?> c = t.getClass();
            out.format("Class:%n  %s%n%n", c.getCanonicalName());
            out.format("Modifiers:%n  %s%n%n",
                    Modifier.toString(c.getModifiers()));

            out.format("Type Parameters:%n");
            TypeVariable[] tv = c.getTypeParameters();
            if (tv.length != 0) {
                out.format("  ");
                for (TypeVariable eachtv : tv)
                    out.format("%s ", eachtv.getName());
                out.format("%n%n");
            } else {
                out.format("  -- No Type Parameters --%n%n");
            }

            out.format("Implemented Interfaces:%n");
            Type[] intfs = c.getGenericInterfaces();
            if (intfs.length != 0) {
                for (Type intf : intfs)
                    out.format("  %s%n", intf.toString());
                out.format("%n");
            } else {
                out.format("  -- No Implemented Interfaces --%n%n");
            }

            out.format("Inheritance Path:%n");
            List<Class> l = new ArrayList<Class>();
            printAncestor(c, l);
            if (l.size() != 0) {
                for (Class<?> cl : l)
                    out.format("  %s%n", cl.getCanonicalName());
                out.format("%n");
            } else {
                out.format("  -- No Super Classes --%n%n");
            }

            out.format("Annotations:%n");
            Annotation[] ann = c.getAnnotations();
            if (ann.length != 0) {
                for (Annotation a : ann)
                    out.format("  %s%n", a.toString());
                out.format("%n");
            } else {
                out.format("  -- No Annotations --%n%n");
            }


    }

    private static void printAncestor(Class<?> c, List<Class> l) {
        Class<?> ancestor = c.getSuperclass();
        if (ancestor != null) {
            l.add(ancestor);
            printAncestor(ancestor, l);
        }
    }




}
