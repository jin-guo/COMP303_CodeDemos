package ca.mcgill.cs.swdesign.m4;

import ca.mcgill.cs.swdesign.m2.demo.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CoursePrinter {

    /**
     * Writing the enrollment for the course into the file specified by the pFilePath
     * with default character encoding.
     * The order for writing the student is defined by the iterator provided by Course
     * @param pCourse The course in which the enrollment is to be written in the file
     * @param pFilePath System dependent file name.
     */
    public void writeToFile1(Course pCourse, String pFilePath) {
        File file = new File(pFilePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Student s : pCourse) {
                fileWriter.write(s.toString());
                fileWriter.write("\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Something is wrong when construct File object or writing to file!");
            e.printStackTrace();
        }
    }

    /**
     * The same function with writeToFile1
     * Using the Java try-with-resources construct
     * any resource opened within the try-with-resources block is automatically closed,
     * regardless of whether any exceptions are thrown either from inside the try-with-resources block,
     * or when attempting to close the resources.
     */
    public void writeToFile2(Course pCourse, String pFilePath) {
        File file = new File(pFilePath);
        try (FileWriter fileWriter = new FileWriter(file)){
            for (Student s : pCourse) {
                fileWriter.write(s.toString());
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Something is wrong with writing to the file");
            e.printStackTrace();
        }
    }

    /**
     * The same function with writeToFile1.
     * Instead of handling the exceptions inside the method, throw it to the caller to handle the exceptions.
     */
    public void writeToFile3(Course pCourse, String pFilePath) throws IOException {
        File file = new File(pFilePath);
        FileWriter fileWriter = new FileWriter(file);
        for (Student s : pCourse) {
            fileWriter.write(s.toString());
            fileWriter.write("\n");
        }
        fileWriter.close();
    }

}
