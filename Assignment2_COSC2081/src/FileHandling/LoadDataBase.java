package FileHandling;

import Container.*;
import Vehicle.*;
import java.util.ArrayList;
import Port.*;

public class LoadDataBase {
    public static ArrayList<Container> containerList = new ArrayList<>();
    public static ArrayList<Vehicle> vehicleList = new ArrayList<>();
    public static ArrayList<Port> portList = new ArrayList<>();
    public static ArrayList<Trip> tripList = new ArrayList<>();
    public static void createContainer() {
        // read file con.txt
        // 1 line = 1 container
        // add container to containerlist
    }
    public static void createVehicle() {
        // read file veh.txt
        // 1 line = 1 veh
        // add container to vehlist
    }
    public static void createPort() {
        // read file port.txt
        // 1 line = 1 port
        // add container to portlist
    }
    public static void createTrip() {
        // read file trip.txt
        // 1 line = 1 trip
        // add container to triplist
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
}
