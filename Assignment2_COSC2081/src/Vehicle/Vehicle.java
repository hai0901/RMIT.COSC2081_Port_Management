package Vehicle;

import Container.*;
import Port.*;

import java.io.IOError;
import java.util.ArrayList;

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

    public void moveAbleNewPort(Trip tr) {
        boolean landingAble = tr.getArrivalPort().isLanding();
        boolean comingPort = tr.getArrivalPort().loadContainertoPort(this);
        double totalMovingConsumption = this.getTotalConsumption(tr.getArrivalPort());
        if (this.getCurrentFuel() < totalMovingConsumption || landingAble || comingPort) {
            tr.setStatus(false);
            this.setCurrentPort(tr.getDeparturePort());
            tr.getArrivalPort().removeVehicle(this);
            System.out.println("This vehicle doesn't have enough fuel");
        } else {
            tr.setStatus(true);
            this.setCurrentPort(tr.getArrivalPort());
            tr.getArrivalPort().addVehicle(this);
            this.setCurrentFuel(this.getCurrentFuel() - totalMovingConsumption);
            System.out.println("Successfully move to arrival port");
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
}
