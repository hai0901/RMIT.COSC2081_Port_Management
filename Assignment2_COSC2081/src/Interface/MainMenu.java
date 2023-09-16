package Interface;

import User.*;
import Port.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMenu {
    private User currentLoginUser;
    private Port currentPort;
    static Scanner scanner = new Scanner(System.in);
    public static boolean active = true;
    // Getter and Setter

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    private AdminInterface adminInterface;

    // Constructor
    public MainMenu(boolean active) throws FileNotFoundException {
        this.active = active;
        adminInterface = new AdminInterface();
    }


    public void display() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String action;
        byte actionNum;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Port Manager Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit Program");
            System.out.println("Enter your choice: ");
            action = scanner.nextLine();

            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> {
                        System.out.println("manager");
                    }
                    case 2 -> {
                        this.adminInterface.login();
                        this.adminInterface.adminMenu();
                    }
                    case 3 -> {
                        System.out.println("Exiting program...");
                        isRunning = false;
                    }
                    default -> System.out.println("Invalid choice! Please enter a number between 1 and 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
}

