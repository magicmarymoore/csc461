/**
 * Author: Mary Moore
 * Description: GetCounts Visitor
 */

package moore_mary;

public class GetCounts implements Visitor {
    private int emptyCount, streetCount, greenspaceCount, waterCount, buildingCount;

    public GetCounts() {
        emptyCount = 0;
        streetCount = 0;
        greenspaceCount = 0;
        waterCount = 0;
        buildingCount = 0;
    }
    @Override
    public void acceptEmpty(Empty e) {
        emptyCount++;
    }

    @Override
    public void accpetStreet(Street s) {
        streetCount++;
    }

    @Override
    public void accpetGreenspace(Greenspace g) {
        greenspaceCount++;
    }

    @Override
    public void accpetWater(Water w) {
        waterCount++;
    }

    @Override
    public void accpetBuilding(Building b) {
        buildingCount ++;
    }

    public int getEmptyCount() {
        return emptyCount;
    }

    public int getStreetCount() {
        return streetCount;
    }

    public int getGreenspaceCount() {
        return greenspaceCount;
    }

    public int getWaterCount() {
        return waterCount;
    }

    public int getBuildingCount() {
        return buildingCount;
    }

    public String toString()
    {
        return "Empty: " + emptyCount +
                "\nBuildings: " + buildingCount +
                "\nGreenspaces: " + greenspaceCount +
                "\nRoads: " + streetCount +
                "\nWater: " + waterCount +
                '\n';
    }
}
