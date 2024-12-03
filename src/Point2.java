public class Point2 extends Point {
    private double z;

    public Point2(double x, double y, double z) {
        super(x, y);
        if (Double.isNaN(z)) {
            throw new IllegalArgumentException("Координата Z не может быть NaN");
        }
        this.z = z;
    }

    public void setValue(double x, double y, double z) {
        super.setValue(x, y);
        if (Double.isNaN(z)) {
            throw new IllegalArgumentException("Координаты не могут быть NaN");
        }
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" + super.getX() + ";" + super.getY() + ";" + z + "}";
    }

}