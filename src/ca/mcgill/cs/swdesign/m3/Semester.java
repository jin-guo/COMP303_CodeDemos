package ca.mcgill.cs.swdesign.m3;

import java.util.Objects;

public class Semester {
    public enum Term {Fall, Winter, Summer}

    private static class SemesterCaches {
        static final int minYear = 1980;
        static final int maxYear = 2070;

        static final Semester[][] caches = new Semester[maxYear-minYear+1][Term.values().length];

        // Create the flyweight objects
        static {
            for (int i = minYear; i < maxYear+1; i++) {
                for (Term term : Term.values()) {
                    caches[i-minYear][term.ordinal()] = new Semester(term, i);
                }
            }
        }
    }

    final private Term aTerm;
    final private int aYear;

    private Semester(Term pTerm, int pYear) {
        aTerm = pTerm;
        aYear = pYear;
    }

    public static Semester getSemester(Term pTerm, int pYear) {
        if(pYear>=SemesterCaches.minYear && pYear<=SemesterCaches.maxYear) {
            return SemesterCaches.caches[pYear-SemesterCaches.minYear][pTerm.ordinal()];
        } else {
            return new Semester(pTerm, pYear);
        }
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
