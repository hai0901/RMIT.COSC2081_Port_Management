package Port;

import Vehicle.*;
import Container.*;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Port {
    private String pNum; //port's numbe
    private String pName; //port's name
    private double pCapacity; //port's capacity
    private boolean landing; //port's landing ability
    private double latitude;
    private double longitude;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Container> containers = new ArrayList<>();
    private ArrayList<Trip> trips = new ArrayList<>();

    public Port( String pNum, String pName, double pCapacity, boolean landing, double latitude, double longitude ) {
        this.pNum = pNum;
        this.pName = pName;
        this.pCapacity = pCapacity;
        this.landing = landing;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpCapacity() {
        return pCapacity;
    }

    public void setpCapacity(double pCapacity) {
        this.pCapacity = pCapacity;
    }

    public boolean isLanding() {
        return landing;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLanding(boolean landing) {
        this.landing = landing;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

    public boolean addContainers(Container con) {
        if(this.storingCapacity() + con.getWeight() > this.pCapacity){
            System.out.println("Exceed maximum capacity to add container");
            return false;
        } else {
            this.containers.add(con);
            return true;
        }
    }

    public void addVehicle(Vehicle ve) {
        if( ve instanceof Truck && this.landing) {
            if(duplicateVe(ve)) {
                System.out.println("This truck already in this port");
            } else {
                this.vehicles.add(ve);
                ve.setCurrentPort(this);
            }
        } else if (ve instanceof Ship) {
            if(duplicateVe(ve)) {
                System.out.println("This ship already in this port");
            } else {
                this.vehicles.add(ve);
                ve.setCurrentPort(this);
            }
        } else {
            System.out.println("Error while adding vehicle");
        }
    }

    public boolean availableToAddVehicle(Vehicle vehicle) {
        if(this.storingCapacity() + vehicle.getAllContainerWeight() > this.pCapacity){
            System.out.println("Exceed maximum capacity to add vehicle");
            return false;
        } else {
            return true;
        }
    }

    public boolean duplicateVe(Vehicle ve) {
        return this.vehicles.contains(ve);
    }

    public void addTrip(Trip t) {
        if(t.getDeparturePort().equals(this) || t.getArrivalPort().equals(this)) {
            this.trips.add(t);
        } else System.out.println("This trip isn't relate to this port");
    }

    public void removeContainer(Container container){
        for (Container co : containers) {
            if (co.equals(container)) {
                this.containers.remove(co);
                break;
            }
        }
    }

    public void removeVehicle(Vehicle vehicle){
        for ( Vehicle ve : vehicles) {
            if (ve.equals(vehicle)) {
                this.vehicles.remove(ve);
                break;
            }
        }
    }

    public void removeTrip(Trip trip){
        for (Trip tr : trips) {
            if (tr.equals(trip)) {
                this.trips.remove(tr);
                break;
            }
        }
    }


    @Override
    public String toString() {
        return "Port{" +
                "pNum='" + pNum + '\'' +
                ", pName='" + pName + '\'' +
                ", pCapacity=" + pCapacity +
                ", landing=" + landing +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public double getDistanceInKm(Port any) {
        double earthRadius = 6371;

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(any.latitude);
        double lon2 = Math.toRadians(any.longitude);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        //Calculate the distance using the Haversine Formula

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = earthRadius * c;
        return distance;
    }

    public void vehicleInPort() {
        System.out.println("-------Vehicles In This Port-------");
        for(Vehicle v: this.vehicles) {
            System.out.println(v);
        }
        countVehicle();
    }

    public void containerInPort() {
        System.out.println("-------Containers In This Port-------");
        for(Container c : this.containers) {
            System.out.println(c);
        }
        countContainer();
    }

    public void tripInPort() {
        System.out.println("-------Trips In This Port-------");
        for(Trip t : this.trips) {
            System.out.println(t);
        }
        countTrip();
    }

    public double storingCapacity() {
        double storeCap = 0;
        for(Container c: this.containers) {
            storeCap += c.getWeight();
        }
        for(Vehicle v: this.vehicles) {
            storeCap += v.getAllContainerWeight();
        }
        return storeCap;
    }

    /*public boolean loadContainerToPort(Vehicle ve) {
        ArrayList<Container> arrContainer = ve.getAllContainer();
        double storingCapacity = storingCapacity();
        if (this.getpCapacity() - storingCapacity - ve.getAllContainerWeight() >= 0) {
            for (Container c: arrContainer) {
                this.addContainers(c);
                ve.unloadContainer(c);
            }
            return true;
        } else {
            System.out.println("This port is full of containers");
            return false;
        }
    }*/

    public void countContainer() {
        System.out.printf("\nTotal Containers In Port: %s\n", this.containers.size());
    }

    public void countVehicle() {
        System.out.printf("\nTotal Vehicles In Port: %s\n", this.vehicles.size());
    }

    public void countTrip() {
        System.out.printf("\nTotal Trips In Port: %s\n", this.trips.size());
    }

    public static void listTripsInPortByDay(Port port, String targetDate) {
        ArrayList<Trip> tripsByDay = new ArrayList<>();
        for (Trip trip : port.getTrips()) {
            if (trip.getArrivalDate().equals(targetDate) || trip.getDepartureDate().equals(targetDate)) {
                tripsByDay.add(trip);
            }
        }
        System.out.println("-------Trips In Port By Given Day-------");
        System.out.println(tripsByDay);
    }

    public static void listTripsInPortByDayRange(Port port, String startDate, String endDate ) throws ParseException {
        ArrayList<Trip> tripsByDayRange = new ArrayList<>();
        SimpleDateFormat sdformat = new SimpleDateFormat("dd/mm/yyyy");

        Date startFrom = sdformat.parse(startDate);
        Date endBy = sdformat.parse(endDate);

        for (Trip trip : port.getTrips()) {
            Date tripDepartDate = sdformat.parse(trip.getDepartureDate());
            Date tripAriveDate = sdformat.parse(trip.getArrivalDate());
            if (tripDepartDate.compareTo(startFrom) >= 0 && tripDepartDate.compareTo(endBy) <= 0) {
                tripsByDayRange.add(trip);
            }
            if (tripAriveDate.compareTo(startFrom) >= 0 && tripDepartDate.compareTo(endBy) <= 0) {
                tripsByDayRange.add(trip);
            }
        }

        System.out.println("-------Trips In Port By Day Range-------");
        System.out.println(tripsByDayRange);
    }


    public static List<Port> loadPortsFromFile() throws FileNotFoundException {
        java.io.File file = new java.io.File("./DataSource/port.txt");
        Scanner scanner = new Scanner(file);
        List<Port> ports = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            Port port = new Port(parts[0], parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]), Double.parseDouble(parts[4]), Double.parseDouble(parts[5]));
            ports.add(port);
        }
        scanner.close();
        return ports;
    }

    public static double getTotalFuelUsed(List<Port> ports) {
        double totalFuel = 0;
        for(Port port : ports) {
            totalFuel += port.getpCapacity();  // Using getpCapacity() method
        }
        return totalFuel;
    }

    public static String getAllPortNames(List<Port> ports) {
        StringBuilder sb = new StringBuilder();
        for(Port port : ports) {
            sb.append(port.getpName()).append(", ");  // Using getpName() method
        }
        return sb.toString();
    }

    public void getAllContainerDetailInPort() {
        for (Container c: this.containers) {
            System.out.println(c);
        }
        countContainer();
    }
    public void updatePort(String newPName, double newPCapacity, boolean newLanding, double newLatitude, double newLongitude) {
        // Update the attributes with new values
        this.pName = newPName;
        this.pCapacity = newPCapacity;
        this.landing = newLanding;
        this.latitude = newLatitude;
        this.longitude = newLongitude;
    }
}
