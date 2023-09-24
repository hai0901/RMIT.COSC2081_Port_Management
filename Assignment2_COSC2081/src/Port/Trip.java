/*
package Port;

import Port.Port;
import Vehicle.Vehicle;

import java.util.Date;

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

}
*/
package Port;
import Container.*;
import Vehicle.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Trip {
    private static ArrayList<Trip> tripArr = new ArrayList<>();
    private Vehicle vehicle;
    private Port departurePort;
    private Port arrivalPort;
    private String departureDay;
    private String arrivalDay;
    private boolean status;
    Trip(Vehicle vehicle, Port departurePort, Port arrivalPort, String departureDay, String arrivalDay, boolean status) {
        this.vehicle = vehicle;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.departureDay = departureDay;
        this.arrivalDay = arrivalDay;
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Port getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(Port departurePort) {
        this.departurePort = departurePort;
    }

    public Port getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(Port arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getArrivalDay() {
        return arrivalDay;
    }

    public void setArrivalDay(String arrivalDay) {
        this.arrivalDay = arrivalDay;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "vehicle=" + vehicle +
                ", departurePort=" + departurePort +
                ", arrivalPort=" + arrivalPort +
                ", departureDay='" + departureDay + '\'' +
                ", arrivalDay='" + arrivalDay + '\'' +
                ", status=" + status +
                '}';
    }

    public static void createTrip(Vehicle vehicle, Port departurePort, Port arrivalPort, String departureDay, String arrivalDay, boolean status) {
        Trip trip = new Trip(vehicle, departurePort, arrivalPort, departureDay, arrivalDay, status);
        tripArr.add(trip);
    }

    public static void listTripByGivenDay() {
        for ( Trip t: tripArr) {
            System.out.println(t);
        }
    }

    public static void main(String[] args) {
        Port A = new Port("A", 19.017656, 72.856178);
        Port B = new Port("B", 40.7127, -74.0059);
        Port C = new Port("C", 42.7127, -78.0059);
        Port D = new Port("D", 45.7127, -71.0059);
        Vehicle xe1 =  new Vehicle("1","Xe1");
        Vehicle xe2 =  new Vehicle("1","Xe2");
        createTrip(xe1, A, B, "12","14", true);
        createTrip(xe2, C, D, "12","14", true);
        listTripByGivenDay();

    }

}
