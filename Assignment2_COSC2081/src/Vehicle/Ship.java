package Vehicle;

import Port.Port;
import Vehicle.Vehicle;

public class Ship extends Vehicle {
    public Ship(String name, double currentFuel, double capacityFuel, Port currentPort, int container, String vehID, int carryingCapacity) {
        super(name, currentFuel, capacityFuel, currentPort, container, vehID, carryingCapacity);
    }
}
