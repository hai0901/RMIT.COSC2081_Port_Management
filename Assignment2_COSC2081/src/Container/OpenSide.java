package Container;

public class OpenSide extends Container{
    public OpenSide(String id, double weight) {
        super(id, weight);
    }

    @Override
    public double getTruckFuelConsumption(Port A, Port B) {
        double distance = A.getDistanceInKm(B);
        return 3.2 * this.getWeight() * distance;
    }

    @Override
    public double getShipFuelConsumption(Port A, Port B) {
        double distance = A.getDistanceInKm(B);
        return 2.7 * this.getWeight() * distance;
    }
}
