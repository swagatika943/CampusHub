package main;

import java.util.Scanner;

public class CampusHub {
    static Student[] students = new Student[10];
    static int studentCount = 3;
    public static void initializeStudents() {
        students[0] = new Student("Swagatika", "CH001", "CSE");
        students[1] = new Student("Ammu", "CH002", "MCA");
        students[2] = new Student("Kookie", "CH003", "BS");
    }
    public static int findStudent(String id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public static void studentMenu(Scanner sc){

        String[] courses = {"Java", "HTML", "SQL", "CSS"};

        int studentChoice = 0;
        while (studentChoice!=3){
            System.out.println("========================");
            System.out.println("        STUDENT MENU     ");
            System.out.println("1. View Profile");
            System.out.println("2. View Courses");
            System.out.println("3. Logout");
            System.out.println("========================");
            System.out.print("Enter your choice: ");

            studentChoice=sc.nextInt();

            switch (studentChoice){
                case 1:
                    System.out.print("Enter Student ID: ");
                    String inputId = sc.next();
                    boolean found = false;
                    for (int i = 0; i < studentCount; i++) {

                        if (students[i].getId().equals(inputId)) {

                            System.out.println("Name: " + students[i].getName());
                            System.out.println("ID: " + students[i].getId());
                            System.out.println("Department: " + students[i].getDepartment());

                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 2:
                    for(int i=0; i<courses.length; i++){
                        System.out.println(courses[i]);
                    }
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid Student Menu Choice!");
            }
        }
    }

    public static void adminMenu(Scanner sc){

        int adminChoice = 0;
        while(adminChoice != 6){
            System.out.println("========================");
            System.out.println("        ADMIN MENU     ");
            System.out.println("1. View Student");
            System.out.println("2. Search Student");
            System.out.println("3. Add Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Logout");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            adminChoice=sc.nextInt();

            switch (adminChoice){
                case 1:
                    for (int i = 0; i < studentCount; i++) {
                        System.out.println(
                                students[i].getId() + ": " + students[i].getName() + ": " + students[i].getDepartment()
                        );
                    }
                    break;
                case 2 :
                    System.out.print("Enter Student ID: ");
                    String searchId = sc.next();

                    int index = findStudent(searchId);
                    if (index != -1) {

                        System.out.println("Name: " + students[index].getName());
                        System.out.println("ID: " + students[index].getId());
                        System.out.println("Department: " + students[index].getDepartment());

                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    if (studentCount >= students.length) {
                        System.out.println("Student limit reached!");
                    } else {
                        System.out.println("Enter Student Name");
                        String name = sc.next();

                        System.out.println("Enter Student ID");
                        String ID = sc.next();

                        if (!ID.startsWith("CH")) {
                            System.out.println("Invalid Student ID!");
                            break;
                        }

                        System.out.println("Enter Department");
                        String department = sc.next();

                        boolean idExists = false;

                        for (int i = 0; i < studentCount; i++) {
                            if (students[i].getId().equals(ID)) {
                                idExists = true;
                                break;
                            }
                        }

                        if (idExists) {
                            System.out.println("Student ID already exists!");
                        } else {

                            students[studentCount] = new Student(name, ID, department);

                            studentCount++;

                            System.out.println("Student added successfully!");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.next();

                    int deleteIndex = findStudent(deleteId);

                    if (deleteIndex == -1) {
                        System.out.println("Student not found!");
                    } else {
                        for (int i = deleteIndex; i < studentCount - 1; i++) {
                            students[i] = students[i + 1];
                        }
                        studentCount--;
                        students[studentCount] = null;
                        System.out.println("Student deleted successfully!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = sc.next();

                    int updateIndex = findStudent(updateId);
                    if (updateIndex == -1) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println("Enter New Name: ");
                        String newName = sc.next();

                        System.out.println("Enter New Department: ");
                        String newDepartment = sc.next();

                        students[updateIndex].setName(newName);
                        students[updateIndex].setDepartment(newDepartment);

                        System.out.println("Student updated successfully!");
                    }
                    break;

                case 6:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid Admin Menu Choice!");
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        initializeStudents();

        int choice = 0;
        while(choice != 3){
            System.out.println("================================");
            System.out.println("      WELCOME TO CAMPUSHUB      ");
            System.out.println("1. Student Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    studentMenu(sc);
                    break;
                case 2:
                    adminMenu(sc);
                    break;
                case 3:
                    System.out.println("Thank You for using CampusHub ERP!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
            System.out.println();
        }
        sc.close();
    }
}
