/*
COSC2081 GROUP ASSIGNMENT
CONTAINER PORT MANAGEMENT SYSTEM
Instructor: Mr. Minh Vu & Dr. Phong Ngo
Group: Group Name
s3979239, Nguyen Pham Tien Hai
sXXXXXXX, Student Name
sXXXXXXX, Student Name
*/


import Container.*;
import Vehicle.*;
import  Port.*;

public class Main {
    public static void main(String args[]) {
        //create new instance of Port with Location
        Port port;
        Port port = new Port("P001", "Port 1", 1000, true, new Location(10, 10), null, null, null);
        //create new instance of another Port with Location
        Port port2;
        port2 = new Port("P002", "Port 2", 1000, true, new Location(20, 20), null, null, null);
        //calculate distance between 2 ports
        double distance = port.getLocation().calculateDistance(port2.getLocation());
        System.out.println("Distance between 2 ports: " + distance);



        // Creating 5 instances of BasicTruck
         BasicTruck basicTruck1;
         basicTruck1 = new BasicTruck("BasicTruck1", 100.0, 150.0, port, 0, "BT1", 5000);
        BasicTruck basicTruck2;
         basicTruck2 = new BasicTruck("BasicTruck2", 80.0, 150.0, port, 0, "BT2", 6000);
        BasicTruck basicTruck3;
         basicTruck3 = new BasicTruck("BasicTruck3", 90.0, 150.0, port2, 0, "BT3", 5500);
        BasicTruck basicTruck4;
         basicTruck4 = new BasicTruck("BasicTruck4", 110.0, 150.0, port2, 0, "BT4", 4500);
        BasicTruck basicTruck5;

         basicTruck5 = new BasicTruck("BasicTruck5", 95.0, 150.0, port2, 0, "BT5", 5200);

        // Creating 5 instances of ReeferTruck
        ReeferTruck reeferTruck1 = new ReeferTruck("ReeferTruck1", 120.0, 200.0, port, 0, "RT1", 4000);
        ReeferTruck reeferTruck2 = new ReeferTruck("ReeferTruck2", 130.0, 200.0, port, 0, "RT2", 3800);
        ReeferTruck reeferTruck3 = new ReeferTruck("ReeferTruck3", 140.0, 200.0, port, 0, "RT3", 4200);
        ReeferTruck reeferTruck4 = new ReeferTruck("ReeferTruck4", 125.0, 200.0, port2, 0, "RT4", 4100);
        ReeferTruck reeferTruck5 = new ReeferTruck("ReeferTruck5", 135.0, 200.0, port2, 0, "RT5", 3900);

        // Creating 5 instances of TankerTruck
        TankerTruck tankerTruck1 = new TankerTruck("TankerTruck1", 200.0, 300.0, port, 0, "TT1", 8000);
        TankerTruck tankerTruck2 = new TankerTruck("TankerTruck2", 220.0, 300.0, port, 0, "TT2", 7500);
        TankerTruck tankerTruck3 = new TankerTruck("TankerTruck3", 210.0, 300.0, port, 0, "TT3", 7800);
        TankerTruck tankerTruck4 = new TankerTruck("TankerTruck4", 230.0, 300.0, port, 0, "TT4", 8200);
        TankerTruck tankerTruck5 = new TankerTruck("TankerTruck5", 240.0, 300.0, port, 0, "TT5", 7900);

        // Creating 5 instances of Ship
        Ship ship1 = new Ship("Ship1", 5000.0, 8000.0, port, 0, "S1", 20000);
        Ship ship2 = new Ship("Ship2", 5500.0, 8000.0, port, 0, "S2", 22000);
        Ship ship3 = new Ship("Ship3", 4800.0, 8000.0, port, 0, "S3", 19000);
        Ship ship4 = new Ship("Ship4", 5200.0, 8000.0, port, 0, "S4", 21000);
        Ship ship5 = new Ship("Ship5", 5400.0, 8000.0, port, 0, "S5", 23000);


        //Creating 5 instances of container
        Container dry1 =  new DryStorage("1", 150);
        Container re1 =  new Refrigerated("2", 200);
        Container side1 = new OpenSide("3", 405);
        Container top1 = new OpenTop("4", 375);
        Container li1 = new Liquid("5", 653);

    }


}
