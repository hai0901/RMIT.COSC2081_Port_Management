package cosc2081_2023_2_GroupName;


public class Vehicle {
    private String name;
    private double curFuel;
    private double capFuel;
    private Port curPort;
    private Integer numContainer;

    Vehicle(){
        this.name = "none";
        this.curFuel = 0;
        this.capFuel = 0;
        this.curPort = null;
        this.numContainer = 0;
    }

    Vehicle(String name, double curFuel, double capFuel, Port port, Integer numContainer) {
        this.name = name;
        this.curFuel = curFuel;
        this.capFuel = capFuel;
        this.curPort = port;
        this.numContainer = numContainer;
    }

    public String getName() {
        return this.name;
    }

    public double getCurFuel() {
        return this.curFuel;
    }

    public double getCapFuel() {
        return this.capFuel;
    }

    public Port getCurPort() {
        return this.curPort;
    }

    public Integer getNumContainer() {
        return this.numContainer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", curFuel=" + curFuel +
                ", capFuel=" + capFuel +
                ", curPort=" + curPort +
                ", numContainer=" + numContainer +
                '}';
    }
}

class Truck extends Vehicle {
   private Integer trNumber;
   private String type;
   Truck(String name, double curFuel, double capFuel, Port port, Integer numContainer,Integer trNumber, String type) {
       super(name, curFuel, capFuel, port, numContainer);
       this.trNumber = trNumber;
       boolean inserted = false;
       String[] typeArray = new String[]{"basic", "reefer", "tanker"};
       for (String t: typeArray) {
           if (t.equals(type)) {
               this.type = type;
               inserted = true;
               break;
           }
       }
       if (inserted == true) System.out.println("Create a truck successfully");
       else System.out.println("This truck type is not accepted");
   }

    @Override
    public String toString() {
        return "Truck{" +
                "name= '" + super.getName() + '\'' +
                ", curFuel= " + super.getCurFuel() +
                ", capFuel= " + super.getCapFuel() +
                ", curPort= " + super.getCurPort() +
                ", numContainer= " + super.getNumContainer() +
                ", trNumber= " + trNumber +
                ", type= '" + type + '\'' +
                '}';
    }
}
class Ship extends Vehicle {
    private Integer shNumber;

    Ship(String name, double curFuel, double capFuel, Port port, Integer numContainer,Integer shNumber) {
        super(name, curFuel, capFuel, port, numContainer);
        this.shNumber = shNumber;
    }

    public String toString() {
        return "Truck{" +
                "name= '" + super.getName() + '\'' +
                ", curFuel= " + super.getCurFuel() +
                ", capFuel= " + super.getCapFuel() +
                ", curPort= " + super.getCurPort() +
                ", numContainer= " + super.getNumContainer() +
                ", trNumber= " + shNumber + '\''+
                '}';
    }
}

class TestVehicle {
    public static void main(String[] args) {
        Port A = new Port("A");
        Port B = new Port("B");
        Vehicle basicTruck = new Truck("Truck1", 100.0, 200.0, A ,3, 1, "basic");
        Vehicle basicShip = new Ship("Ship1", 1000.0, 2000.0, B ,5, 1);
        System.out.println(basicTruck);
        System.out.println(basicShip);
    }
}
