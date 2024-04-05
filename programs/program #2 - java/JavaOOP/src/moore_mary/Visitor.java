/**
 * Author: Mary Moore
 * Description: Visitor interface
 */

package moore_mary;

public interface Visitor {
    public void acceptEmpty(Empty e);
    public void accpetStreet(Street s);
    public void accpetGreenspace(Greenspace g);
    public void accpetWater(Water w);
    public void accpetBuilding(Building b);
}
