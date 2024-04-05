/**
 * Author: Mary Moore
 * Description: Building Tile
 */

package moore_mary;

public class Building extends Tile {

    public Building(int row, int col) {
        super('⌂', row, col);
    }
    @Override
    public void accept(Visitor v) {
        v.accpetBuilding(this);
    }
}
