package ca.mcgill.cs.swdesign.m3;

import java.util.Objects;

public class Semester {
    public enum Term {Fall, Winter, Summer}

    final private Term aTerm;
    final int aYear;

    public Semester(Term pTerm, int pYear) {
        aTerm = pTerm;
        aYear = pYear;
    }

    public Term getTerm() {
        return aTerm;
    }

    public int getYear() {
        return aYear;
    }

    @Override
    public String toString() {
        return aTerm + "-" + aYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return aYear == semester.aYear &&
                aTerm == semester.aTerm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aTerm, aYear);
    }
}
