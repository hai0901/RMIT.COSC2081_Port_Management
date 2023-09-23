package Vehicle;

import Container.*;
import Port.*;

import java.util.ArrayList;
import java.util.SortedMap;

public abstract class Truck extends Vehicle {

    public Truck(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name,currentFuel,capacityFuel,currentPort);
    }

    @Override
    public double getTotalConsumption(Port any) {
        double totalConsumption = 0;
        if (this.getCurrentPort() != null) {
            for(Container c: this.getAllContainer()) {
                totalConsumption += c.getTruckFuelConsumption(this.getCurrentPort(), any);
            }
        } else {
            System.out.println("This vehicle don't have current port");
            System.out.println("This vehicle is on its trip");
            System.out.println("Set current port to arrival in trip");
            System.out.println("-----------------------------------------------------");
        }
        return totalConsumption;
    }

    @Override
    public void moveAbleNewPort(Trip tr) {
        boolean landingAble = tr.getArrivalPort().isLanding();
        double totalMovingConsumption = this.getTotalConsumption(tr.getArrivalPort());
        System.out.println(totalMovingConsumption);
        if (this.getCurrentFuel() > totalMovingConsumption && landingAble && tr.getArrivalPort().availableToAddVehicle(tr.getVehicle())) {
            tr.setStatus(true);
            this.setCurrentPort(tr.getArrivalPort());
            tr.getArrivalPort().addVehicle(this);
            this.setCurrentFuel(this.getCurrentFuel() - totalMovingConsumption);
            System.out.println("Successfully move to arrival port");
        } else {
            tr.setStatus(false);
            this.setCurrentPort(tr.getDeparturePort());
            tr.getArrivalPort().removeVehicle(this);
            System.out.println("This vehicle doesn't have enough fuel or port doesn't have that ability");
        }
    }
}
