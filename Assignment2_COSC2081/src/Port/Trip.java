package Port;

import Port.*;
import Vehicle.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.*;
public class Trip {
    private Vehicle vehicle;
    private Date arrivalDate;
    private Date departureDate;
    private Port arrivalPort;
    private Port departurePort;
    private enum status{
        COMPLETED,
        UNCOMPLETED
    }

    public Trip(Vehicle vehicle, Date arrivalDate, Date departureDate, Port arrivalPort, Port departurePort) {
        this.vehicle = vehicle;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.arrivalPort = arrivalPort;
        this.departurePort = departurePort;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Port getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(Port arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public Port getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(Port departurePort) {
        this.departurePort = departurePort;
    }

    /*
    private double calculateFuelConsumptionForTrip(Port arrivalPort, Container container) {
        if (vehicle instanceof Truck) {
            // For trucks, calculate fuel consumption based on the distance
            double fuelConsumptionRate = getFuelConsumptionRateTruck(Container container);
            double distance = departurePort.getDistanceOtherPort(arrivalPort);
            return fuelConsumptionRate * distance;
        } else if (vehicle instanceof Ship) {

            double totalFuelConsumption = 0.0;

            totalFuelConsumption += vehicle.getDryStorageContainers() * getFuelConsumptionRateShip(new DryStorage());
            totalFuelConsumption += vehicle.getOpenTopContainers() * getFuelConsumptionRateShip(new OpenTop());
            totalFuelConsumption += vehicle.getOpenSideContainers() * getFuelConsumptionRateShip(new OpenSide());
            totalFuelConsumption += vehicle.getRefrigeratedContainers() * getFuelConsumptionRateShip(new Refrigerated());
            totalFuelConsumption += vehicle.getLiquidContainers() * getFuelConsumptionRateShip(new Liquid());

            return totalFuelConsumption;
        } else {
            // add additional codes
            return 1.0;
        }
    } */

    public long getTripDurationInHours() {
        long durationMillis = arrivalDate.getTime() - departureDate.getTime();
        return TimeUnit.MILLISECONDS.toHours(durationMillis);
    }

    private boolean hasAvailableSlotsInArrivalPort(Port arrivalPort) {
        if (vehicle instanceof TankerTruck) {
            return arrivalPort.checkTankerTruckSlots();
        } else if (vehicle instanceof BasicTruck) {
            return arrivalPort.checkBasicTruckSlots();
        } else if (vehicle instanceof ReeferTruck) {
            return arrivalPort.checkReeferTruckSlots();
        } else if (vehicle instanceof Ship) {
            return arrivalPort.checkShipSlots();
        } else {
            return false;
        }
    }

    public void performTrip() {
        /*
        if (!hasEnoughFuelForTrip(arrivalPort)) {
            System.out.println(vehicle.getName() + " does not have enough fuel for the trip to " + arrivalPort.getpName());
            return;
        } */
        if (!hasAvailableSlotsInArrivalPort(arrivalPort)) {
            System.out.println("No available slots in " + arrivalPort.getpName() + " for " + vehicle.getName());
            return;
        }
        departurePort.vehicleOutPort(vehicle);
        vehicle.setCurrentPort(arrivalPort);
        arrivalPort.vehiclesPortIn(vehicle);
        /*double fuelConsumption = calculateFuelConsumptionForTrip(arrivalPort);
        vehicle.setCurrentFuel(vehicle.getCurrentFuel() - fuelConsumption); */
        System.out.println(vehicle.getName() + " has completed the trip from " +
                departurePort.getpName() + " to " + arrivalPort.getpName() + ", the journal will be end on" + arrivalDate + " cost " + getArrivalDate());
    }


}
