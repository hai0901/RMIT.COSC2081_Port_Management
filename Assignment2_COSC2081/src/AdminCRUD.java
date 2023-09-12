import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AdminCRUD {
    static Scanner scanner = new Scanner(System.in);
    private MainMenu mainMenu;

    private static boolean validateLogin(String adminAccount, String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
    private static String displayLogin() {
        System.out.println("Enter admin username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter admin password: ");
        String password = scanner.nextLine();

        return username + ", " + password;
    }

    public void Login() throws Exception {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("-----------------ADMIN LOGIN PAGE-----------------");
            if (validateLogin(displayLogin(), "Assignment2_COSC2081/src/admin_login_credential.txt")) {
                System.out.println("Login successful!");
                System.out.println("--------------------------------------------------");
                isRunning = false;

            } else {
                System.out.println("Login failed!");
                System.out.println("Please try again!");
            }
        }
    }




    // admin menu
    public void adminMenu() throws Exception {
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
            action = scanner.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1:
                        System.out.println("View Managers");
                        break;
                    case 2:
                        System.out.println("Update Manager");
                        break;
                    case 3:
                        System.out.println("Delete Manager");
                        break;
                    case 4:
                        System.out.println("View Manager");
                        break;
                    case 5:
                        System.out.println("Exit Admin Menu");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid action!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        AdminCRUD adminCRUD = new AdminCRUD();
        adminCRUD.Login();
        adminCRUD.adminMenu();
    }
}
