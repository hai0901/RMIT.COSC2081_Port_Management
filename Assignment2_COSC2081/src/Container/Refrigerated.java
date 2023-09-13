package Container;

public class Refrigerated extends Container{
    public Refrigerated(String id, double weight) {
        super(id, weight);
    }

    @Override
    public double getShipFuelConsumption(Port A, Port B) {
        double distance = A.getDistanceInKm(B);
        return 4.5 * this.getWeight() * distance;
    }

    @Override
    public double getTruckFuelConsumption(Port A, Port B) {
        double distance = A.getDistanceInKm(B);
        return 5.4 * this.getWeight() * distance;
    }
}
