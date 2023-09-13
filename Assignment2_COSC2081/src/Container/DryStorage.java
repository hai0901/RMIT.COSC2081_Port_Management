package Container;

public class DryStorage extends Container{

    public DryStorage(String id, double weight) {
        super(id, weight);
    }

    @Override
    public double getShipFuelConsumption( Port A, Port B)  {
        double distance = A.getDistanceInKm(B);
        return 3.5 * this.getWeight() * distance;
    }

    @Override
    public double getTruckFuelConsumption( Port A, Port B ) {
        double distance = A.getDistanceInKm(B);
        return 4.6 * this.getWeight() * distance;
    }
}

