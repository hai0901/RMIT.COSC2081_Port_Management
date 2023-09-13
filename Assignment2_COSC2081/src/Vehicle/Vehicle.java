package Vehicle;

import Container.Container;
import Port.Port;
import Container.DryStorage;
import Container.OpenTop;
import Container.Liquid;
import Container.OpenSide;
import Container.Refrigerated;
import Port.Location;
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
    //This method is used to load the container
    public void loadContainer(Container container){
        totalContainer++;
        if (container instanceof DryStorage){
            dryStorageContainers++;
        }
        if (container instanceof OpenTop){
            openTopContainers++;
        }
        if (container instanceof OpenSide){
            openSideContainers++;
        }
        if (container instanceof Refrigerated){
            refrigeratedContainers++;
        }
        if (container instanceof Liquid){
            liquidContainers++;
        }
    }
//This method is used to unload the container
    public void unloadContainer(Container container){
        totalContainer--;
        if (container instanceof DryStorage){
            dryStorageContainers--;
        }
        if (container instanceof OpenTop){
            openTopContainers--;
        }
        if (container instanceof OpenSide){
            openSideContainers--;
        }
        if (container instanceof Refrigerated){
            refrigeratedContainers--;
        }
        if (container instanceof Liquid){
            liquidContainers--;
        }
    }
    private double getFuelConsumptionRateShip(Container container) {
        if (container instanceof DryStorage){
            return 3.5;
        }
        if (container instanceof OpenTop){
            return 2.8;
        }
        if (container instanceof OpenTop){
            return 2.7;
        }
        if (container instanceof Refrigerated){
            return 4.5;
        }
        if (container instanceof Liquid){
            return 4.8;
        }
        return 0.0;
    }
    private double getFuelConsumptionRateTruck(Container container) {
        if (container instanceof DryStorage){
            return 4.6;
        }
        if (container instanceof OpenTop){
            return 3.2;
        }
        if (container instanceof OpenTop){
            return 3.2;
        }
        if (container instanceof Refrigerated){
            return 5.4;
        }
        if (container instanceof Liquid){
            return 5.3;
        }
        return 0.0;
    }
    private double calculateFuelConsumption(Port destinationPort,Container container){
        double fuelConsumptionRate;
        if (this instanceof Ship) {
            fuelConsumptionRate = getFuelConsumptionRateShip(container);
        } else if (this instanceof Truck) {

            fuelConsumptionRate = getFuelConsumptionRateTruck(container);
        } else {
            fuelConsumptionRate = 1; //The default value for other vehicles if needed
        }
        double fuelConsumption = fuelConsumptionRate * location.calculateDistance(destinationPort.getLocation());

        return fuelConsumption;

    }
    public void move(Port destinationPort,Container container) {
        double fuelConsumption = calculateFuelConsumption(destinationPort, container);
        if (currentFuel >= fuelConsumption) {
            currentFuel -= fuelConsumption;
            currentPort = destinationPort;
            System.out.println(name + "has moved to" + destinationPort.getpName());
        } else {
            System.out.println(name + "does not have enough fuel to move to" + destinationPort.getpName());
        }
    }
    

}
