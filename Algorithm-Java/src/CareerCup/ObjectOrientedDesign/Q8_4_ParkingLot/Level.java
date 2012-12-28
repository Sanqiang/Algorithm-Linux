/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_4_ParkingLot;

public class Level {

    int numSpots;
    int floor;
    ParkingSpot[] parkingspots;
    private static final int NUM_PER_ROW = 10;
    private int availableSpot;

    public Level(int _num_sports, int _floor) {
        this.floor = _floor;
        this.numSpots = _num_sports;
        parkingspots = new ParkingSpot[_num_sports];
        int large = _num_sports / 4;
        int bike = _num_sports / 4;
        int compact = _num_sports - large - bike;
        for (int i = 0; i < _num_sports; i++) {
            VehicleSize size = VehicleSize.Compact;
            if (i < bike) {
                size = VehicleSize.Motorcycle;
            } else if (i < bike + large) {
                size = VehicleSize.Large;
            }
            int row = i / NUM_PER_ROW;
            parkingspots[i] = new ParkingSpot(size, i, row, _floor);
        }
        availableSpot = _num_sports;
    }

    public boolean partVehicle(Vehicle v) {
        if (availableSpot < v.SpotOccupy) {
            return false;
        }
        int FindSpot = findAvailableSpot(v);
        if (FindSpot < 0) {
            return false;
        }
        return partStartingAtSpot(v, FindSpot);
    }

    private boolean partStartingAtSpot(Vehicle v, int i) {
        v.clearSpot();
        boolean success = true;
        for (int j = i; j < v.SpotOccupy; j++) {
            success &= parkingspots[i].partVehicle(v);
        }
        if (success) {
            availableSpot -= v.SpotOccupy;
        }
        return success;
    }

    private int findAvailableSpot(Vehicle v) {
        int SpotNeed = v.SpotOccupy;
        int LastRow = -1;
        int SpotFind = 0;
        for (int i = 0; i < numSpots; i++) {
            ParkingSpot ps = parkingspots[i];
            if (LastRow != ps.getRow()) {
                LastRow = ps.getRow();
                SpotFind = 0;
            }
            if (ps.canFitVehicle(v)) {
                ++SpotFind;
            }
            if (SpotFind == SpotNeed) {
                return i - (SpotNeed - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}
