package Interface;
import Container.Container;
import FileHandling.LoadDataBase;
import Port.*;
import User.PortManager;
import User.PortManagerList;
import Vehicle.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Locale.filter;

public class PortManagerInterface {
    protected final static File portManagerFile = new java.io.File("Assignment2_COSC2081/src/DataSource/manager.txt");
    static Scanner scanner = new Scanner(System.in);
    private static PortManager currentPortManager = new PortManager();
    public static PortManagerList portManagerList = new PortManagerList();

    public static Port currentPort = null;


    // Login
    // Check if the manager account is exist in the file
    public static boolean checkManager(String user) {
        try {
            scanner = new Scanner(portManagerFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(user)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please ensure the manager.txt file is in the correct location.");
            showMenu();  // redirect to the main menu
        }
        return false;
    }

    // Verify login
    private boolean verifyUserPas(String manager) {
        for (PortManager pmanager : portManagerList.getPortManagersList()) {
            if (checkManager(manager) && manager.equals(pmanager.getUsername()+","+pmanager.getPassword())) {
                currentPortManager = new PortManager(pmanager.getUsername(), pmanager.getPassword(), pmanager.getPort());
                currentPort = LoadDataBase.portList.stream()
                        .filter(port -> port.getpNum().equals(pmanager.getPort()))
                        .findFirst()
                        .orElse(null);
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
        try {
            portManagerList.createPortManagerList();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please ensure the manager.txt file is in the correct location.");
            showMenu();
            return;
        }
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
        System.out.println("Port name: " + currentPort.getpName());
        System.out.println("Port manager: " + currentPortManager.getUsername());
    }

    public static void ModifyingContainer() {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("-------------------Modifying Container-------------------");
        while (isRunning) {
            System.out.println("1. View all containers");
            System.out.println("2. Add a container");
            System.out.println("3. Delete a container");
            System.out.println("4. Create a container");
            System.out.println("5. Exit Modifying container");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> {
                        System.out.println("View all containers ");
                        for(Container c : currentPort.getContainers()) {
                            System.out.println(c);
                        }
                    }
                    case 2 -> {
                        System.out.println("Add a container ");
                        System.out.println();
                        System.out.println("Enter container id: ");
                        String cID = sc.nextLine();
                        Container con = LoadDataBase.containerList.stream()
                                .filter(c -> c.getId().equals(cID))
                                .findFirst().orElse(null);
                        if (con != null) {
                            currentPort.addContainers(con);
                        } else System.out.println("Container does not existed to add");
                    }
                    case 3 -> {
                        System.out.println("Delete a container ");
                        System.out.println();
                        System.out.println("Enter container id: ");
                        String cID = sc.nextLine();
                        Container con = LoadDataBase.containerList.stream()
                                .filter(c -> c.getId().equals(cID))
                                .findFirst().orElse(null);
                        if (con != null) {
                            currentPort.removeContainer(con);
                        } else System.out.println("Container does not existed in database to delete");
                    }
                    case 4 -> {
                        System.out.println("Please access [specific_type]Container.txt to create");
                    }
                    case 5 -> {
                        System.out.println("Exit Modifying container");
                        isRunning = false;
                    }
                    default -> System.out.println("Invalid Action!");
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void ModifyingVehicle() {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("-------------------Modifying Vehicle-------------------");
        while (isRunning) {
            System.out.println("1. View all vehicle");
            System.out.println("2. Add a vehicle");
            System.out.println("3. Delete a container");
            System.out.println("4. Create a vehicle");
            System.out.println("5. Exit Modifying Vehicle");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> {
                        System.out.println("View all containers ");
                        for(Vehicle v : currentPort.getVehicles()) {
                            System.out.println(v);
                        }
                    }
                    case 2 -> {
                        System.out.println("Add a vehicle ");
                        System.out.println();
                        System.out.println("Enter vehicle id: ");
                        String veID = sc.nextLine();
                        Vehicle ve = LoadDataBase.vehicleList.stream()
                                .filter(v -> v.getVehID().equals(veID))
                                .findFirst().orElse(null);
                        if (ve != null) {
                            currentPort.addVehicle(ve);
                        } else System.out.println("Vehicle does not existed in database to add");
                    }
                    case 3 -> {
                        System.out.println("Delete a vehicle ");
                        System.out.println();
                        System.out.println("Enter vehicle id: ");
                        String veID = sc.nextLine();
                        Vehicle ve = LoadDataBase.vehicleList.stream()
                                .filter(v -> v.getVehID().equals(veID))
                                .findFirst().orElse(null);
                        if (ve != null) {
                            currentPort.removeVehicle(ve);
                        } else System.out.println("Vehicle does not existed to delete");
                    }
                    case 4 -> {
                        System.out.println("Please access [specific_type]Truck.txt or ship.txt to create");
                    }
                    case 5 -> {
                        System.out.println("Exit Modifying Vehicle");
                        isRunning = false;
                    }
                    default -> System.out.println("Invalid Action!");
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void showMenu() {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("-------------------MANAGER MENU-------------------");
        List<Port> ports = new ArrayList<>(); // Declare outside of try block
        try {
            ports = Port.loadPortsFromFile();
        } catch (FileNotFoundException e) {
            System.out.println("Port file not found.");
        }
        while (isRunning) {
            System.out.println("1. Total gallons of fuel used");
            System.out.println("2. View all containers in this port");
            System.out.println("3. View all vehicles");
            System.out.println("4. View port information");
            System.out.println("5. Update container in port ");
            System.out.println("6. Update vehicle in port ");
            System.out.println("7. Exit Manager Menu");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> System.out.println("Total gallons of fuel used: " + Port.getTotalFuelUsed(ports));
                    case 2 -> {
                        System.out.println("View all containers in this port: ");
                        currentPort.getAllContainerDetailInPort();
                    }
                    case 3 -> {
                        System.out.println("View all vehicles: ");
                        for (Vehicle ve: currentPort.getVehicles()) {
                            System.out.println(ve);
                        }
                        currentPort.countVehicle();
                    }
                    case 4 -> {
                        System.out.println("View Port Information");
                        viewPortInformation();
                    }
                    case 5 -> {
                        System.out.println("Update containers in port");
                        ModifyingContainer();
                    }
                    case 6 -> {
                        System.out.println("Update vehicles in port");
                        ModifyingVehicle();
                    }
                    case 7 -> {
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
