package Vehicle;

import Container.*;
import Port.*;

public class TankerTruck extends Truck{
    public TankerTruck(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name, currentFuel, capacityFuel, currentPort);
    }

    @Override
    public void loadContainer(Container co) {
        if ( co instanceof Liquid) {
            this.getAllContainer().add(co);
            System.out.println("Load container successfully");
        } else {
            System.out.println("This tanker truck can't load this type container");
        }
    }
}
