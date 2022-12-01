// My attempt
package CS2030Rec.Rec02_04;

public class Cuboid2 implements SomeMass1 {
    private final double length;
    private final double width;
    private final double height;
    private final double density;

    public Cuboid2(double length, double width, double height, double density) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.density = density;
    }

    @Override
    public double getVolume() {
        return length*width*height;
    }

    @Override
    public double getDensity() {
        return density;
    }

    public double getMass() {
        return density*length*width*height;
    }
}
