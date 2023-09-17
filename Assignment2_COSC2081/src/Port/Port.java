package Port;

import Vehicle.*;

import java.awt.Container;
import java.util.ArrayList;

public class Port {
    /****************
     * Set variable.*
     ****************/

    private String pNum; //port's numbe
    private String pName; //port's name
    private double pCapacity; //port's capacity
    private boolean landing; //port's landing ability
    private double latitude;
    private double longitude;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<Container> containers = new ArrayList<>();
    private ArrayList<Trip> trips = new ArrayList<>();

    public Port( String pNum, String pName, double pCapacity, boolean landing, double latitude, double longitude ) {
        this.pNum = pNum;
        this.pName = pName;
        this.pCapacity = pCapacity;
        this.landing = landing;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getpCapacity() {
        return pCapacity;
    }

    public void setpCapacity(double pCapacity) {
        this.pCapacity = pCapacity;
    }

    public boolean isLanding() {
        return landing;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLanding(boolean landing) {
        this.landing = landing;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicle(Vehicle ve) {
        this.vehicles.add(ve);
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void addTrip(Trip t) {
        this.trips.add(t);
    }

    public ArrayList<Container> getContainers() {
        return containers;
    }

    public void addContainers(Container con) {
        this.containers.add(con) ;
    }

    public void removeContainer(Container container){
        for ( Container co : containers) {
            if ( co == container) {
                this.containers.remove(co);
            }
        }
    }

    public void removeVehicle(Vehicle vehicle){
        for ( Vehicle ve : vehicles) {
            if ( ve == vehicle) {
                this.vehicles.remove(ve);
            }
        }
    }

    public void removeVehicle(Trip trip){
        for ( Trip tr : trips) {
            if ( tr == trip) {
                this.trips.remove(tr);
            }
        }
    }

    @Override
    public String toString() {
        return "Port{" +
                "pNum='" + pNum + '\'' +
                ", pName='" + pName + '\'' +
                ", pCapacity=" + pCapacity +
                ", landing=" + landing +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public double getDistanceInKm(Port any) {
        double earthRadius = 6371;

        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(any.latitude);
        double lon2 = Math.toRadians(any.longitude);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        //Calculate the distance using the Haversine Formula

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = earthRadius * c;
        return distance;
    }
}