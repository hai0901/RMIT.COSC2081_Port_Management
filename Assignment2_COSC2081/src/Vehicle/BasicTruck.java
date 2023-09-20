package Vehicle;

import Container.*;
import Port.*;

import java.util.ArrayList;

public class BasicTruck extends Truck{
    private int dryStorageCount = 0;
    private int openSideCount = 0;
    private int openTopCount = 0;

    public BasicTruck(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name, currentFuel, capacityFuel, currentPort);
    }

    public int getDryStorageCount() {
        return this.dryStorageCount;
    }

    public int getOpenSideCount() {
        return this.openSideCount;
    }

    public int getOpenTopCount() {
        return this.openTopCount;
    }

    public void getAllDryStorageContainer() {
        System.out.println("-------Dry Storage in Vehicle-------");
        for (Container co : this.getAllContainer()) {
            if (co instanceof DryStorage) {
                System.out.println(co);
            }
        }
    }

    public void getAllOpenTopContainer() {
        System.out.println("-------Open Top in Vehicle-------");
        for (Container co : this.getAllContainer()) {
            if (co instanceof OpenTop) {
                System.out.println(co);
            }
        }
    }

    public void getAllOpenSideContainer() {
        System.out.println("-------Open Side in Vehicle-------");
        for (Container co : this.getAllContainer()) {
            if (co instanceof OpenSide) {
                System.out.println(co);
            }
        }
    }

    @Override
    public void getAllSpecificContainerDetail() {
        this.getAllDryStorageContainer();
        this.getAllOpenTopContainer();
        this.getAllOpenSideContainer();
        System.out.println("-------Quantity of Containers-------");
        System.out.printf("Dry Storage: %s \n", this.getDryStorageCount());
        System.out.printf("Open Top: %s \n", this.getOpenTopCount());
        System.out.printf("Open Side: %s \n", this.getOpenSideCount());
    }

    @Override
    public void updateContainerCounts() {
        this.dryStorageCount = 0;
        this.openSideCount = 0;
        this.openTopCount = 0;

        for (Container c: this.getAllContainer()) {
            if (c instanceof DryStorage) {
                this.dryStorageCount++;
            } else if (c instanceof OpenSide) {
                this.openSideCount++;
            } else {
                this.openTopCount++;
            }
        }
        this.setCarryingCapacity(this.getAllContainerWeight());
    }

    @Override
    public void loadContainer(Container co) {
        if ( co instanceof DryStorage || co instanceof OpenTop || co instanceof OpenSide) {
            this.getAllContainer().add(co);
            System.out.println("Load container successfully");
        } else {
            System.out.println("This basic truck can't load this type container");
        }
        this.updateContainerCounts();
    }

}
