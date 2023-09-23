package Vehicle;

import Container.*;
import Port.*;

import java.util.ArrayList;

public class Ship extends Vehicle {
    private int dryStorageCount;
    private int liquidCount;
    private int openSideCount;
    private int openTopCount;
    private int refrigeratedCount;

    public Ship(String vehID, String name, double currentFuel, double capacityFuel, Port currentPort) {
        super(vehID, name, currentFuel, capacityFuel, currentPort);
    }

    public int getDryStorageCount() {
        return dryStorageCount;
    }

    public int getLiquidCount() {
        return liquidCount;
    }

    public int getOpenSideCount() {
        return openSideCount;
    }

    public int getOpenTopCount() {
        return openTopCount;
    }

    public int getRefrigeratedCount() {
        return refrigeratedCount;
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

    public void getRefrigeratedContainer() {
        System.out.println("-------Refrigerated in Vehicle-------");
        for (Container co : this.getAllContainer()) {
            if (co instanceof Refrigerated) {
                System.out.println(co);
            }
        }
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
        this.getAllDryStorageContainer();
        this.getAllOpenTopContainer();
        this.getAllOpenSideContainer();
        this.getRefrigeratedContainer();
        this.getAllLiquidContainer();
        System.out.println("-------Quantity of Containers-------");
        System.out.printf("Dry Storage: %s \n", this.getDryStorageCount());
        System.out.printf("Open Top: %s \n", this.getOpenTopCount());
        System.out.printf("Open Side: %s \n", this.getOpenSideCount());
        System.out.printf("Refrigerated: %s \n", this.getRefrigeratedCount());
        System.out.printf("Liquid: %s \n", this.getLiquidCount());
    }

    @Override
    public void updateContainerCounts() {
        this.dryStorageCount = 0;
        this.liquidCount = 0;
        this.openSideCount = 0;
        this.openTopCount = 0;
        this.refrigeratedCount = 0;

        for (Container co : this.getAllContainer()) {
            if (co instanceof DryStorage) {
                this.dryStorageCount++;
            } else if (co instanceof Liquid) {
                this.liquidCount++;
            } else if (co instanceof OpenSide) {
                this.openSideCount++;
            } else if (co instanceof OpenTop) {
                this.openTopCount++;
            } else if (co instanceof Refrigerated) {
                this.refrigeratedCount++;
            }
        }
        this.setCarryingCapacity(this.getAllContainerWeight());
    }

    @Override
    public void loadContainer(Container container) {
        // Check if the ship can carry the new container based on its weight
        if (this.getCarryingCapacity() >= container.getWeight()) {
            this.getCarryingContainers().add(container);
            this.setCarryingCapacity(this.getCarryingCapacity() - container.getWeight());
        } else {
            // Print an error message if the ship cannot carry the container
            System.out.println("The container exceeds the ship's carrying capacity.");
        }
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
            System.out.println("This vehicle is on its trip");
            System.out.println("Set current port to arrival in trip");
            System.out.println("-----------------------------------------------------");
        }
        return totalConsumption;
    }

    @Override
    public void moveAbleNewPort(Trip tr) {
        double totalMovingConsumption = this.getTotalConsumption(tr.getArrivalPort());
        System.out.println(totalMovingConsumption);
        if (this.getCurrentFuel() > totalMovingConsumption && tr.getArrivalPort().availableToAddVehicle(tr.getVehicle())) {
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
