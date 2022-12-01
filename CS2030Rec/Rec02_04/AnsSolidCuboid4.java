package CS2030Rec.Rec02_04;

public class AnsSolidCuboid4 {
    private final double length;
    private final double width;
    private final double height;
    private final double density;

    public AnsSolidCuboid4(double length, double width, double height, double density) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.density = density;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }

    public double getDensity() {
        return this.density;
    }

    public double getMass() {
        return this.getDensity() * this.getVolume();
    }
}
