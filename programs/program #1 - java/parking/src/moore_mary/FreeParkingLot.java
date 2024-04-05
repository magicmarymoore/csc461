/**
 * Author: Mary Moore
 * Description: Free parking lot class.
 */
package moore_mary;

public class FreeParkingLot extends ParkingLot {
    // properties
    /**
     * A free parking lot costs $0.
     */
    public static final double FREE_LOT_COST = 0;

    /**
     * Value of the most recent ID added to the list (next to be removed).
     */
    private int lastId = 0;


    // constructors
    /**
     * Initializes a free parking lot.
     * @param name Name of the parking lot. Default name is "test."
     * @param size Number of vehicles the parking lot can hold.
     */
    public FreeParkingLot(String name, int size) {
        super(name, size, FREE_LOT_COST);
    }

    /**
     * Initializes a free parking lot with the default name.
     * @param size Number of vehicles the parking lot can hold.
     */
    public FreeParkingLot(int size) {
        super(size, FREE_LOT_COST);
    }


    // public methods
    /**
     * Denotes that a vehicle has entered the parking lot.
     * @param minutes Time (in minutes) when the vehicle enters the parking lot.
     * @return ID of the vehicle or -1 if there is either no space in the lot or an error.
     */
    @Override
    public int markVehicleEntry (double minutes) {
        return super.markVehicleEntry(minutes);
    }

    /**
     * Denotes that a vehicle has left the parking lot.
     * @param minutes Time (in minutes) when the vehicle exits the parking lot.
     * @param id ID of the vehicle that is leaving the parking lot, does not control anything.
     * @return ID of the vehicle or -1 if there was a failure.
     */
    @Override
    public int markVehicleExit (double minutes, int id) {
        if (super.markVehicleExit(minutes, lastId) != -1) { // always just remove the most recent vehicle?
            lastId++;
            return id;
        }

        return -1;
    }

    /**
     * Denotes that a vehicle has left the parking lot without an ID specified.
     * @param minutes Time (in minutes) when the vehicle exits the parking lot.
     * @return ID of the vehicle or -1 if there was a failure.
     */
    public int markVehicleExit (double minutes) {
        return this.markVehicleExit(minutes, lastId); // always just remove the first vehicle?
    }

    /**
     * Output string for the parking lot status.
     * @return String with the current status, doesn't include 'Money Collected'.
     */
    @Override
    public String toString () {
        return super.toString()
                .substring(0, super.toString().indexOf("Money Collected: $")-1);
    }
}

