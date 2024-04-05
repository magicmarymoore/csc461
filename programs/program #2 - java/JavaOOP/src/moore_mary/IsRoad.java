/**
 * Author: Mary Moore
 * Description: IsRoad Visitor
 */

package moore_mary;

public class IsRoad implements Visitor {
    boolean isRoadBool = false;
    private int row, col;

    public IsRoad(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
    @Override
    public void acceptEmpty(Empty e) {

    }

    @Override
    public void accpetStreet(Street s) {
        if (s.getRow() == row && s.getCol() == col)
            isRoadBool = true;
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

    public boolean isRoad() {
        return isRoadBool;
    }
}
