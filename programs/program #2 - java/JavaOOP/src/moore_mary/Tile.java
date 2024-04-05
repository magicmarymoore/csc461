/**
 * Author: Mary Moore
 * Description: Tile class
 */

package moore_mary;

public abstract class Tile {
    private char symbol;
    private int row, col;
    private ColorText.Color color;

    public Tile(char symbol, int row, int col) {
        this.symbol = symbol;
        this.row = row;
        this.col = col;
        this.color = ColorText.Color.BLACK;
    }

    public abstract void accept(Visitor v);

    public void setColor(ColorText.Color color) {
        this.color = color;
    }

    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return ColorText.colorString(symbol, color);
    };
}
