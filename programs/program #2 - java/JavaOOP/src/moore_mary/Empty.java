/**
 * Author: Mary Moore
 * Description: Empty Tile
 */

package moore_mary;

public class Empty extends Tile{

    public Empty (int row, int col) {
        super('▫', row, col);
    }
    @Override
    public void accept(Visitor v) {
        v.acceptEmpty(this);
    }
}
