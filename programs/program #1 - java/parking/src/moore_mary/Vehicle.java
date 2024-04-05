/**
 * Author: Mary Moore
 * Description: Class for a single vehicle in a parking lot.
 */
package moore_mary;

public class Vehicle {
    // properties
    /**
     * ID of the vehicle.
     */
    private final int id;

    /**
     * Time at which the vehicle entered the parking lot.
     */
    private final double enterTime;


    // constructors
    /**
     * Initializes a vehicle.
     * @param id ID of the vehicle.
     * @param time Time at which the vehicle entered the parking lot.
     */
    public Vehicle (int id, double time) {
        this.id = id;
        this.enterTime = time;
    }


    // public methods
    /**
     * Gets the ID of this vehicle.
     * @return ID of the vehicle.
     */
    public int getId () {
        return id;
    }

    /**
     * Calculates the amount of time this vehicle has been in the parking lot.
     * @param exitTime Time at which the vehicle left the parking lot.
     * @return Total amount of time (in minutes) the vehicle was in the parking lot.
     */
    public double getTimeInLot (double exitTime) {
        return exitTime - enterTime;
    }
}

