/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_4_ParkingLot;

public class Car extends Vehicle {

    public Car() {
        super();
        this.size = VehicleSize.Compact;
        this.SpotOccupy = 2;
    }

    @Override
    public boolean canfit(ParkingSpot parkingSpot) {
        return parkingSpot.SpotSize == VehicleSize.Compact || parkingSpot.SpotSize == VehicleSize.Large;
    }

    public static void main(String[] args) {
    }
}
