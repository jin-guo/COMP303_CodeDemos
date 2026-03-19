package ca.mcgill.cs.swdesign.m7;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
    public Manager(String pName, Department pDepartment) {
        super(pName, pDepartment);
    }

    void annualReview(){
        System.out.println("Reviewing...");
    }

    @Override
    public String getName() {
        return "Manager: " + super.getName() + "," + super.getDepartment().getName();
    }

}
