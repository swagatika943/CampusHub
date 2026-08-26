package main;

import java.util.InputMismatchException;
import java.util.Scanner;
public class CampusHub {
    static StudentManager manager = new StudentManager();
    static CourseManager courseManager = new CourseManager();
    static EnrollmentManager enrollmentManager = new EnrollmentManager();
    public static void studentMenu(Scanner sc){

        int studentChoice = 0;
        while (studentChoice!=6){
            System.out.println("========================");
            System.out.println("        STUDENT MENU     ");
            System.out.println("1. View Profile");
            System.out.println("2. View Courses");
            System.out.println("3. Enroll Course");
            System.out.println("4. View Enrolled Courses");
            System.out.println("5. Drop Courses");
            System.out.println("6. Logout");
            System.out.println("========================");
            System.out.print("Enter your choice: ");

            try {
                studentChoice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.next();
                continue;
            }

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
                    System.out.print("Enter Student ID: ");
                    String studentId = sc.next();
                    System.out.print("Enter Course ID: ");
                    String courseId = sc.next();
                    enrollmentManager.enrollStudent(studentId, courseId);
                    FileManager.saveEnrollments(enrollmentManager);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String enrolledStudentId = sc.next();
                    enrollmentManager.viewEnrolledCourses(enrolledStudentId);
                    break;
                case 5:
                    System.out.print("Enter Student ID: ");
                    String dropStudentId = sc.next();
                    System.out.print("Enter Course ID to drop: ");
                    String dropCourseId = sc.next();
                    enrollmentManager.dropCourse(dropStudentId, dropCourseId);
                    break;
                case 6:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid Student Menu Choice!");
            }
        }
    }
    public static void courseMenu(Scanner sc) {
        int courseChoice = 0;
        while (courseChoice != 6) {

            System.out.println("========================");
            System.out.println("      COURSE MENU");
            System.out.println("1. View Courses");
            System.out.println("2. Search Course");
            System.out.println("3. Add Course");
            System.out.println("4. Delete Course");
            System.out.println("5. Update Course");
            System.out.println("6. Back");
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
                    FileManager.saveCourses(courseManager);
                    break;
                case 4:
                    System.out.print("Enter Course ID to delete: ");
                    String deleteId = sc.next();
                    courseManager.deleteCourse(deleteId);
                    FileManager.saveCourses(courseManager);
                    break;
                case 5:
                    System.out.print("Enter Course ID to update: ");
                    String updateId = sc.next();
                    System.out.print("Enter New Course Name: ");
                    String newCourseName = sc.next();
                    courseManager.updateCourse(updateId, newCourseName);
                    FileManager.saveCourses(courseManager);
                    break;
                case 6:
                    System.out.println("Returning to Admin Menu...");
                    break;
                default:
                    System.out.println("Invalid Course Menu Choice!");
            }
        }
    }

    public static void adminMenu(Scanner sc){

        int adminChoice = 0;
        while(adminChoice != 8){
            System.out.println("========================");
            System.out.println("        ADMIN MENU     ");
            System.out.println("1. View Student");
            System.out.println("2. Search Student");
            System.out.println("3. Add Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student");
            System.out.println("6. Course Management");
            System.out.println("7. Enrollment Report");
            System.out.println("8. Logout");
            System.out.println("========================");
            System.out.print("Enter your choice: ");

            try {
                adminChoice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.next();
                continue;
            }

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

                    boolean added = manager.addStudent(name, id, department);
                    if (added) {
                        FileManager.saveStudents(manager);
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = sc.next();
                    manager.deleteStudent(deleteId);
                    FileManager.saveStudents(manager);
                    break;
                case 5:
                    System.out.print("Enter Student ID to update: ");
                    String updateId = sc.next();
                    System.out.print("Enter New Name: ");
                    String newName = sc.next();
                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.next();
                    manager.updateStudent(updateId, newName, newDepartment);
                    FileManager.saveStudents(manager);
                    break;
                case 6:
                    courseMenu(sc);
                    break;
                case 7:
                    enrollmentManager.viewAllEnrollments();
                    break;
                case 8:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid Admin Menu Choice!");
            }
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        FileManager.createDataFolder();
        FileManager.loadStudents(manager);
        FileManager.loadCourses(courseManager);
        FileManager.loadEnrollments(enrollmentManager);

        int choice = 0;
        while(choice != 3){
            System.out.println("================================");
            System.out.println("      WELCOME TO CAMPUSHUB      ");
            System.out.println("1. Student Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number!");
                sc.next();
            }

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
