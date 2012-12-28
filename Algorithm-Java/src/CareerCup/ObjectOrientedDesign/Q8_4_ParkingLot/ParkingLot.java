/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_4_ParkingLot;

public class ParkingLot {

    private Level[] levels;
    private final int num_floor = 5;

    public ParkingLot() {
        levels = new Level[num_floor];
    }

    public boolean partAtLot(Vehicle v) {
        for (int i = 0; i < num_floor; i++) {
            if (levels[i].partVehicle(v)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
