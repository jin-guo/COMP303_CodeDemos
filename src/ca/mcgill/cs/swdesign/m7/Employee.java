package ca.mcgill.cs.swdesign.m7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Employee implements Iterable<Task>{
    private String aName;
    private Department aDepartment;
    private List<Task> aTasks = new ArrayList<>();

    Employee(String pName, Department pDepartment) {
        aName = pName;
        aDepartment= pDepartment;
    }

    public String getName() {
        return aName;
    }

    @Override
    public Iterator<Task> iterator() {
        return aTasks.iterator();
    }

    public Department getDepartment() {
        return aDepartment;
    }

}
