package Interface;
import FileHandling.*;

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

        FileHandling.File.writeToFile("Assignment2_COSC2081/src/DataSource/manager.txt", newManager.toString(), true);
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
            System.out.println("9. Manage Trip");

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
                                FileHandling.File.updateToFile("Assignment2_COSC2081/src/DataSource/manager.txt", portManagerList.getPortManagersList());
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
                        FileHandling.File.updateToFile("Assignment2_COSC2081/src/DataSource/manager.txt", portManagerList.getPortManagersList());
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
                    case 7 -> {
                        manageContainers();
                    }

                    case 8 -> {
                        managePort();
                    }
                    case 9 -> {
                        manageTrip();
                    }

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
                scanner.nextLine(); // Consume newline

                System.out.println("Enter 1 of 5 container type (Drystorage, Opentop, Openside, Liquid, Refrigerated): ");
                String type = scanner.nextLine();

                Container newContainer = null;
                String deletionFilePath = "";

                switch (type.toLowerCase()) {
                    case "drystorage":
                        newContainer = new DryStorage(containerId, weight);
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/dContainer.txt";
                        break;
                    case "refrigerated":
                        newContainer = new Refrigerated(containerId, weight);
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/reContainer.txt";
                        break;
                    case "opentop":
                        newContainer = new OpenTop(containerId, weight);
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/otContainer.txt";
                        break;
                    case "openside":
                        newContainer = new OpenSide(containerId, weight);
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/osContainer.txt";
                        break;
                    case "liquid":
                        newContainer = new Liquid(containerId, weight);
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/lqContainer.txt";
                        break;
                    default:
                        System.out.println("Invalid type container");
                }

                if (newContainer != null) {
                    LoadDataBase.containerList.add(newContainer);
                    File.fileWriteContainer(LoadDataBase.containerList);
                    File.scheduleLineDeletion(deletionFilePath, File.conData, 1);
                }

            }
            case 2 -> {
                System.out.println("Enter container ID to update: ");
                String containerId = scanner.nextLine();
                System.out.println("Enter new container weight: ");
                double weight = scanner.nextDouble();
                LoadDataBase.findContainer(containerId).setWeight(weight);
                File.fileWriteContainer(LoadDataBase.containerList);
            }
            case 3 -> {
                System.out.println("Enter container ID to delete: ");
                String containerId = scanner.nextLine();
                LoadDataBase.containerList.remove(LoadDataBase.findContainer(containerId));
                File.fileWriteContainer(LoadDataBase.containerList);
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

    public static void manageTrip() throws IOException {
        System.out.println("1. Make Trip");
        System.out.println("2. Update Trip");
        System.out.println("3. Delete Trip");
        System.out.println("4. View Trip");
        System.out.println("5. Return to Admin Menu");
        System.out.println("Enter your action: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter departure date (DD-MM-YYYY): ");
                String departureDate = scanner.nextLine();
                System.out.println("Enter arrival date (DD-MM-YYYY): ");
                String arrivalDate = scanner.nextLine();
                System.out.println("Enter departure port ID: ");
                String departurePortID = scanner.nextLine();
                System.out.println("Enter arrival port ID: ");
                String arrivalPortID = scanner.nextLine();
                System.out.println("Enter trip status ( true/false/null ): ");
                String tripStatus = scanner.nextLine();
                System.out.println("Enter vehicle ID: ");
                String vehicleId = scanner.nextLine();

                Boolean trStatus = null;
                if ( tripStatus.equals("true")) {
                    trStatus = true;
                }
                if ( tripStatus.equals("false")) {
                    trStatus = false;
                }
                Vehicle vehicle = LoadDataBase.findVehicle(vehicleId);
                if (vehicle == null) {
                    System.out.println("Vehicle not found.");
                    return; // Exit the case
                }

                Port departurePort = LoadDataBase.findPort(departurePortID);
                Port arrivalPort = LoadDataBase.findPort(arrivalPortID);

                if (departurePort == null || arrivalPort == null) {
                    System.out.println("One or more ports not found.");
                    return; // Exit the case
                }



                Trip newTrip = new Trip(
                        vehicle,
                        departureDate,
                        arrivalDate,
                        departurePort,
                        arrivalPort,
                        trStatus
                );
                LoadDataBase.tripList.add(newTrip);
                System.out.println(LoadDataBase.tripList);

                File.fileWriteTrip(LoadDataBase.tripList);
                File.scheduleLineDeletion("Assignment2_COSC2081/src/DataSource/trip.txt", File.tripData, 1);
                System.out.println("Trip created successfully!");
            }
            case 2 -> {
                System.out.println("Enter vehicle ID to update Trip: ");
                String vehicleId = scanner.nextLine();
                Vehicle vehicleToUpdate = LoadDataBase.findVehicle(vehicleId);

                if (vehicleToUpdate != null) {
                    // Find trips related to the specified vehicle
                    ArrayList<Trip> tripListRelate = LoadDataBase.findTrip(vehicleToUpdate);

                    if (!tripListRelate.isEmpty()) {
                        // Display the list of related trips
                        System.out.println("All Trip Related:");
                        int order = 0;
                        for (Trip tr : tripListRelate) {
                            System.out.printf("%s: %s \n", order, tr);
                            order++;
                        }

                        System.out.println("Choose a trip to update (Enter the number):");
                        int orderTrip = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (orderTrip >= 0 && orderTrip < tripListRelate.size()) {
                            Trip tripToUpdate = tripListRelate.get(orderTrip);

                            System.out.println("Enter new departure date (DD-MM-YYYY): ");
                            String newDepartureDate = scanner.nextLine();
                            System.out.println("Enter new arrival date (DD-MM-YYYY): ");
                            String newArrivalDate = scanner.nextLine();
                            System.out.println("Enter new departure port ID: ");
                            String newDeparturePortID = scanner.nextLine();
                            System.out.println("Enter new arrival port ID: ");
                            String newArrivalPortID = scanner.nextLine();

                            Port newDeparturePort = LoadDataBase.findPort(newDeparturePortID);
                            Port newArrivalPort = LoadDataBase.findPort(newArrivalPortID);

                            if (newDeparturePort != null && newArrivalPort != null) {
                                tripToUpdate.setDepartureDate(newDepartureDate);
                                tripToUpdate.setArrivalDate(newArrivalDate);
                                tripToUpdate.setDeparturePort(newDeparturePort);
                                tripToUpdate.setArrivalPort(newArrivalPort);

                                File.fileWriteTrip(LoadDataBase.tripList);
                                System.out.println("Trip updated successfully!");
                            } else {
                                System.out.println("One or more ports not found.");
                            }
                        } else {
                            System.out.println("Invalid trip selection.");
                        }
                    } else {
                        System.out.println("No trips found for the specified vehicle.");
                    }
                } else {
                    System.out.println("Vehicle not found.");
                }
            }
            case 3 -> {
                System.out.println("Enter vehicle ID to delete Trip: ");
                String vehicleId = scanner.nextLine();
                Vehicle vehicleToDelete = LoadDataBase.findVehicle(vehicleId);

                if (vehicleToDelete != null) {
                    // Find trips related to the specified vehicle
                    ArrayList<Trip> tripListRelate = LoadDataBase.findTrip(vehicleToDelete);

                    if (!tripListRelate.isEmpty()) {
                        // Display the list of related trips
                        System.out.println("All Trip Related:");
                        int order = 0;
                        for (Trip tr : tripListRelate) {
                            System.out.printf("%s: %s \n", order, tr);
                            order++;
                        }

                        System.out.println("Choose a trip to delete (Enter the number):");
                        int orderTrip = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (orderTrip >= 0 && orderTrip < tripListRelate.size()) {
                            Trip tripToDelete = tripListRelate.get(orderTrip);

                            LoadDataBase.tripList.remove(tripToDelete);
                            File.fileWriteTrip(LoadDataBase.tripList);
                            System.out.println("Trip deleted successfully!");
                        } else {
                            System.out.println("Invalid trip selection.");
                        }
                    } else {
                        System.out.println("No trips found for the specified vehicle.");
                    }
                } else {
                    System.out.println("Vehicle not found.");
                }
            }
            case 4 -> {
                System.out.println("List of Trips:");
                for (Trip trip : LoadDataBase.tripList) {
                    System.out.println(trip);
                }
            }
            case 5 -> {
                System.out.println("Returning to Admin Menu.");
                adminMenu();
            }
            default -> {
                System.out.println("Invalid action!");
            }
        }
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
        System.out.println("9. View detail vehicle:");
        System.out.println("10. Return to Admin Menu");
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
                String deletionFilePath = "";
                Vehicle newVehicle = null;

                switch (type.toLowerCase()) {
                    case "basic":
                        newVehicle = new BasicTruck(vehicleId, name, currentFuel, fuelCapacity, LoadDataBase.findPort(curPortID));
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/bsTruck.txt";
                        break;
                    case "reefer":
                        newVehicle = new ReeferTruck(vehicleId, name, currentFuel, fuelCapacity, LoadDataBase.findPort(curPortID));
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/refTruck.txt";
                        break;
                    case "tanker":
                        newVehicle = new TankerTruck(vehicleId, name, currentFuel, fuelCapacity, LoadDataBase.findPort(curPortID));
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/tankTruck.txt";
                        break;
                    case "ship":
                        newVehicle = new Ship(vehicleId, name, currentFuel, fuelCapacity, LoadDataBase.findPort(curPortID));
                        deletionFilePath = "Assignment2_COSC2081/src/DataSource/ship.txt";
                        break;
                    default:
                        System.out.println("Invalid type");
                }

                if (newVehicle != null) {
                    LoadDataBase.vehicleList.add(newVehicle);
                    File.fileWriteVehicle(LoadDataBase.vehicleList);
                    File.scheduleLineDeletion(deletionFilePath, File.vehData, 1);
                }
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
                    scanner.nextLine();
                    System.out.println("Enter id port: ");
                    String curPortID = scanner.nextLine();
                    Port p = LoadDataBase.findPort(curPortID);
                    curVe.updateVehicle(name, currentFuel, fuelCapacity, p);
                    File.fileWriteVehicle(LoadDataBase.vehicleList);
                }

            }
            case 3 -> {
                System.out.println("Enter vehicle ID to delete: ");
                String vehicleId = scanner.nextLine();
                Vehicle foundVe = LoadDataBase.findVehicle(vehicleId);
                LoadDataBase.vehicleList.remove(foundVe);
                File.fileWriteVehicle(LoadDataBase.vehicleList);
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
                System.out.println("Enter vehicle ID to refuel: ");
                String vehicleID = scanner.nextLine();
                Vehicle foundVe = LoadDataBase.findVehicle(vehicleID);
                while(retry) {
                    System.out.println("Enter amount to refuel: ");
                    double refuelAmt = scanner.nextDouble();
                    if (refuelAmt > foundVe.getCapacityFuel()) {
                        retry = true;
                    } else {
                        foundVe.setCurrentFuel(refuelAmt);
                        System.out.println("Successfully refuel");
                        File.fileWriteVehicle(LoadDataBase.vehicleList);
                        retry = false;
                    }
                }
            }
            case 9 -> {
                System.out.println("Enter vehicle ID to view details (or press Enter to return): ");
                String viewVehicleId = scanner.nextLine();
                if (!viewVehicleId.isEmpty()) {
                    Vehicle vehicle = LoadDataBase.findVehicle(viewVehicleId);
                    if (vehicle != null) {
                        System.out.println("Vehicle Details:");
                        System.out.println(vehicle);
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                }
            }
            case 10 -> {
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
        System.out.println("4. View Port");
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

                File.fileWritePort(LoadDataBase.portList);
                File.scheduleLineDeletion("Assignment2_COSC2081/src/DataSource/port.txt", File.portData, 1);

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

                    File.fileWritePort(LoadDataBase.portList);
                }
            }
            case 3 -> {
                System.out.println("Enter Port ID to delete: ");
                String portId = scanner.nextLine();
                LoadDataBase.portList.remove(LoadDataBase.findPort(portId));
                File.fileWritePort(LoadDataBase.portList);
            }
            case 4 -> {
                for (Port p: LoadDataBase.portList) {
                    System.out.println(p);
                }
            }
            case 5 -> {
                System.out.println("Returning to Admin Menu.");
                adminMenu();
            }
            default -> {
                System.out.println("Invalid action!");
            }
        }

    }
}
