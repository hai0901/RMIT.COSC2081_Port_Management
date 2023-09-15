package User;

import java.util.Scanner;

public class MainMenu {
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
                        PortManager.Login();
                        PortManager.showMenu();
                    }
                    case 2 -> {
                        SystemAdmin.Login();
                        SystemAdmin.showMenu();
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

