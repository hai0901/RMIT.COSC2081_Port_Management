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
    public void loadContainer(Container container){
        totalContainer++;
        if (container.getConType() == ContainerType.DRY_STORAGE){
            dryStorageContainers++;
        }
        if (container.getConType() == ContainerType.OPEN_TOP){
            openTopContainers++;
        }
        if (container.getConType() == ContainerType.OPEN_SIDE){
            openSideContainers++;
        }
        if (container.getConType() == ContainerType.REFRIGERATED){
            refrigeratedContainers++;
        }
        if (container.getConType() == ContainerType.LIQUID){
            liquidContainers++;
        }
    }
    public void unloadContainer(Container container){
        totalContainer--;
        if (container.getConType() == ContainerType.DRY_STORAGE){
            dryStorageContainers--;
        }
        if (container.getConType() == ContainerType.OPEN_TOP){
            openTopContainers--;
        }
        if (container.getConType() == ContainerType.OPEN_SIDE){
            openSideContainers--;
        }
        if (container.getConType() == ContainerType.REFRIGERATED){
            refrigeratedContainers--;
        }
        if (container.getConType() == ContainerType.LIQUID){
            liquidContainers--;
        }
    }
    public double calculateFuelConsumption(Port destinationPort,ContainerType containerType){
        double fuelConsumptionRate;
        if (this instanceof Ship) {
            fuelConsumptionRate = getFuelConsumptionRateShip(containerType);
        } else if (this instanceof Truck) {

            fuelConsumptionRate = getFuelConsumptionRateTruck(containerType);
        } else {
            fuelConsumptionRate = 1; //The default value for other vehicles if needed
        }
        double fuelConsumption = fuelConsumptionRate * location.calculateDistance(destinationPort.getLocation());

        return fuelConsumption;

    }
    private double getFuelConsumptionRateShip(ContainerType containerType) {
        switch (containerType) {
            case DRY_STORAGE:
                return 3.5;
            case OPEN_TOP:
                return 2.8;
            case OPEN_SIDE:
                return 2.7;
            case REFRIGERATED:
                return 4.5;
            case LIQUID:
                return 4.8;
            default:
                return 0.0; // Default rate for unknown type
        }
    }

    private double getFuelConsumptionRateTruck(ContainerType containerType) {
        switch (containerType) {
            case DRY_STORAGE:
                return 4.6;
            case OPEN_TOP:
                return 3.2;
            case OPEN_SIDE:
                return 3.2;
            case REFRIGERATED:
                return 5.4;
            case LIQUID:
                return 5.3;
            default:
                return 0.0; // Default rate for unknown type
        }
    }

}
