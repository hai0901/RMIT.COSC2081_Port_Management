package Port;

import Container.Container;
import Vehicle.*;
import java.util.Date;

public class Trip {
    private Vehicle vehicle;
    private String departureDate;
    private String arrivalDate;
    private Port departurePort;
    private Port arrivalPort;
    private Boolean status;

    public Trip(Vehicle vehicle, String departureDate, String arrivalDate, Port departurePort, Port arrivalPort, Boolean status) {
        this.vehicle = vehicle;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public Port getArrivalPort() {
        return this.arrivalPort;
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


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Trip{" +
                "vehicle=" + vehicle +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departurePort=" + departurePort +
                ", arrivalPort=" + arrivalPort +
                ", status=" + status +
                '}';
    }
}
