package Vehicle;

import Port.Port;

public class TankerTruck extends Truck{
    public TankerTruck(String name, double currentFuel, double capacityFuel, Port currentPort, int container, String vehID, int carryingCapacity) {
        super(name, currentFuel, capacityFuel, currentPort, container, vehID, carryingCapacity);
    }
}
