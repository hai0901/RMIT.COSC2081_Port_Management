package Vehicle;

import Container.*;
import Port.*;

public class TankerTruck extends Truck{
    private int liquidCount;

    public TankerTruck(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name, currentFuel, capacityFuel, currentPort);
    }
    public int getLiquidCount() {
        return liquidCount;
    }

    public void getAllLiquidContainer() {
        System.out.println("-------Liquid in Vehicle-------");
        for (Container co : this.getAllContainer()) {
            if (co instanceof Liquid) {
                System.out.println(co);
            }
        }
    }

    @Override
    public void getAllSpecificContainerDetail() {
        this.getAllLiquidContainer();
        System.out.println("-------Quantity of Containers-------");
        System.out.printf("Liquid: %s \n", this.getLiquidCount());
    }

    @Override
    public void updateContainerCounts() {
        this.liquidCount = 0;
        for (Container c: this.getAllContainer()) {
            if (c instanceof Liquid) {
                this.liquidCount++;
            }
        }
        this.setCarryingCapacity(this.getAllContainerWeight());
    }

    @Override
    public void loadContainer(Container co) {
        if ( co instanceof Liquid) {
            this.getAllContainer().add(co);
            System.out.println("Load container successfully");
        } else {
            System.out.println("This tanker truck can't load this type container");
        }
        this.updateContainerCounts();
    }
}
