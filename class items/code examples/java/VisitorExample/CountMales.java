package VisitorExample;

public class CountMales implements Visitor{

    private int count = 0;
    @Override
    public void gotAChicken(Chicken c) {
        if (c.isRooster())
            count++;
    }

    @Override
    public void gotAPig(Pig p) {
        if (p.isBoar())
            count++;
    }

    @Override
    public void gotACattle(Cattle c) {
        if (c.isBull())
            count++;
    }

    public int getCount() {
        return count;
    }
}
