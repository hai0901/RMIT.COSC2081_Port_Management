package Interface;
import User.*;
import Port.*;
import java.io.FileNotFoundException;

import User.SystemAdmin;

import java.util.Scanner;


public class AdminInterface {

    private SystemAdmin admin;

    public AdminInterface() {
        this.admin = admin;
    }

    public static String loginScreen() {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        return username + "," + password;
    }
    public void login() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("-----------------ADMIN LOGIN PAGE-----------------");
            if (validateLogin(loginScreen())) {
                System.out.println("Login successful!");
                isRunning = false;
            } else {
                System.out.println("Login failed!");
                System.out.println("Please try again!");
            }
        }
    }
    public static boolean validateLogin(String adminAccount) {
        return adminAccount.equals("ad,ad");
    }
    public static void adminMenu() {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("--------------------ADMIN MENU--------------------");
        while (isRunning) {
            System.out.println("1. View Managers");
            System.out.println("2. Update Manager");
            System.out.println("3. Delete Manager");
            System.out.println("4. View Manager");
            System.out.println("5. Exit Admin Menu");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> System.out.println("View Managers");
                    case 2 -> System.out.println("Update Manager");
                    case 3 -> System.out.println("Delete Manager");
                    case 4 -> System.out.println("View Manager");
                    case 5 -> {
                        System.out.println("Exit Admin Menu");
                        isRunning = false;
                    }
                    default -> System.out.println("Invalid action!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

    public SystemAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(SystemAdmin admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "AdminInterface{" +
                "admin=" + admin +
                '}';
    }
}
