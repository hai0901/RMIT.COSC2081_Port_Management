package Port;

import Container.Container;
import Vehicle.Vehicle;

import java.util.ArrayList;


public class Port {
    /****************
     * Set variable.*
     ****************/

    private String pNum; //port's number
    private String pName; //port's name
    private double pCapacity; //port's capacity
    private boolean landing; //port's landing ability
    private Location location; // the location
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Container> containers;
    private ArrayList<Trip> trips;


    public Port(String pNum, String pName, double pCapacity, boolean landing, Location location, ArrayList<Vehicle> vehicles, ArrayList<Container> containers, ArrayList<Trip> trips
    ) {
        this.pNum = pNum;
        this.pName = pName;
        this.pCapacity = pCapacity;
        this.landing = landing;
        this.location = location;
        this.vehicles = vehicles;
        this.containers = containers;
        this.trips = trips;

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
        containers.remove(container);
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

    public void vehicleOutPort(Vehicle vehicleToRemove) {
        // Iterate through the list to find the matching vehicle
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle currentVehicle = vehicles.get(i);

            // Check if the current vehicle matches the input vehicle
            if (currentVehicle.equals(vehicleToRemove)) {
                // Remove the matching vehicle from the list
                vehicles.remove(i);
                System.out.println("Vehicle removed from the list: " + currentVehicle);
                return; // Exit the loop once the vehicle is removed
            }
        }

        // If the input vehicle is not found in the list
        System.out.println("Vehicle not found in the list: " + vehicleToRemove);
    }

    public void vehiclesPortIn(Vehicle vehicleToAdd) {
        // Add the vehicle to the list
        vehicles.add(vehicleToAdd);
        System.out.println("Vehicle added to the list: " + vehicleToAdd);
    }

    public double getTotalContainerWeight() {
        double totalWeight = 0.0;
        for (Container container : containers) {
            totalWeight += container.getConWeight();
        }
        return totalWeight;
    }


}