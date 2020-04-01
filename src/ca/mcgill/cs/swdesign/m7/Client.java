package ca.mcgill.cs.swdesign.m7;

public class Client {
    public static void main(String[] args) {
        Employee e1, e2;
        e1 = new Developer("July", new Department("Security"));
        e2 = new Manager("Diana", new Department("Security"));

        ((Manager) e2).annualReview();
//        ((Manager) e1).annualReview();

        System.out.println(e1 instanceof Developer);
        System.out.println(e1 instanceof Manager);

    }
}
