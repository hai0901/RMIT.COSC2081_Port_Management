package User;

import Port.*;
import Interface.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SystemAdmin extends User {
    private User admin;
    private Port port;

    public SystemAdmin(String username, String password, User admin, Port port) {
        super(username, password);
        this.admin = admin;
        this.port = port;
    }

    public static void login() {
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
/*
    public static boolean validateLogin(String adminAccount) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Assignment2_COSC2081/src/User/admin_login_credential.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(adminAccount)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
this port = user.getPort();

1. get arraylist<User>
while (username) {
    for( User u : usersList) {
        if (u.getPassword().equals(password)) {
            login = true
            return thisPort = u.getPort
        }
    }
    if (login) {
        System.out.println("Login successful!");
        System.out.println("--------------------------------------------------");
        isRunning = false;
    } else {
        System.out.println("Login failed!");
        System.out.println("Please try again!");
    }

----------------------------------------------------------------------
update port() {
thisport.update
}
this.update
this.deletlte

if (for ) {
        System.out.println("Login successful!");
        System.out.println("--------------------------------------------------");
        isRunning = false;
    } else {
        System.out.println("Login failed!");
        System.out.println("Please try again!");
    }

    public static void Login() {
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
    public static void showMenu() {
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
}
*/