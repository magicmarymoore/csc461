/**
 * Author: Mary Moore
 * Description: Greenspace Tile
 */

package moore_mary;

public class Greenspace extends Tile {

    public Greenspace(int row, int col) {
        super('░', row, col);
    }

    @Override
    public void accept(Visitor v) {
        v.accpetGreenspace(this);
    }
}
