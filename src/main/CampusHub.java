package main;

import java.util.Scanner;

public class CampusHub {

    public static void studentMenu(Scanner sc){

        String stuName = "Swagatika";
        String stuID = "CH001";
        String stuDepartment = "CSE";
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
                    System.out.println("Name: " +stuName);
                    System.out.println("ID: " +stuID);
                    System.out.println("Department: " +stuDepartment);
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
        while(adminChoice != 3){
            System.out.println("========================");
            System.out.println("        ADMIN MENU     ");
            System.out.println("1. View Student");
            System.out.println("2. Add student");
            System.out.println("3. Logout");
            System.out.println("========================");
            System.out.print("Enter your choice: ");

            adminChoice=sc.nextInt();
            switch (adminChoice){
                case 1:
                    System.out.println("CH001: Swagatika: Btech");
                    System.out.println("CH002: Ammu: MCA");
                    System.out.println("CH003: Kookie: BS");
                    break;
                case 2:
                    System.out.println("Enter Student Name");
                    System.out.println("Enter Student ID");
                    System.out.println("Enter Department");
                    break;
                case 3:
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
