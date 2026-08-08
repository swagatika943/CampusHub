package main;

import java.util.Scanner;

public class CampusHub {
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
                    int studentChoice = 0;
                    while (studentChoice!=3){
                        System.out.println("========================");
                        System.out.println("        STUDENT MENU     ");
                        System.out.println("1. view Profile");
                        System.out.println("2. view Courses");
                        System.out.println("3. Logout");
                        System.out.println("========================");
                        System.out.print("Enter your choice: ");

                        studentChoice=sc.nextInt();
                        switch (studentChoice){
                            case 1:
                                System.out.println("Name: Demo Student");
                                System.out.println("ID: CH001");
                                System.out.println("Department: CSE");
                                break;
                            case 2:
                                System.out.println("Java");
                                System.out.println("HTML");
                                System.out.println("SQL");
                                System.out.println("CSS");
                                break;
                            case 3:
                                System.out.println("Logging out...");
                                break;
                            default:
                                System.out.println("Invalid Student Menu Choice!");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Admin Login Selected");
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
