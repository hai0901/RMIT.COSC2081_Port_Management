/*
package Port;

import Vehicle.Vehicle;

import java.awt.Container;
import java.util.ArrayList;

public class Port {
    */
/****************
     * Set variable.*
     ****************//*


    private String pNum; //port's number
    private String pName; //port's name
    private double pCapacity; //port's capacity
    private boolean landing; //port's landing ability
    private Location location; // the location
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Container> containers;
    private ArrayList<Trip> trips;
    private int maxTankerTruckSlots;
    private int maxBasicTruckSlots;
    private int maxReeferTruckSlots;
    private int maxShipSlots;

    public Port(String pNum, String pName, double pCapacity, boolean landing, Location location, ArrayList<Vehicle> vehicles, ArrayList<Container> containers, ArrayList<Trip> trips ,int maxTankerTruckSlots, int maxBasicTruckSlots, int maxReeferTruckSlots, int maxShipSlots
    ) {
        this.pNum = pNum;
        this.pName = pName;
        this.pCapacity = pCapacity;
        this.landing = landing;
        this.location = location;
        this.vehicles = vehicles;
        this.containers = containers;
        this.trips = trips;
        this.maxTankerTruckSlots = maxTankerTruckSlots;
        this.maxBasicTruckSlots = maxBasicTruckSlots;
        this.maxReeferTruckSlots = maxReeferTruckSlots;
        this.maxShipSlots = maxShipSlots;
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

    public void setLanding(boolean landing) {
        this.landing = landing;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void setContainers(ArrayList<Container> containers) {
        this.containers = containers;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }
    public void addContainer(Container container){
        containers.add(container);
    }
    public void removeContainer(Container container){
        container.remove(container);
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }

    public double getDistanceOtherPort(Port otherPort){
        return location.calculateDistance(otherPort.getLocation());
    }

    public void setMaxSlots(int maxTankerTruckSlots, int maxBasicTruckSlots, int maxReeferTruckSlots, int maxShipSlots) {
        this.maxTankerTruckSlots = maxTankerTruckSlots;
        this.maxBasicTruckSlots = maxBasicTruckSlots;
        this.maxReeferTruckSlots = maxReeferTruckSlots;
        this.maxShipSlots = maxShipSlots;
    }
    /*
    // Method to check if there are enough slots for a TankerTruck
    public boolean checkTankerTruckSlots() {
        int currentTankerTruckCount = countVehiclesOfType(TankerTruck.class);
        return currentTankerTruckCount < maxTankerTruckSlots;
    }

    // Method to check  slots for a BasicTruck
    public boolean checkBasicTruckSlots() {
        int currentBasicTruckCount = countVehiclesOfType(BasicTruck.class);
        return currentBasicTruckCount < maxBasicTruckSlots;
    }

    // Method to check slots for a ReeferTruck
    public boolean checkReeferTruckSlots() {
        int currentReeferTruckCount = countVehiclesOfType(ReeferTruck.class);
        return currentReeferTruckCount < maxReeferTruckSlots;
    }

    // Method to check slots for a Ship
    public boolean checkShipSlots() {
        int currentShipCount = countVehiclesOfType(Ship.class); mot vai ly do nao do thi no ko nhan ra may cai class abstract idk man
        return currentShipCount < maxShipSlots; khong xong phan veh cung kho lam lam huhu
    } */

    // Method to count vehicles of a specific type
    private int countVehiclesOfType(Class<? extends Vehicle> vehicleClass) {
        int count = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicleClass.isInstance(vehicle)) {
                count++;
            }
        }
        return count;
    }



}*/
