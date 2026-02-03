package ca.mcgill.cs.swdesign.m4;

/**
 * Instead of extending Exception (as shown during the lecture),
 * we extend RuntimeException here to indicate that this exception
 * is thrown due to pre-condition violation and will case the program
 * to halt.
 */
public class CourseFullException extends RuntimeException {

    public CourseFullException() { }

    public CourseFullException(String pMessage) { super(pMessage); }

}
