
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AdminCRUD {
    static Scanner scanner = new Scanner(System.in);
    private Menu mainMenu;

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

    public static void main(String[] args) throws Exception {
        AdminCRUD adminCRUD = new AdminCRUD();
        adminCRUD.Login();
        adminCRUD.adminMenu();
    }


    // admin menu
    public void adminMenu() throws Exception {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("--------------------ADMIN MENU--------------------");
        while (isRunning) {
            System.out.println("1. View managers");
            System.out.println("2. Update manager");
            System.out.println("3. Delete manager");
            System.out.println("4. View manager");
            System.out.println("5. Exit");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner scanner = new Scanner(System.in);
            action = scanner.nextLine();
            actionNum = Byte.parseByte(action);
            switch (actionNum) {
                case 1:
                    System.out.println("View managers");
                    break;
                case 2:
                    System.out.println("Update manager");
                    break;
                case 3:
                    System.out.println("Delete manager");
                    break;
                case 4:
                    System.out.println("View manager");
                    break;
                case 5:
                    System.out.println("Exit");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid action!");
                    break;
            }
        }
    }

}
