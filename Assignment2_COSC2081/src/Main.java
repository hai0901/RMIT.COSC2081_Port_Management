/*
COSC2081 GROUP ASSIGNMENT
CONTAINER PORT MANAGEMENT SYSTEM
Instructor: Mr. Minh Vu & Dr. Phong Ngo
Group: Group Name
s3979239, Nguyen Pham Tien Hai
sXXXXXXX, Student Name
sXXXXXXX, Student Name
*/


import Container.DryStorage;
import Port.Port;
import Port.Location;
public class Main {
    public static void main(String args[]) {
        //create new instance of Port with Location
        Port port;
        port = new Port("P001", "Port 1", 1000, true, new Location(10, 10), null, null, null);
        //create new instance of another Port with Location
        Port port2;
        port2 = new Port("P002", "Port 2", 1000, true, new Location(20, 20), null, null, null);
        //calculate distance between 2 ports
        double distance = port.getLocation().calculateDistance(port2.getLocation());
        System.out.println("Distance between 2 ports: " + distance);


    }


}
