/**
 * Author: Mary Moore
 * Description: Rezone Visitor
 */

package moore_mary;

public class Rezone implements Visitor {
    private City city;

    public Rezone (City city) {
        this.city = city;
    }

    @Override
    public void acceptEmpty(Empty e) {
        int row = e.getRow();
        int col = e.getCol();
        Tile tile = new Greenspace(row, col);
        city.setTile(tile, row, col);
    }

    @Override
    public void accpetStreet(Street s) {

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
