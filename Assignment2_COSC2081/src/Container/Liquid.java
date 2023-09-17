package Container;
import Port.*;

public class Liquid extends Container{
    public Liquid(String id, double weight) {
        super( id, weight );
    }

    @Override
    public double getTruckFuelConsumption( Port A, Port B ) {
        double distance = A.getDistanceInKm(B);
        return 5.3 * this.getWeight() * distance;
    }

    @Override
    public double getShipFuelConsumption( Port A, Port B ) {
        double distance = A.getDistanceInKm(B);
        return 4.8 * this.getWeight() * distance;
    }
}
