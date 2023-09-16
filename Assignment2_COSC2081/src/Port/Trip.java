package Port;

import Container.Container;
import Port.Port;
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
    private Container container;

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



    public long getTripDurationInHours() {
        long durationMillis = arrivalDate.getTime() - departureDate.getTime();
        return TimeUnit.MILLISECONDS.toHours(durationMillis);
    }

    public boolean canPerformTrip() {
        double totalWeightInPort = arrivalPort.getTotalContainerWeight();
        double totalWeightOnVehicle = vehicle.getTotalContainerWeight();

        // Calculate the estimated total weight after loading the container
        double estimatedTotalWeight = totalWeightInPort + totalWeightOnVehicle + container.getConWeight();

        return estimatedTotalWeight <= arrivalPort.getpCapacity();
    }
    public void performTrip() {

        departurePort.vehicleOutPort(vehicle);
        vehicle.setCurrentPort(arrivalPort);
        arrivalPort.vehiclesPortIn(vehicle);

        System.out.println(vehicle.getName() + " has completed the trip from " +
                departurePort.getpName() + " to " + arrivalPort.getpName() + ", the journal will be end on" + arrivalDate + " cost " + getArrivalDate());
    }


}
