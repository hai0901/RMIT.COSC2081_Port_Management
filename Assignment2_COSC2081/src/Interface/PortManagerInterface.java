package Interface;

import User.PortManager;
import User.PortManagerList;
import User.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static User.PortManagerList.*;

public class PortManagerInterface {
    protected final static File portManagerFile = new java.io.File("Assignment2_COSC2081/src/User/manager.txt");
    static Scanner scanner = new Scanner(System.in);
    private static PortManager currentPortManager = new PortManager();
    private static PortManagerList portManagerList = new PortManagerList();



    // create new port manager if not exist in list
    public static void createNewPortManager() {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter port: ");
        String port = scanner.nextLine();
        PortManager newportManager = new PortManager(username, password, port);
        portManagerList.getPortManagersList().add(newportManager);
        FileHandling.File.writeToFile("Assignment2_COSC2081/src/User/manager.txt", newportManager.toString());
    }
    // Login
    // Check if the manager account is exist in the file
    public static boolean checkManager(String user) {
        try {
            int lineno = 0;
            scanner = new Scanner(portManagerFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineno++;
                if (line.contains(user)) {
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return false;
    }
    // Verify login
    private boolean verifyUserPas(String manager) {
        for (PortManager pmanager : portManagerList.getPortManagersList()) {
            if (checkManager(manager) && manager.equals(pmanager.getUsername()+","+pmanager.getPassword()+",")) {
                this.currentPortManager = new PortManager(pmanager.getUsername(), pmanager.getPassword(), pmanager.getPort());
                return true;
                }
            }
        return false;
    }


    // get input from user
    public String getInput() {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        return username + "," + password;
    }

    public void login() throws Exception {

        System.out.println("----------------MANAGER LOGIN PAGE----------------");
        String portmanagerInput = getInput();
        portManagerList.createPortManagerList();
        boolean isRunning = true;
        while (isRunning) {
            if (verifyUserPas(portmanagerInput)) {
                System.out.println("Login successful!");
                display();
                isRunning = false;
            } else {
                System.out.println("Entered password or username is wrong please input again!");
                portmanagerInput = getInput();
            }
        }
    }
    // view port information
    public void viewPortInformation() {
        System.out.println("Port information: ");
        System.out.println("Port name: " + currentPortManager.getPort());
        System.out.println("Port manager: " + currentPortManager.getUsername());
    }
    public static byte display() {
        System.out.println("------------ MANAGER HOMEPAGE ------------");
        System.out.println("0. Logout.");
        System.out.println("1. View all your information.");
        System.out.println("2. Update your information.");
        System.out.println("3. Check your current membership.");
        System.out.println("4. List all products.");
        System.out.println("5. List product by price order.");
        System.out.println("6. Create new order.");
        System.out.println("7. View order information.");
        System.out.println("8. View order history.");
        System.out.println("You can choose action by entering a number: ");
        return scanner.nextByte();
    }

    public static void menuCustomer() throws Exception {
        boolean flag = true;
        byte action;

        while (flag) {
            action = display();
            switch (action) {
                case 0:
                    flag = false;
                    // menu.display();
                    break;
                case 1:
                    // viewPortInformation();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    System.out.println("Still develop");
                    break;
                case 8:
                    System.out.println("This feature is developing!");
                    break;
                default:
                    System.out.println("Please enter a number from 1 to 8! ");
            }
        }
    }
}
