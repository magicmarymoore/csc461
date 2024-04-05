/**
 * Java Basic Parking 2023
 * Author: Mary Moore
 * Class: Programming Languages - CSC 461 - M01
 * Date: 9/10/2023
 *
 * Checklist:
 * Additional OOP  requirements
 *     toString properly extended				          COMPLETE
 *     Constructors properly handled			          COMPLETE
 *     Access properly handled (code style requirement)	  COMPLETE
 *
 * Last tier completed: 11
 *
 * Known bugs: none
 */

package moore_mary;

import java.util.ArrayList;
public class District {
    // properties
    /**
     * Most recent start time that all parking lots were closed.
     */
    private double allClosedStartTime = 0;

    /**
     * Value of the next ID to be used.
     */
    private int nextId = 0;

    /**
     * List of all the parking lots in the district.
     */
    private ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    /**
     * Total amount of time all parking lots in district are closed.
     */
    private double totalClosedTime = 0;


    // public methods
    /**
     * Adds a parking lot to the district.
     * @param newLot Parking lot to be added.
     * @return Index of parking lot in the district.
     */
    public int add (ParkingLot newLot) {
        parkingLots.add(newLot);
        nextId++;
        return nextId - 1;
    }

    /**
     * Calculates the total number of minutes all the parking lots in the district are closed.
     * @return Number of minutes ALL parking lots are simultaneously closed.
     */
    public double getClosedMinutes () {
        return totalClosedTime;
    }

    /**
     * Gets a parking lot based on its index.
     * @param index Index of desired parking lot.
     * @return Parking lot with that index.
     */
    public ParkingLot getLot (int index) {
        return parkingLots.get(index);
    }

    /**
     * Gets the total amount of profit generated from all the parking lots throughout the district.
     * @return Total profit to the nearest cent.
     */
    public double getTotalMoneyCollected () {
        double total = 0;
        for (ParkingLot p : parkingLots) {
            total += p.getProfit();
        }
        return total;
    }

    /**
     * Gets the total vehicles from all the parking lots throughout the district.
     * @return The total number of parked cars in all lots.
     */
    public int getVehiclesParkedInDistrict () {
        int total = 0;
        for (ParkingLot p : parkingLots) {
            total += p.getVehiclesInLot();
        }
        return total;
    }

    /**
     * Determines whether there is at least one open parking lot in the district.
     * @return True if all parking lots are closed, false if not.
     */
    public boolean isClosed () {
        for (ParkingLot p : parkingLots) {
            if (!p.isClosed())
                return false;
        }
        return true;
    }

    /**
     * Denotes that a vehicle has entered the specified parking lot.
     * @param index Index of the parking lot to enter.
     * @param minutes Time (in minutes) when the vehicle enters the parking lot.
     * @return ID of the vehicle or -1 if there is either no space in the lot or an error.
     */
    public int markVehicleEntry (int index, double minutes) {
        if (isClosed())
            updatedClosed(minutes);

        int val = parkingLots.get(index).markVehicleEntry(minutes);

        if (isClosed())
            allClosedStartTime = minutes;

        return val;
    }

    /**
     * Denotes that a vehicle has left the specified parking lot.
     * @param index Index of the parking lot to leave.
     * @param minutes Time (in minutes) when the vehicle exits the parking lot.
     * @param id ID of the vehicle that is leaving the parking lot.
     * @return ID of the vehicle or -1 if there was a failure.
     */
    public int markVehicleExit (int index, double minutes, int id) {
        if (isClosed()) {
            updatedClosed(minutes);
            allClosedStartTime = minutes;
        }

        return parkingLots.get(index).markVehicleExit(minutes, id);
    }

    /**
     * Output string for the district status.
     * @return String with the current statuses for all the parking lots in the district.
     */
    @Override
    public String toString () {
        String status = "District status:\n";
        for (ParkingLot p : parkingLots) {
            status += p.toString() + "\n";
        }
        return status;
    }


    // private methods
    /**
     * Calculates the updated total time the district has been closed since this was last checked.
     * @param endTime Current time (in minutes).
     */
    private void updatedClosed (double endTime) {
        totalClosedTime += endTime - allClosedStartTime;
    }
}

