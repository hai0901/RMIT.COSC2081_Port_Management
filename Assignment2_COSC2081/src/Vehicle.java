public class Vehicle {
    /****************
     * Set variable.*
     ****************/
    private String name;
    private double currentFuel;
    private double capacityFuel;
    private Port currentPort;
    private int container;
    private String vehID;
    private int carryingCapacity;

    public Vehicle(String name, double currentFuel, double capacityFuel, Port currentPort, int container, String vehID, int carryingCapacity) {
        this.name = name;
        this.currentFuel = currentFuel;
        this.capacityFuel = capacityFuel;
        this.currentPort = currentPort;
        this.container = container;
        this.vehID = vehID;
        this.carryingCapacity = carryingCapacity;
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

    /****************
     * Set method.*
     ****************/
}
