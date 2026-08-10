package main;

import java.util.Scanner;

public class CampusHub {
    static String[] stuNames = new String[10];
    static String[] stuIds = new String[10];
    static String[] stuDepartments = new String[10];

    static int studentCount = 3;
    public static void initializeStudents() {

        stuNames[0] = "Swagatika";
        stuIds[0] = "CH001";
        stuDepartments[0] = "CSE";

        stuNames[1] = "Ammu";
        stuIds[1] = "CH002";
        stuDepartments[1] = "MCA";

        stuNames[2] = "Kookie";
        stuIds[2] = "CH003";
        stuDepartments[2] = "BS";
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

                        if (stuIds[i].equals(inputId)) {

                            System.out.println("Name: " + stuNames[i]);
                            System.out.println("ID: " + stuIds[i]);
                            System.out.println("Department: " + stuDepartments[i]);
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
        while(adminChoice != 5){
            System.out.println("========================");
            System.out.println("        ADMIN MENU     ");
            System.out.println("1. View Student");
            System.out.println("2. Search Student");
            System.out.println("3. Add Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Logut");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            adminChoice=sc.nextInt();

            switch (adminChoice){
                case 1:
                    for (int i = 0; i < studentCount; i++) {
                        System.out.println(
                                stuIds[i] + ": " + stuNames[i] + ": " + stuDepartments[i]
                        );
                    }
                    break;
                case 2 :
                    System.out.print("Enter Student ID: ");
                    String searchId = sc.next();
                    boolean found = false;
                    for (int i = 0; i < studentCount; i++) {

                        if (stuIds[i].equals(searchId)) {

                            System.out.println("Name: " + stuNames[i]);
                            System.out.println("ID: " + stuIds[i]);
                            System.out.println("Department: " + stuDepartments[i]);

                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    if(studentCount >= stuNames.length){
                        System.out.println("Student limt reached!");
                    } else {
                        System.out.println("Enter Student Name");
                        String name = sc.next();

                        System.out.println("Enter Student ID");
                        String ID = sc.next();
                        if(!ID.startsWith("CH")){
                            System.out.println("Invalid Student ID!");
                            break;
                        }

                        System.out.println("Enter Department");
                        String department = sc.next();

                        boolean idExists = false;
                        for(int i = 0; i<studentCount; i++){
                            if(stuIds[i].equals(ID)){
                                idExists = true;
                                break;
                            }
                        }

                       if(idExists){
                           System.out.println("Student Id alredy exists!");
                       } else{
                           stuNames[studentCount] = name;
                           stuIds[studentCount] = ID;
                           stuDepartments[studentCount] = department;

                           studentCount++;

                           System.out.println("Student added succesfully");
                       }
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.next();

                    boolean deleteFound = false;
                    int deleteIndex = -1;

                    //Find student
                    for (int i = 0; i < studentCount; i++) {

                        if (stuIds[i].equals(deleteId)) {
                            deleteFound = true;
                            deleteIndex = i;
                            break;
                        }
                    }

                    if (deleteFound) {

                        // Shift students to the left
                        for (int i = deleteIndex; i < studentCount - 1; i++) {

                            stuNames[i] = stuNames[i + 1];
                            stuIds[i] = stuIds[i + 1];
                            stuDepartments[i] = stuDepartments[i + 1];

                        }
                        studentCount--;

                        System.out.println("Student deleted successfully!");

                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5:
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
