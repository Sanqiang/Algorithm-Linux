/**
 * Sanqiang Zhao Www.131X.Com Dec 27, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_4_ParkingLot;

public class ParkingSpot {

    private Vehicle CurrentVehicle;
    private int num, row;
    public VehicleSize SpotSize;
    int floor;

    public ParkingSpot(VehicleSize _size, int _num, int _row, int _floor) {
        this.SpotSize = _size;
        this.num = _num;
        this.row = _row;
        this.floor = _floor;
    }

    public int getRow(){
        return row;
    }
    
    public void removeVehicle() {
        CurrentVehicle = null;
    }

    private boolean isAvailable() {
        return CurrentVehicle == null;
    }

    public boolean canFitVehicle(Vehicle v) {
        return isAvailable() && v.canfit(this);
    }

    public boolean partVehicle(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        CurrentVehicle = v;
        v.partInSpot(this);
        return true;
    }

    public static void main(String[] args) {
    }
}
