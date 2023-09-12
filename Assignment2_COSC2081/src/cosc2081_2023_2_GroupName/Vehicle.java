package cosc2081_2023_2_GroupName;


public abstract class Vehicle {
    private String name;
    private double currentFuel;
    private double capacityFuel;
    private Port currentPort;
    private int container;

    Vehicle(){
        this.name = "none";
        this.currentFuel = 0;
        this.capacityFuel = 0;
        this.currentPort = null;
        this.container = 0;
    }

    Vehicle(String name, double currentFuel, double capacityFuel, Port port, int container) {
        this.name = name;
        this.currentFuel = currentFuel;
        this.capacityFuel = capacityFuel;
        this.currentPort = port;
        this.container = container;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getCapacityFuel() {
        return capacityFuel;
    }

    public void setCapacityFuel(double capacityFuel) {
        this.capacityFuel = capacityFuel;
    }

    public Port getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(Port currentPort) {
        this.currentPort = currentPort;
    }

    public int getContainer() {
        return container;
    }

    public void setContainer(int container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", currentFuel=" + currentFuel +
                ", capacityFuel=" + capacityFuel +
                ", currentPort=" + currentPort +
                ", container=" + container;
    }
}

class Truck extends Vehicle {
   private String trNumber;
   private String type;
   Truck(String name, double curFuel, double capFuel, Port port, Integer numContainer,String trNumber, String type) {
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
       return super.toString() +
               ", trNumber: " + trNumber +
               ", type: " + type + "}";
   }
}
class Ship extends Vehicle {
    private String shNumber;

    Ship(String name, double curFuel, double capFuel, Port port, int container,String shNumber) {
        super(name, curFuel, capFuel, port, container);
        this.shNumber = shNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", trNumber: " + shNumber + "}";
    }
}

class TestVehicle {
    public static void main(String[] args) {
        Port A = new Port("A");
        Port B = new Port("B");
        Vehicle basicTruck = new Truck("Truck1", 100.0, 200.0, A ,3, "1", "basic");
        Vehicle basicShip = new Ship("Ship1", 1000.0, 2000.0, B ,5, "2");
        System.out.println(basicTruck);
        System.out.println(basicShip);
    }
}
