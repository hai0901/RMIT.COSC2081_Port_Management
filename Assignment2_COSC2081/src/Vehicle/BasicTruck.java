package Vehicle;

import Container.*;
import Port.*;

import java.util.ArrayList;

public class BasicTruck extends Truck{
    public BasicTruck(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name, currentFuel, capacityFuel, currentPort);
    }

    @Override
    public void loadContainer(Container co) {
        if ( co instanceof DryStorage || co instanceof OpenTop || co instanceof OpenSide) {
            this.getAllContainer().add(co);
            System.out.println("Load container successfully");
        } else {
            System.out.println("This basic truck can't load this type container");
        }
    }

}
