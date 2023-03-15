package ca.mcgill.cs.swdesign.m7;

public class Client {
    public static void main(String[] args) {
        Employee e1, e2;
        e1 = new Developer("July", new Department("Security"));
        e2 = new Manager("Diana", new Department("Security"));
        Developer e3 = new Developer("Sam", new Department("Security"));

        System.out.println(e1 instanceof Developer);
        System.out.println(e1 instanceof Employee);

        ((Manager) e2).annualReview();
//        ((Manager) e1).annualReview(); // This is going to cause ClassCastException exception.

        e2.reviewDoc(e1);
        e1.reviewDoc(e3);
        ((Developer) e1).reviewDoc(e3); // The overloaded method is called here.



    }
}
