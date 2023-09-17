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

    public abstract void loadContainer (Container co);

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
    }

//    public void moveToPort(Trip trp) {
//        if (trp.getStatus()) {
//            System.out.println("Moved");
//            this.setCurrentPort(trp.getArrivalPort());
//        } else {
//            System.out.println("Unmoved");
//            this.setCurrentPort(trp.getDeparturePort());
//        }
//    }

    public void moveAbleNewPort(Trip tr) {
        double totalMovingConsumption = this.getTotalConsumption(tr.getArrivalPort());
        if (this.getCurrentFuel() < totalMovingConsumption) {
            tr.setStatus(false);
            this.setCurrentPort(tr.getDeparturePort());
            System.out.println("Cannot move");
        } else {
            tr.setStatus(true);
            this.setCurrentPort(tr.getArrivalPort());
            this.setCurrentFuel(this.getCurrentFuel() - totalMovingConsumption);
            System.out.println("Sucessfull move");
        }
    }

    public abstract double getTotalConsumption(Port any);

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehID='" + vehID + '\'' +
                ", name='" + name + '\'' +
                ", currentFuel=" + currentFuel +
                ", capacityFuel=" + capacityFuel +
                ", carryingCapacity=" + carryingCapacity +
                ", currentPort=" + currentPort +
                '}';
    }
}
