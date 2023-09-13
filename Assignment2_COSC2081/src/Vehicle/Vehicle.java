
package Vehicle;
import Port.Location;


import Container.Container;
import Port.Port;
import Container.DryStorage;
public class Vehicle {

    private String name;
    private double currentFuel;
    private double capacityFuel;
    private Port currentPort;
    private int container;
    private String vehID;
    private int carryingCapacity;
    private int totalContainer;
    private int dryStorageContainers;
    private int openTopContainers;
    private int openSideContainers;
    private int refrigeratedContainers;
    private int liquidContainers;
    private Location location;



    public Vehicle(String name, double currentFuel, double capacityFuel, Port currentPort, int container, String vehID, int carryingCapacity) {
        this.name = name;
        this.currentFuel = currentFuel;
        this.capacityFuel = capacityFuel;
        this.currentPort = currentPort;
        this.container = container;
        this.vehID = vehID;
        this.carryingCapacity = carryingCapacity;
        this.totalContainer=0;//Default number of container is zero
    }

    public String getName() {
        return name;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getCapacityFuel() {
        return capacityFuel;
    }

    public Port getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(Port currentPort) {
        this.currentPort = currentPort;
    }

    public int getContainer() {
        return container;
    }

    public void setContainer(int container) {
        this.container = container;
    }

    public String getVehID() {
        return vehID;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public void refuel(){
        currentFuel=capacityFuel;
        //set the current fuel level to maximum capacity
        System.out.println(name+"has been fully refueled");
    }

}
