package Vehicle;

import Container.*;
import Port.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

    private String vehID;
    private String name;
    private double currentFuel;
    private double capacityFuel;
    private double carryingCapacity;
    private Port currentPort;
    private ArrayList<Container> carryingContainers = new ArrayList<>();


    public Vehicle(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        this.vehID = vehID;
        this.name = name;
        this.currentFuel = currentFuel;
        this.capacityFuel = capacityFuel;
        this.currentPort = currentPort;
        this.carryingCapacity = getAllContainerWeight();
    }
    private static final String VEHICLE_FILE = "./DataSource/vehicle.txt";

    public static void addVehicle(String vehicleId, String name, double currentFuel, double fuelCapacity) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(VEHICLE_FILE, true));
        writer.write(vehicleId + "," + name + "," + currentFuel + "," + fuelCapacity + ",null\n");
        writer.close();
    }

    public static List<String> viewVehicles() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(VEHICLE_FILE));
        List<String> vehicles = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            vehicles.add(line);
        }
        reader.close();
        return vehicles;
    }

    public void updateVehicle(String name, double currentFuel, double fuelCapacity, Port currentPort) throws IOException {
        this.setName(name);
        this.setCurrentFuel(currentFuel);
        this.setCapacityFuel(fuelCapacity);
        this.setCurrentPort(currentPort);
    }

    public static void deleteVehicle(String vehicleId) throws IOException {
        List<String> vehicles = viewVehicles();
        BufferedWriter writer = new BufferedWriter(new FileWriter(VEHICLE_FILE));
        for (String vehicle : vehicles) {
            if (!vehicle.startsWith(vehicleId)) {
                writer.write(vehicle + "\n");
            }
        }
        writer.close();
    }

   /* public static void main(String[] args) throws IOException {
        // Example usage:
        addVehicle("tr-0005", "testtruck", 300, 900);
        List<String> vehiclesAfterAdd = viewVehicles();
        updateVehicle("tr-0005", "updatedtruck", 350, 900);
        List<String> vehiclesAfterUpdate = viewVehicles();
        deleteVehicle("tr-0005");
        List<String> vehiclesAfterDelete = viewVehicles();

        System.out.println(vehiclesAfterAdd);
        System.out.println(vehiclesAfterUpdate);
        System.out.println(vehiclesAfterDelete);
    }*/
    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getCapacityFuel() {
        return capacityFuel;
    }

    public void setCapacityFuel(double capFuel) { this.capacityFuel = capFuel; }

    public Port getCurrentPort() {
        return this.currentPort;
    }

    public void setCurrentPort(Port currentPort) {
        this.currentPort = currentPort;
    }

    public String getVehID() {
        return vehID;
    }

    public void setVehID(String vehID) { this.vehID = vehID; }

    public ArrayList<Container> getCarryingContainers() {
        return carryingContainers;
    }

    public void setCarryingContainers(ArrayList<Container> carryingContainers) {
        this.carryingContainers = carryingContainers;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getAllContainerWeight() {
        double totalCapacity = 0;
        for ( Container c : carryingContainers) {
            totalCapacity +=  c.getWeight();
        }
        return totalCapacity;
    }

    public ArrayList<Container> getAllContainer() {
        return this.carryingContainers;
    }

    public int countTotalContainer() {
        return carryingContainers.size();
    }

    public void unloadContainer (Container co) {
        boolean match = false;
        for( Container c : this.carryingContainers ) {
            if( c.equals(co) ) {
                this.carryingContainers.remove(c);
                match = true;
                break;
            }
        }
        if (match) System.out.println("Unload container successfully");
        else System.out.println("This container hasn't loaded yet");
        this.updateContainerCounts();
    }

    public abstract void moveAbleNewPort(Trip tr);

    public boolean availableToMove(Trip tr) {
        if(tr.getDeparturePort().equals(this.currentPort)) {
            this.moveAbleNewPort(tr);
            return true;
        } else if (this.currentPort == null) {
            this.moveAbleNewPort(tr);
            return true;
        } else {
            System.out.println("This vehicle is on another port or this trip may be old");
            return false;
        }
    }

    public void refuel(double currentFuel) {
        this.setCurrentFuel(currentFuel);
    }

    public abstract void getAllSpecificContainerDetail();
    public abstract void updateContainerCounts();
    public abstract void loadContainer (Container co);
    public abstract double getTotalConsumption(Port any);

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehID='" + vehID + '\'' +
                ", name='" + name + '\'' +
                ", currentFuel=" + currentFuel +
                ", capacityFuel=" + capacityFuel +
                ", carryingCapacity=" + carryingCapacity +
                '}';
    }

    public void addFuel(double fuelAmount) {
        // Ensure we don't overfill the vehicle.
        if (this.currentFuel + fuelAmount <= this.capacityFuel) {
            this.currentFuel += fuelAmount;
        } else {
            this.currentFuel = this.capacityFuel;  // Fill to max capacity if fuelAmount is excessive.
        }
    }


}
