/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_4_ParkingLot;

public class Bus extends Vehicle {

    public Bus() {
        super();
        this.size = VehicleSize.Large;
        this.SpotOccupy = 4;
    }

    @Override
    public boolean canfit(ParkingSpot parkingSpot) {
        return parkingSpot.SpotSize == VehicleSize.Large;
    }
}
