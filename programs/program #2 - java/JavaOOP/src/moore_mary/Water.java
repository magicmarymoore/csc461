/**
 * Author: Mary Moore
 * Description: Water Tile
 */

package moore_mary;

public class Water extends Tile {

    public Water(int row, int col) {
        super('~', row, col);
    }

    @Override
    public void accept(Visitor v) {
        v.accpetWater(this);
    }
}
