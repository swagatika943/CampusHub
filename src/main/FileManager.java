package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
}
