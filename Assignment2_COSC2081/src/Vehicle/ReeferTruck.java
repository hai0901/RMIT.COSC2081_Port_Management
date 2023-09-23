package Vehicle;

import Container.*;
import Port.*;

public class ReeferTruck extends Truck{
    private int refrigeratedCount;
    public ReeferTruck(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name, currentFuel, capacityFuel, currentPort);
    }

    public int getRefrigeratedCount() {
        return this.refrigeratedCount;
    }

    public void getRefrigeratedContainer() {
        System.out.println("-------Refrigerated in Vehicle-------");
        for (Container co : this.getAllContainer()) {
            if (co instanceof Refrigerated) {
                System.out.println(co);
            }
        }
    }

    @Override
    public void getAllSpecificContainerDetail() {
        this.getRefrigeratedContainer();
        System.out.println("-------Quantity of Containers-------");
        System.out.printf("Refrigerated: %s \n", this.getRefrigeratedCount());
    }

    @Override
    public void updateContainerCounts() {
        this.refrigeratedCount = 0;
        for (Container c: this.getAllContainer()) {
            if (c instanceof Refrigerated) {
                this.refrigeratedCount++;
            }
        }
        this.setCarryingCapacity(this.getAllContainerWeight());
    }

    @Override
    public void loadContainer(Container co) {
        if ( co instanceof Refrigerated) {
            this.getAllContainer().add(co);
            System.out.println("Load container successfully");
        } else {
            System.out.println("This reefer truck can't load this type container");
        }
        this.updateContainerCounts();
    }
}
