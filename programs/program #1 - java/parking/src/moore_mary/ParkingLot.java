/**
 * Author: Mary Moore
 * Description: Parking lot class.
 */

package moore_mary;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class ParkingLot {
    // properties
    /**
     * Default value for the hourly parking fee.
     */
    public static final double DEFAULT_FEE = 1;

    /**
     * Default value for the parking lot name.
     */
    public static final String DEFAULT_NAME = "test";

    /**
     * Percent threshold at which the parking lot is deemed closed.
     */
    public static final int CLOSED_THRESHOLD = 80;

    /**
     * The most recent time (in minutes) when the parking lot was deemed closed.
     */
    private double closedStartTime = 0;

    /**
     * Hourly fee for a vehicle parked in the parking lot.
     */
    private double fee = DEFAULT_FEE;

    /**
     * Most recent time at which a vehicle has either entered or exited the parking lot.
     */
    private double latestEnterExitTime = 0;

    /**
     * Name of the parking lot. Default name is "test."
     */
    private String name = DEFAULT_NAME;

    /**
     * Next ID value for a new vehicle entering the parking lot.
     */
    private int newId = 0;

    /**
     * Amount of money the parking lot has made thus far.
     */
    private double profit = 0;

    /**
     * Number of vehicles the parking lot can hold.
     */
    private int size;

    /**
     * Total number of minutes the parking lot has been closed.
     */
    private double totalClosedTime = 0;

    /**
     * List of all the vehicles currently in the parking lot.
     */
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();


    // constructors
    /**
     * Initializes a parking lot.
     * @param name Name of the parking lot. Default name is "test."
     * @param size Number of vehicles the parking lot can hold.
     * @param fee Hourly fee for a vehicle parked in the parking lot.
     */
    public ParkingLot(String name, int size, double fee) {
        // set name, hourly fee
        this.name = name;
        this.size = size;
        this.fee = fee;
    }

    /**
     * Initializes a parking lot with the default fee.
     * @param name Name of the parking lot. Default name is "test."
     * @param size Number of vehicles the parking lot can hold.
     */
    public ParkingLot (String name, int size) {
        this(name, size, DEFAULT_FEE); // GRADING: CONSTRUCTION
    }

    /**
     * Initializes a parking lot with the default name.
     * @param size Number of vehicles the parking lot can hold.
     * @param fee Hourly fee for a vehicle parked in the parking lot.
     */
    public ParkingLot (int size, double fee) {
        this(DEFAULT_NAME, size, fee);
    }

    /**
     * Initializes a parking lot with the default name & fee.
     * @param size Number of vehicles the parking lot can hold.
     */
    public ParkingLot(int size) {
        this(DEFAULT_NAME, size, DEFAULT_FEE);
    }


    // public methods
    /**
     * Calculates the number of minutes the parking lot has been closed.
     * @return Total amount of time (in minutes) the parking lot has been closed.
     */
    public double getClosedMinutes () {
        return totalClosedTime;
    }

    /**
     * Gets the name of the parking lot.
     * @return Name of the parking lot.
     */
    public String getName () {
        return name;
    }

    /**
     * Gets the total profit that has been collected from cars which have left the lot.
     * @return Profit that has been collected.
     */
    public double getProfit() {
        return profit;
    }

    /**
     * Gets the total number of vehicles in the parking lot.
     * @return Total number of vehicles in the parking lot.
     */
    public int getVehiclesInLot () {
        return vehicles.size();
    }

    /**
     * Determines whether the parking lot is currently closed based on the closed threshold.
     * @return True if the lot is closed, false if not.
     */
    public boolean isClosed () {
        return getVehiclesInLot() >= getClosedThreshold();
    }

    /**
     * Denotes that a vehicle has entered the parking lot.
     * @param minutes Time (in minutes) when the vehicle enters the parking lot.
     * @return ID of the vehicle or -1 if there is either no space in the lot or an error.
     */
    public int markVehicleEntry (double minutes) {
        if (isClosed())
            updateClosedTime(minutes);

        if (getVehiclesInLot() >= size || minutes < latestEnterExitTime)
            return -1;
        else {
            vehicles.add(new Vehicle(newId, minutes));
            newId++;

            // check if lot is closed, if so start closed time
            if (isClosed())
                closedStartTime = minutes;

            latestEnterExitTime = minutes;

            return newId - 1;
        }
    }

    /**
     * Denotes that a vehicle has left the parking lot.
     * @param minutes Time (in minutes) when the vehicle exits the parking lot.
     * @param id ID of the vehicle that is leaving the parking lot.
     * @return ID of the vehicle or -1 if there was a failure.
     */
    public int markVehicleExit (double minutes, int id) {
        if (minutes < latestEnterExitTime || getVehiclesInLot() == 0)
            return -1;

        if (isClosed()) {
            updateClosedTime(minutes);
            closedStartTime = minutes;
        }

        addProfit(getVehicle(id).getTimeInLot(minutes));
        removeVehicle(id);

        latestEnterExitTime = minutes;

        return id;
    }

    /**
     * Output string for the parking lot status.
     * @return String with the current status.
     */
    @Override
    public String toString () {
        return "Status for " + getName() +
                " parking lot: " + getVehiclesInLot() +
                " vehicles (" + getPercent() + ") Money Collected: $" + getProfitFormatted();
    }


    // private methods
    /**
     * Increments the total profit made at this parking lot.
     * @param minutes Number of minutes the car has been in the parking lot. (Less than or equal to 15 min is free)
     */
    private void addProfit (double minutes) {
        if (minutes <= 15)
            return;

        profit += fee * minutes / 60;
    }

    /**
     * Calculates the closed threshold for this size parking lot.
     * @return Value of the closed threshold in number of vehicles.
     */
    private double getClosedThreshold () {
        return (double)(CLOSED_THRESHOLD * size) / 100;
    }

    /**
     * Calculates the percent full of the parking lot.
     * @return String of the percent to be printed or 'CLOSED' if the lot is closed.
     */
    private String getPercent() {
        DecimalFormat formatter = new DecimalFormat("###.#");
        if (isClosed())
            return "CLOSED";

        return formatter.format(((double)getVehiclesInLot()/(double)size)*100) + "%";
    }

    /**
     * Formats the profit into a printable form.
     * @return Profit rounded to the nearest cent.
     */
    private String getProfitFormatted () {
        DecimalFormat formatter = new DecimalFormat("###,##0.00");
        return formatter.format(getProfit());
    }

    /**
     * Gets a vehicle from the list by ID.
     * @param id ID of the desired vehicle
     * @return Vehicle with corresponding ID from the list, or the first vehicle if no matching ID is found.
     */
    private Vehicle getVehicle (int id) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id)
                return vehicles.get(i);
        }
        return vehicles.get(0); // if the id isn't in the list, return the first element
    }

    /**
     * Removes a vehicle from the list by ID.
     * @param id ID of the vehicle to remove.
     */
    private void removeVehicle (int id) {
        Iterator<Vehicle> car = vehicles.iterator(); // can't delete during normal for each loops, so use an iterator :)
        while (car.hasNext()) {
            if (car.next().getId() == id) {
                car.remove();
            }
        }
    }

    /**
     * Calculates the updated total time the parking lot has been closed since this was last checked.
     * @param endTime Current time (in minutes).
     */
    private void updateClosedTime (double endTime) {
        totalClosedTime += endTime - closedStartTime;
    }
}

