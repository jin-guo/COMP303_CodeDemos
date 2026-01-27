package ca.mcgill.cs.swdesign.m3;

import java.util.Comparator;

public interface Student{
    String getID();
    String getFirstName();
    String getLastName();

    Comparator<Student> getIDComparator();
}
