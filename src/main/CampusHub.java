package main;

import java.util.Scanner;

public class CampusHub {
    static StudentManager manager = new StudentManager();
    static CourseManager courseManager = new CourseManager();
    public static void studentMenu(Scanner sc){

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
                    manager.searchStudent(inputId);
                    break;
                case 2:
                    courseManager.viewCourses();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid Student Menu Choice!");
            }
        }
    }
    public static void courseMenu(Scanner sc) {
        int courseChoice = 0;
        while (courseChoice != 5) {

            System.out.println("========================");
            System.out.println("      COURSE MENU");
            System.out.println("1. View Courses");
            System.out.println("2. Search Course");
            System.out.println("3. Add Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Back");
            System.out.println("========================");
            System.out.print("Enter your choice: ");

            courseChoice = sc.nextInt();

            switch (courseChoice) {
                case 1:
                    courseManager.viewCourses();
                    break;
                case 2:
                    System.out.print("Enter Course ID: ");
                    String searchId = sc.next();

                    courseManager.searchCourse(searchId);
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    String courseId = sc.next();

                    System.out.print("Enter Course Name: ");
                    String courseName = sc.next();

                    courseManager.addCourse(courseId, courseName);
                    break;
                case 4:
                    System.out.print("Enter Course ID to delete: ");
                    String deleteId = sc.next();
                    courseManager.deleteCourse(deleteId);
                    break;
                case 5:
                    System.out.println("Returning to Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid Course Menu Choice!");
            }
        }
    }

    public static void adminMenu(Scanner sc){

        int adminChoice = 0;
        while(adminChoice != 7){
            System.out.println("========================");
            System.out.println("        ADMIN MENU     ");
            System.out.println("1. View Student");
            System.out.println("2. Search Student");
            System.out.println("3. Add Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Course Management");
            System.out.println("7. Logout");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            adminChoice=sc.nextInt();

            switch (adminChoice){
                case 1:
                    manager.viewStudents();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String searchId = sc.next();

                    manager.searchStudent(searchId);

                    break;

                case 3:
                    System.out.println("Enter Student Name");
                    String name = sc.next();

                    System.out.println("Enter Student ID");
                    String id = sc.next();

                    System.out.println("Enter Department");
                    String department = sc.next();

                    manager.addStudent(name, id, department);

                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.next();

                    manager.deleteStudent(deleteId);

                    break;

                case 5:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = sc.next();

                    System.out.print("Enter New Name: ");
                    String newName = sc.next();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.next();

                    manager.updateStudent(updateId, newName, newDepartment);
                    break;
                case 6:
                    courseMenu(sc);
                    break;
                case 7:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid Admin Menu Choice!");
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

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
