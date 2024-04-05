/**
 * Author: Mary Moore
 * Description: Main City class
 */

package moore_mary;

import java.util.ArrayList;
import java.util.List;

public class City {
    private final int SIZE = 7;
    private List<List<Tile>> grid;
    public City() {
        grid = new ArrayList<List<Tile>>(SIZE);
        for (int i = 0; i < SIZE; i++)
            grid.add(new ArrayList<Tile>());

        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                grid.get(i).add(new Empty(i, j));
    }

    @Override
    public String toString() {
        String s = "\n";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                s += grid.get(i).get(j);
            s += "\n";
        }

        return s;
    }

    public void accept(Visitor v) {
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col ++)
                grid.get(row).get(col).accept(v);
    }

    public void setTile(Tile tile, int row, int col) {
        grid.get(row).set(col, tile);
    }
}
