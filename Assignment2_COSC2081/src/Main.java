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
import Port.*;
import Vehicle.*;



public class Main {
    public static void main(String args[]) {
        Container dry1 =  new DryStorage("C001", 15);
        Container re1 =  new Refrigerated("C002", 20);
        Container lq1 =  new Liquid("C003", 10);
        Container oT =  new OpenTop("C004", 30);
        Container oS =  new OpenSide("C004", 40);

        Port port1 = new Port("P001","USA",1000,true,-17,70);
        Port port2 = new Port("P002","VN",800,true,71,-29);
        Port port3 = new Port("P003","China",2000,true,56,60);
        Port port4 = new Port("P004","France",1100,false,-30,90);
        Port port5 = new Port("P005","Itali",1110,false,-15,60);

        Vehicle bs1 = new BasicTruck("tr-0001","basictruck1", 200, 800,null);
        Vehicle rt1 = new ReeferTruck("tr-0002","reefertruck1", 400, 700,null);
        Vehicle tt1 = new TankerTruck("tr-0003","tankertruck1", 150, 500,null);
        Vehicle ship1 = new Ship("sh-0001","ship1", 2000, 5000,null);

        Trip trip1 = new Trip(bs1, "11/12/2023", "12/10/2023", port1, port2,null);
        Trip trip2 = new Trip(bs1, "30/12/2023", "20/12/2023", port2, port3,null);

        bs1.loadContainer(re1);
        bs1.loadContainer(dry1);
        bs1.loadContainer(oT);
        bs1.loadContainer(oS);
        System.out.println(bs1.countTotalContainer());
        System.out.println(bs1.getAllContainer());
        bs1.unloadContainer(re1);
        bs1.unloadContainer(oT);
        System.out.println(bs1.countTotalContainer());
        System.out.println(bs1.getAllContainer());
        System.out.println(bs1.getAllContainerWeight());
        System.out.println(bs1);
        System.out.println(trip1);
        bs1.moveAbleNewPort(trip1);
        System.out.println(bs1);
        System.out.println(trip1);
        bs1.moveAbleNewPort(trip2);
        System.out.println(bs1);
        System.out.println(trip2);

    }


}
