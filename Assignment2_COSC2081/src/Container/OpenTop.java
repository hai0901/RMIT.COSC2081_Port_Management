package Container;
import Port.*;

public class OpenTop extends Container{
    public OpenTop(String id, double weight) {
        super(id, weight);
    }

    @Override
    public double getTruckFuelConsumption( Port A, Port B ) {
        double distance = A.getDistanceInKm(B);
        return 3.2 * this.getWeight() * distance;
    }

    @Override
    public double getShipFuelConsumption( Port A, Port B ) {
        double distance = A.getDistanceInKm(B);
        return 2.8 * this.getWeight() * distance;
    }
}
