/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_4_ParkingLot;

import java.util.ArrayList;

public abstract class Vehicle {

    public VehicleSize size;
    public int SpotOccupy;
    public ArrayList<ParkingSpot> ParkingSpots;

    public Vehicle() {
        this.ParkingSpots = new ArrayList<>();
    }

    public void partInSpot(ParkingSpot ps) {
        this.ParkingSpots.add(ps);
    }

    public void clearSpot() {
        for (ParkingSpot parkingSpot : ParkingSpots) {
            parkingSpot.removeVehicle();
        }
        this.ParkingSpots.clear();
    }

    public abstract boolean canfit(ParkingSpot parkingSpot);

    public static void main(String[] args) {
    }
}
