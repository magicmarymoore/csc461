/**
 * Author: Mary Moore
 * Description: ChangeColor Visitor
 */

package moore_mary;

public class ChangeColor implements Visitor {
    private int type;
    private ColorText.Color color;

    public ChangeColor(int type, ColorText.Color color) {
        this.type = type;
        this.color = color;
    }
    @Override
    public void acceptEmpty(Empty e) {
    }

    @Override
    public void accpetStreet(Street s) {
        if (type == 2)
            s.setColor(color);
    }

    @Override
    public void accpetGreenspace(Greenspace g) {
        if (type == 3)
            g.setColor(color);
    }

    @Override
    public void accpetWater(Water w) {
        if (type == 3)
            w.setColor(color);
    }

    @Override
    public void accpetBuilding(Building b) {
        if (type == 1)
            b.setColor(color);
    }
}
