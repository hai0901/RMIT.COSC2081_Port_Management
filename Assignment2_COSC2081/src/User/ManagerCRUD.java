package User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ManagerCRUD {
    static Scanner scanner = new Scanner(System.in);

    private static boolean validateLogin(String managerAccount) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Assignment2_COSC2081/src/manager_login_credential.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(managerAccount)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    private static String displayLogin() {
        System.out.println("Enter manager username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter manager password: ");
        String password = scanner.nextLine();

        return username + ", " + password;
    }

    public void Login() {
        boolean isRunning = true;

        while (isRunning) {
                System.out.println("----------------MANAGER LOGIN PAGE----------------");
            if (validateLogin(displayLogin())) {
                System.out.println("Login successful!");
                System.out.println("--------------------------------------------------");
                isRunning = false;

            } else {
                System.out.println("Login failed!");
                System.out.println("Please try again!");
            }
        }
    }




    // manager menu
    public void managerMenu() {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("-------------------MANAGER MENU-------------------");
        while (isRunning) {
            System.out.println("1. View Managers");
            System.out.println("2. Update Manager");
            System.out.println("3. Delete Manager");
            System.out.println("4. View Manager");
            System.out.println("5. Exit Manager Menu");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            action = scanner.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> System.out.println("View Managers");
                    case 2 -> System.out.println("Update Manager");
                    case 3 -> System.out.println("Delete Manager");
                    case 4 -> System.out.println("View Manager");
                    case 5 -> {
                        System.out.println("Exit Manager Menu");
                        isRunning = false;
                    }
                    default -> System.out.println("Invalid Action!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }

}
