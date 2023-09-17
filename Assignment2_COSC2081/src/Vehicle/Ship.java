package Vehicle;

import Container.*;
import Port.*;

import java.util.ArrayList;

public class Ship extends Vehicle {
    public Ship(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name, currentFuel, capacityFuel, currentPort);
    }

    @Override
    public void loadContainer(Container co) {
        this.getAllContainer().add(co);
        System.out.println("Load container successfully");
    }

    @Override
    public double getTotalConsumption(Port any) {
        double totalConsumption = 0;
        if (this.getCurrentPort() != null) {
            for(Container c: this.getAllContainer()) {
                totalConsumption += c.getShipFuelConsumption(this.getCurrentPort(), any);
            }
        } else {
            System.out.println("This vehicle don't have current port");
            System.out.println("Set current port to arrival in trip");
        }
        return totalConsumption;
    }
}
