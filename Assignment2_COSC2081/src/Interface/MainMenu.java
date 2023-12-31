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
        int action;
        PortManager customer = new PortManager();
        PortManagerInterface portManagerInterface = new PortManagerInterface();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (this.isActive()) {
            System.out.println("Do you want to log in as admin or port manager?");
            System.out.println("0. Close Program");
            System.out.println("1. Log in as Port Manager");
            System.out.println("2. Log in as Admin");
            System.out.println("Please choose action : ");


            if (scanner.hasNextInt()) {
                action = scanner.nextInt();
                scanner.nextLine();
                switch (action) {
                    case 0:
                        this.setActive(false);
                        System.out.println("Thank you! Bye Bye!");
                        break;
                    case 1:
                        /* Port Manager Login */
                        portManagerInterface.login();
                        break;
                    case 2:
                        /* Admin Login*/
                        this.adminInterface.login();
                        this.adminInterface.adminMenu();
                        break;
                    default:
                        System.out.println("Wrong number please enter again!");
                        break;}
                } else {
                String invalidInput = scanner.nextLine();
                System.out.println("Invalid input: " + invalidInput);
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
