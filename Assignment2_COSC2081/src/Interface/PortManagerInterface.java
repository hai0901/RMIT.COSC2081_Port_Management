package Interface;

import User.PortManager;
import User.PortManagerList;
import User.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static User.PortManagerList.*;

public class PortManagerInterface {
    protected final static File portManagerFile = new java.io.File("Assignment2_COSC2081/src/manager.txt");
    static Scanner scanner = new Scanner(System.in);
    private static PortManager currentPortManager = new PortManager();
    private static PortManagerList portManagerList = new PortManagerList();




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
            if (checkManager(manager) && manager.equals(pmanager.getUsername()+","+pmanager.getPassword())) {
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
                showMenu();
                isRunning = false;
            } else {
                System.out.println("Entered password or username is wrong please input again!");
                portmanagerInput = getInput();
            }
        }
    }
    // view port information
    public static void viewPortInformation() {
        System.out.println("Port information: ");
        System.out.println("Port name: " + currentPortManager.getPort());
        System.out.println("Port manager: " + currentPortManager.getUsername());
    }
    public static void showMenu() {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("-------------------MANAGER MENU-------------------");
        while (isRunning) {
            System.out.println("1. View total gallons of fuel used");
            System.out.println("2. View weight of containers");
            System.out.println("3. View ships");
            System.out.println("4. View port information");
            System.out.println("5. Exit Manager Menu");
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
                    case 4 -> {
                        System.out.println("View Port Information");
                        viewPortInformation();
                    }
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
