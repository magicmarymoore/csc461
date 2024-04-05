/**
 * Author: Mary Moore
 * Description: FixRoads Visitor
 */

package moore_mary;

public class FixRoads implements Visitor{
    private City city;

    public FixRoads(City city) {
        this.city = city;
    }

    @Override
    public void acceptEmpty(Empty e) {

    }

    @Override
    public void accpetStreet(Street s) {
        boolean top, left, right, bottom;

        int row = s.getRow(), col = s.getCol();

        IsRoad road;

        // x = col, y = row
        if (col > 0) {
            road = new IsRoad(row , col - 1);
            city.accept(road); // GRADING: NESTED
            left = road.isRoad();
        } else
            left = false;

        if (row > 0) {
            road = new IsRoad(row - 1, col);
            city.accept(road);
            top = road.isRoad();
        } else
            top = false;

        if (col < 6) {
            road = new IsRoad(row, col + 1);
            city.accept(road);
            right = road.isRoad();
        } else
            right = false;

        if (row < 6) {
            road = new IsRoad(row + 1, col);
            city.accept(road);
            bottom = road.isRoad();
        } else
            bottom = false;

        s.setAdjacencies(left, top, bottom, right);
    }

    @Override
    public void accpetGreenspace(Greenspace g) {

    }

    @Override
    public void accpetWater(Water w) {

    }

    @Override
    public void accpetBuilding(Building b) {

    }
}
