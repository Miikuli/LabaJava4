public class BoxMasks {
    public static <T extends Point> void addPointToBox(Box<? super T> box, double x, double y, double z) {
        Point2 point = new Point2(x, y, z);

        box.setBox((T) point);
    }
}
