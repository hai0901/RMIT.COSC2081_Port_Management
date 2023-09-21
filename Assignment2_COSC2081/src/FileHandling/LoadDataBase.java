package FileHandling;

import Vehicle.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Port.*;

public class LoadDataBase {
    public static ArrayList<String> containerList = new ArrayList<String>();
    public static ArrayList<Vehicle> vehicleList = new ArrayList<>();
    public static ArrayList<Port> portList = new ArrayList<>();
    public static ArrayList<Trip> tripList = new ArrayList<>();


    public static void createContainer() {
        // read file con.txt
        // 1 line = 1 container
        // add container to containerlist
        File.readFromFileAndCreateList("Assignment2_COSC2081/src/container.txt", containerList);

    }
    public static void createVehicle() {
        // read file veh.txt
        // 1 line = 1 veh
        // add container to vehlist
        File.readFromFileAndCreateList("Assignment2_COSC2081/src/vehicle.txt", vehicleList);
    }
    public static void createPort() {
        // read file port.txt
        // 1 line = 1 port
        // add container to portlist
        File.readFromFileAndCreateList("Assignment2_COSC2081/src/port.txt", portList);
    }
    public static void createTrip() {
        // read file trip.txt
        // 1 line = 1 trip
        // add container to triplist
        File.readFromFileAndCreateList("Assignment2_COSC2081/src/trip.txt", tripList);
    }
    public static void createAll() {
        createContainer();
        createVehicle();
        createPort();
        createTrip();
    }
    //file port
    //P001,USA,2000,landing(true,false),lat,lon
    //file trip
    //tr001,departDate,arrivalDate,departPortID,arrivalPortID,status(true, false, null)

    //public static Port findPortByPortId(String portId) {
    //    for (Port port : portList) {
    //        if (port.getpNum().equals(portId)) {
    //            return port;
    //        }
    //    }
    //
    //    return null;
    //}
public static void main(String[] args) {
    createContainer();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter container ID: ");
    String containerId = scanner.nextLine();
    // find container by containerId
    for (String container : containerList) {
        if (container.contains(containerId)) {
            System.out.println(container);
        }
    }

}
}
