package FileHandling;

import Container.*;
import Vehicle.*;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import Port.*;

public class LoadDataBase {
    public static ArrayList<Container> containerList = new ArrayList<>();
    public static ArrayList<Vehicle> vehicleList = new ArrayList<>();
    public static ArrayList<Port> portList = new ArrayList<>();
    public static ArrayList<Trip> tripList = new ArrayList<>();


    public static void createContainer() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/dContainer.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/otContainer.txt"));
        BufferedReader reader3 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/osContainer.txt"));
        BufferedReader reader4 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/reContainer.txt"));
        BufferedReader reader5 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/lqContainer.txt"));
        for(String line: reader1.lines().toList()) {
            String[] parts = line.split(",");
            Container con = new DryStorage(parts[0], Double.parseDouble(parts[1]));
            containerList.add(con);
        }
        for(String line: reader2.lines().toList()) {
            String[] parts = line.split(",");
            Container con = new OpenTop(parts[0], Double.parseDouble(parts[1]));
            containerList.add(con);
        }
        for(String line: reader3.lines().toList()) {
            String[] parts = line.split(",");
            Container con = new OpenSide(parts[0], Double.parseDouble(parts[1]));
            containerList.add(con);
        }
        for(String line: reader4.lines().toList()) {
            String[] parts = line.split(",");
            Container con = new Refrigerated(parts[0], Double.parseDouble(parts[1]));
            containerList.add(con);
        }
        for(String line: reader5.lines().toList()) {
            String[] parts = line.split(",");
            Container con = new Liquid(parts[0], Double.parseDouble(parts[1]));
            containerList.add(con);
        }
        System.out.println("End create containerList");
    }
    public static void createVehicle() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/bsTruck.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/refTruck.txt"));
        BufferedReader reader3 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/tankTruck.txt"));
        BufferedReader reader4 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/ship.txt"));
        for(String line: reader1.lines().toList()) {
            String[] parts = line.split(",");
            Vehicle ve = new BasicTruck(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), null);
            vehicleList.add(ve);
        }
        for(String line: reader2.lines().toList()) {
            String[] parts = line.split(",");
            Vehicle ve = new ReeferTruck(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), null);
            vehicleList.add(ve);
        }
        for(String line: reader3.lines().toList()) {
            String[] parts = line.split(",");
            Vehicle ve = new TankerTruck(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), null);
            vehicleList.add(ve);
        }
        for(String line: reader4.lines().toList()) {
            String[] parts = line.split(",");
            Vehicle ve = new Ship(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), null);
            vehicleList.add(ve);
        }
        System.out.println("End create vehicleList");
    }
    public static void createPort() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/port.txt"));
        for(String line: reader1.lines().toList()) {
            String[] parts = line.split(",");
            Port p = new Port(parts[0], parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]));
            portList.add(p);
        }
        System.out.println("End create portList");
    }
    public static void createTrip() throws FileNotFoundException {
        BufferedReader reader1 = new BufferedReader(new FileReader("Assignment2_COSC2081/src/DataSource/trip.txt"));
        Vehicle vehInTrip = null;
        Port departPort = null;
        Port arrPort = null;
        for(String line: reader1.lines().toList()) {
            String[] parts = line.split(",");
            for (Vehicle ve : vehicleList) {
                if(parts[0].equals(ve.getVehID())) {
                    vehInTrip = ve;
                }
            }
            for (Port p: portList) {
                if(parts[3].equals(p.getpNum())) {
                    departPort = p;
                }
                if(parts[4].equals(p.getpNum())) {
                    arrPort = p;
                }
            }
            if (vehInTrip != null && departPort != null && arrPort != null) {
                Trip tr = new Trip(vehInTrip, parts[1], parts[2], departPort, arrPort,Boolean.parseBoolean(parts[5]));
                tripList.add(tr);
            } else System.out.println("error in looping to get vehicle, departPort, arrPort");

        }
        System.out.println("End create tripList");
    }
    public static void createAll() throws FileNotFoundException {
        try {
            createContainer();
            createVehicle();
            createPort();
            createTrip();
        } catch (FileNotFoundException e) {
            System.out.println("File error");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        createAll();
        System.out.println(containerList);
        System.out.println(vehicleList);
        System.out.println(portList);
        System.out.println(tripList);
    }

    public static Port findPort(String portID) {
        return LoadDataBase.portList.stream().filter(port -> port.getpNum().equals(portID)).findFirst().orElse(null);
    }
    public static Vehicle findVehicle(String vehicleID) {
        return LoadDataBase.vehicleList.stream().filter(vehicle -> vehicle.getVehID().equals(vehicleID)).findFirst().orElse(null);
    }
    public static Container findContainer(String containerID) {
        return LoadDataBase.containerList.stream().filter(container -> container.getId().equals(containerID)).findFirst().orElse(null);
    }
    public static ArrayList<Trip> findTrip(Vehicle ve) {
        return  LoadDataBase.tripList.stream().filter(trip -> trip.getVehicle().equals(ve)).collect(Collectors.toCollection(ArrayList<Trip>::new));
    }


}
