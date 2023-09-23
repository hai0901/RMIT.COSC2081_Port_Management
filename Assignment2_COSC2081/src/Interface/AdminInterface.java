package Interface;
import FileHandling.LoadDataBase;
import User.*;

import Container.*;
import User.SystemAdmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Interface.MainMenu.scanner;
import Vehicle.*;
import Port.*;

public class AdminInterface {

    private SystemAdmin admin;

    public AdminInterface() {
        this.admin = admin;
    }
    private static PortManagerList portManagerList = new PortManagerList();
    public static void createNewPortManager() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new port manager's username: ");
        String username = scanner.nextLine();
        System.out.println("Enter new port manager's password: ");
        String password = scanner.nextLine();
        System.out.println("Enter new port manager's port: ");
        String port = scanner.nextLine();

        PortManager newManager = new PortManager(username, password, port);
        portManagerList.getPortManagersList().add(newManager);

        FileHandling.File.writeToFile("Assignment2_COSC2081/DataSource/manager.txt", newManager.toString(), true);
    }
    public static String loginScreen() {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        return username + "," + password;
    }
    public void login() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("-----------------ADMIN LOGIN PAGE-----------------");
            if (validateLogin(loginScreen())) {
                System.out.println("Login successful!");
                isRunning = false;
            } else {
                System.out.println("Login failed!");
                System.out.println("Please try again!");
            }
        }
    }
    public static boolean validateLogin(String adminAccount) {
        return adminAccount.equals("ad,ad");
    }
    public static void adminMenu() throws NumberFormatException {
        String action;
        byte actionNum;
        boolean isRunning = true;
        System.out.println("--------------------ADMIN MENU--------------------");
        while (isRunning) {
            System.out.println("1. View Managers");
            System.out.println("2. Update Managers");
            System.out.println("3. Delete Managers");
            System.out.println("4. Create new Port Manager");
            System.out.println("5. Exit Admin Menu");
            System.out.println("6. Manage Vehicles");
            System.out.println("7. Manage Containers");
            System.out.println("8. Manage Port");

            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> {
                        System.out.println("View Managers");
                        PortManagerList portManagerList = new PortManagerList();
                        portManagerList.createPortManagerList();
                        portManagerList.displayPortManagerList();
                    }
                    case 2 -> {
                        System.out.println("Update Manager");
                        PortManagerList portManagerList = new PortManagerList();
                        portManagerList.createPortManagerList();
                        portManagerList.displayPortManagerList();

                        System.out.println("Enter the username of the manager to update: ");
                        String username = scanner.nextLine();
                        for (PortManager manager : portManagerList.getPortManagersList()) {
                            if (manager.getUsername().equals(username)) {
                                System.out.println("Enter new password: ");
                                manager.setPassword(scanner.nextLine());
                                System.out.println("Enter new port: ");
                                manager.setPort(scanner.nextLine());

                                // Update in file
                                FileHandling.File.updateToFile("Assignment2_COSC2081/DataSource/manager.txt", portManagerList.getPortManagersList());
                                break;
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Delete Manager");
                        PortManagerList portManagerList = new PortManagerList();
                        portManagerList.createPortManagerList();
                        portManagerList.displayPortManagerList();

                        System.out.println("Enter the username of the manager to delete: ");
                        String username = scanner.nextLine();
                        portManagerList.getPortManagersList().removeIf(manager -> manager.getUsername().equals(username));

                        // Update in file
                        FileHandling.File.updateToFile("Assignment2_COSC2081/DataSource/manager.txt", portManagerList.getPortManagersList());
                    }

                    case 4 -> {
                        System.out.println("Create new Port Manager");
                        AdminInterface.createNewPortManager();
                        System.out.println("Your account has been successfully created.");
                        break;
                    }
                    case 5 -> {
                        System.out.println("Exit Admin Menu");
                        isRunning = false;
                    }
                    case 6 ->{
                        manageVehicles();
                    }
                    case 7 -> manageContainers();
                    case 8 -> managePort();

                    default -> System.out.println("Invalid action!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void manageContainers() throws IOException {
        System.out.println("1. Add Container");
        System.out.println("2. Update Container");
        System.out.println("3. Delete Container");
        System.out.println("4. View Containers");
        System.out.println("5. Return to Admin Menu");
        System.out.println("Enter your action: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left over

        switch (choice) {
            case 1 -> {
                System.out.println("Enter container ID: ");
                String containerId = scanner.nextLine();
                System.out.println("Enter container weight: ");
                double weight = scanner.nextDouble();
                System.out.println("Enter 1 of 5 container type (Drystorage, Opentop, Openside, Liquid, Refrigerated): ");
                String type = scanner.nextLine();
                if(type.equals("drystorage")) LoadDataBase.containerList.add(new DryStorage(containerId,weight));
                else if(type.equals("refrigerated")) LoadDataBase.containerList.add(new Refrigerated(containerId,weight));
                else if(type.equals("opentop")) LoadDataBase.containerList.add(new OpenTop(containerId,weight));
                else if(type.equals("openside")) LoadDataBase.containerList.add(new OpenSide(containerId,weight));
                else if(type.equals("liquid")) LoadDataBase.containerList.add(new Liquid(containerId,weight));
                else System.out.println("Invalid type container");
            }
            case 2 -> {
                System.out.println("Enter container ID to update: ");
                String containerId = scanner.nextLine();
                System.out.println("Enter new container weight: ");
                double weight = scanner.nextDouble();
                LoadDataBase.findContainer(containerId).setWeight(weight);
            }
            case 3 -> {
                System.out.println("Enter container ID to delete: ");
                String containerId = scanner.nextLine();
                LoadDataBase.containerList.remove(LoadDataBase.findContainer(containerId));
            }
            case 4 -> {
                for (Container c: LoadDataBase.containerList) {
                    System.out.println(c);
                }
            }
            case 5 -> {
                System.out.println("Returning to Admin Menu.");
            }
        }

    }

    public SystemAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(SystemAdmin admin) {
        this.admin = admin;
    }

    public static Trip tripMenu(Vehicle foundVe) throws IOException {
        String action;
        byte actionNum;
        boolean isRunning = true;
        Trip chosenTrip = null;
        System.out.println("--------------------TRIP MENU--------------------");
        while (isRunning) {
            System.out.println("1. Choose a trip related");
            System.out.println("2. Exit Trip Menu");
            System.out.println("--------------------------------------------------");
            System.out.println("Enter your action: ");
            Scanner sc = new Scanner(System.in);
            action = sc.nextLine();
            try {
                actionNum = Byte.parseByte(action);
                switch (actionNum) {
                    case 1 -> {
                        System.out.println();
                        System.out.println("All Trip Relate");
                        int order = 0;
                        ArrayList<Trip> tripListRelate = LoadDataBase.findTrip(foundVe);
                        for ( Trip tr : tripListRelate) {
                            System.out.printf("\n %s: %s \n", order, tr);
                            order++;
                        }
                        System.out.println("Choose a trip");
                        int orderTrip = sc.nextInt();
                        chosenTrip =  tripListRelate.get(orderTrip);
                    }
                    case 2 -> {
                        isRunning = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        return chosenTrip;
    }

    @Override
    public String toString() {
        return "AdminInterface{" +
                "admin=" + admin +
                '}';
    }

    public static void manageVehicles() throws IOException {
        System.out.println("1. Create Vehicle");
        System.out.println("2. Update Vehicle");
        System.out.println("3. Delete Vehicle");
        System.out.println("4. View Vehicles");
        System.out.println("5. Move Vehicle");
        System.out.println("6. Load Container");
        System.out.println("7. Unload Container");
        System.out.println("8. Refuel Vehicle");
        System.out.println("9. Return to Admin Menu");
        System.out.println("Enter your action: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left over

        switch (choice) {
            case 1 -> {
                System.out.println("Enter vehicle ID: ");
                String vehicleId = scanner.nextLine();
                System.out.println("Enter vehicle name: ");
                String name = scanner.nextLine();
                System.out.println("Enter current fuel: ");
                double currentFuel = scanner.nextDouble();
                System.out.println("Enter fuel capacity: ");
                double fuelCapacity = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter 1 in 4 vehicle's types (Basic, Reefer, Tanker, Ship): ");
                String type = scanner.nextLine();
                System.out.println("Enter id current port for this vehicle: ");
                String curPortID = scanner.nextLine();
                Port p = LoadDataBase.findPort(curPortID);
                if(type.equals("basic")) LoadDataBase.vehicleList.add(new BasicTruck(vehicleId, name, currentFuel, fuelCapacity, p));
                else if(type.equals("reefer")) LoadDataBase.vehicleList.add(new ReeferTruck(vehicleId, name, currentFuel, fuelCapacity, p));
                else if(type.equals("tanker")) LoadDataBase.vehicleList.add(new TankerTruck(vehicleId, name, currentFuel, fuelCapacity, p));
                else if(type.equals("ship")) LoadDataBase.vehicleList.add(new Ship(vehicleId, name, currentFuel, fuelCapacity, p));
                else System.out.println("Invalid type");
            }

            case 2 -> {
                System.out.println("Enter vehicle ID to update: ");
                String vehicleId = scanner.nextLine();
                Vehicle curVe = LoadDataBase.findVehicle(vehicleId);
                if (curVe == null) {
                    System.out.println("Vehicle doesn't existed in database");
                } else {
                    System.out.println("Enter new vehicle name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter new current fuel: ");
                    double currentFuel = scanner.nextDouble();
                    System.out.println("Enter new fuel capacity: ");
                    double fuelCapacity = scanner.nextDouble();
                    System.out.println("Enter id port: ");
                    String curPortID = scanner.nextLine();
                    Port p = LoadDataBase.findPort(curPortID);
                    curVe.updateVehicle(name, currentFuel, fuelCapacity, p);
                }

            }
            case 3 -> {
                System.out.println("Enter vehicle ID to delete: ");
                String vehicleId = scanner.nextLine();
                Vehicle foundVe = LoadDataBase.findVehicle(vehicleId);
                LoadDataBase.vehicleList.remove(foundVe);
            }
            case 4 -> {
                System.out.println("View All Vehicles");
                for(Vehicle ve: LoadDataBase.vehicleList) {
                    System.out.println(ve);
                }
            }
            case 5 -> {
                System.out.println("Enter vehicle ID to move: ");
                String vehicleId = scanner.nextLine();
                Vehicle foundVe = LoadDataBase.findVehicle(vehicleId);
                Trip chosenTrip = tripMenu(foundVe);
                System.out.println(chosenTrip);
                if(chosenTrip != null) {
                    if(foundVe.availableToMove(chosenTrip)){
                        System.out.println("available to move and moving vehicle.....");
                    } else System.out.println("Error in available to move");
                } else System.out.println("Error in get chosen Trip");

            }
            case 6 -> {
                ArrayList<Container> listToLoad = new ArrayList<>();
                System.out.println("Enter container IDs to load (Each parameter is splitted by ','): ");
                String[] containerIDs = scanner.nextLine().split(",");
                for (String conID: containerIDs) {
                    listToLoad.add(LoadDataBase.findContainer(conID));
                }
                System.out.println("Enter vehicle ID to for load: ");
                String vehicleID = scanner.nextLine();
                Vehicle foundVe = LoadDataBase.findVehicle(vehicleID);
                for ( Container c: listToLoad ) {
                    foundVe.loadContainer(c);
                }
            }
            case 7 -> {
                ArrayList<Container> listToUnload = new ArrayList<>();
                System.out.println("Enter container IDs to unload (Each parameter is splitted by ','): ");
                String[] containerIDs = scanner.nextLine().split(",");
                for (String conID: containerIDs) {
                    listToUnload.add(LoadDataBase.findContainer(conID));
                }
                System.out.println("Enter vehicle ID to for unload: ");
                String vehicleID = scanner.nextLine();
                Vehicle foundVe = LoadDataBase.findVehicle(vehicleID);
                for ( Container c: listToUnload ) {
                    foundVe.unloadContainer(c);
                }
            }
            case 8 -> {
                boolean retry = true;
                System.out.println("Enter vehicle ID ro refuel: ");
                String vehicleID = scanner.nextLine();
                Vehicle foundVe = LoadDataBase.findVehicle(vehicleID);
                while(retry) {
                    System.out.println("Enter amount to refuel: ");
                    double refuelAmt = scanner.nextDouble();
                    if (refuelAmt > foundVe.getCapacityFuel()) {;
                        retry = true;
                    } else {
                        foundVe.setCurrentFuel(refuelAmt);
                        System.out.println("Successfully refuel");
                        retry = false;
                    }
                }
            }
            case 9 -> {
                adminMenu();
            }
            default -> {
                System.out.println("Invalid action!");
            }
        }
    }
    public static void managePort() throws IOException {
        System.out.println("1. Add Port");
        System.out.println("2. Update Port");
        System.out.println("3. Delete Port");
        System.out.println("4. View Ports");
        System.out.println("5. Return to Admin Menu");
        System.out.println("Enter your action: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left over
        switch (choice) {
            case 1 -> {
                System.out.println("Enter pNum(ID): ");
                String pNum = scanner.nextLine();
                System.out.println("Enter Port Name: ");
                String pName = scanner.nextLine();
                System.out.println("Enter Port Capacity: ");
                double capacity = scanner.nextDouble();
                System.out.println("Enter Port Landing: ");
                boolean landing = scanner.nextBoolean();
                System.out.println("Enter Port latitude: ");
                double latitude = scanner.nextDouble();
                System.out.println("Enter Port longitude: ");
                double longitude = scanner.nextDouble();
                LoadDataBase.portList.add(new Port(pNum, pName, capacity, landing, latitude, longitude));

            }
            case 2 -> {
                System.out.println("Enter pNum(ID) to update: ");
                String pNum = scanner.nextLine();
                Port cuPort = LoadDataBase.findPort(pNum);
                if (cuPort == null) {
                    System.out.println("Port doesn't existed in database");
                } else {
                    System.out.println("Enter Port Name: ");
                    String pName = scanner.nextLine();
                    System.out.println("Enter Port Capacity: ");
                    double capacity = scanner.nextDouble();
                    System.out.println("Enter Port Landing: ");
                    boolean landing = scanner.nextBoolean();
                    System.out.println("Enter Port latitude: ");
                    double latitude = scanner.nextDouble();
                    System.out.println("Enter Port longitude: ");
                    double longitude = scanner.nextDouble();
                    cuPort.updatePort(pName, capacity, landing, latitude, longitude);
                }
            }
            case 3 -> {
                System.out.println("Enter Port ID to delete: ");
                String portId = scanner.nextLine();
                LoadDataBase.portList.remove(LoadDataBase.findPort(portId));
            }
            case 4 -> {
                for (Port p : LoadDataBase.portList) {
                    System.out.println(p);
                }
            }
            case 5 -> {
                System.out.println("Returning to Admin Menu.");
            }
        }
    }
}
