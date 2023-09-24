package Container;

public abstract class Container {
    private String id;
    private double weight;

    Container(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract double getShipFuelConsumption(Port A, Port B);

    public abstract double getTruckFuelConsumption(Port A, Port B);

    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                ", weight=" + weight +
                '}';
    }
}


