package ca.mcgill.cs.swdesign.m7;

public class Developer extends Employee {
    public Developer(String pName, Department pDepartment) {
        super(pName, pDepartment);
    }


    public void reviewDoc(Developer e) {
        System.out.println("In Developer, overloaded method");
        System.out.println(e);
    }

    @Override
    public String toString() {
        return "Developer: " + super.getName() + ", " + super.getDepartment().getName();
    }
}