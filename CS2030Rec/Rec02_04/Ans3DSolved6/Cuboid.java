package CS2030Rec.Rec02_04.Ans3DSolved6;

// Cuboid is a Shape3D.
public class Cuboid implements Shape3D {
    // Responsibility of Cuboid is to define 3 side lengths and implement getVolume
    // Shape3D not Solid3D, hence only getVolume is of concern for now in Shape3D.
    private final double length;
    private final double width;
    private final double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getVolume() {
        // Concrete implementation of getVolume() from Shape3D here.
        return length*height*width;
    }

}
