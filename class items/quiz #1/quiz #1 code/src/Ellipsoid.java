public class Ellipsoid {
    private double xRadius;
    private double yRadius;
    private double zRadius;

    public Ellipsoid(double xRadius, double yRadius, double zRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
        this.zRadius = zRadius;
    }

    public double getVolume() {
        return xRadius * yRadius * zRadius * Math.PI * (4.0/3.0);
    }

    public double ratio(Ellipsoid e) {
        return getVolume()/e.getVolume();
    }

}
