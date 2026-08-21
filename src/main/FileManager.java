package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class FileManager {

    public static void createDataFolder() {
        File folder = new File("data");
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Data folder created successfully!");
            } else {
                System.out.println("Failed to create data folder!");
            }
        } else {
            System.out.println("Data folder already exists!");
        }
    }
    public static void saveStudents(StudentManager manager) {
        try {
            FileWriter writer = new FileWriter("data/students.txt");
            Student[] students = manager.getStudents();
            int studentCount = manager.getStudentCount();
            for (int i = 0; i < studentCount; i++) {
                writer.write(
                        students[i].getId() + "," + students[i].getName() + "," + students[i].getDepartment() + "\n"
                );
            }
            writer.close();
            System.out.println("Students saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving students!");
        }
    }
    public static void loadStudents(StudentManager manager) {
        manager.clearStudents();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String department = data[2];
                manager.addStudent(name, id, department);
            }
            reader.close();
            System.out.println("Students loaded successfully!");

        } catch (IOException e) {
            System.out.println("Error loading students!");
        }
    }
    public static void saveCourses(CourseManager manager) {

        try {
            FileWriter writer = new FileWriter("data/courses.txt");
            Course[] courses = manager.getCourses();
            int courseCount = manager.getCourseCount();
            for (int i = 0; i < courseCount; i++) {
                writer.write(
                        courses[i].getCourseId() + ","
                                + courses[i].getCourseName()
                                + "\n"
                );
            }
            writer.close();
            System.out.println("Courses saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving courses!");
        }
    }
    public static void loadCourses(CourseManager manager) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/courses.txt"));
            manager.clearCourses();

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                String id = data[0];
                String name = data[1];

                manager.addCourse(id, name);
            }
            reader.close();
            System.out.println("Courses loaded successfully!");
        } catch (IOException e) {
            System.out.println("Error loading courses!");
        }
    }
    public static void saveEnrollments(EnrollmentManager manager) {

        try {
            FileWriter writer = new FileWriter("data/enrollments.txt");
            Enrollment[] enrollments = manager.getEnrollments();
            int enrollmentCount = manager.getEnrollmentCount();

            for (int i = 0; i < enrollmentCount; i++) {
                writer.write(
                        enrollments[i].getStudentId() + ","
                                + enrollments[i].getCourseId()
                                + "\n"
                );
            }
            writer.close();

            System.out.println("Enrollments saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving enrollments!");
        }
    }
}
