// What if we want a Hollow Cuboid? i.e. Cuboid with no mass/density.

package CS2030Rec.Rec02_04;

interface Shape3D {
    // Shape3D only contains the getVolume method, which means it applies to any 3D
    // Object with or without mass/density.
    public double getVolume();
}

abstract class Solid3D implements Shape3D {
    // Solid3D contains implementations regarding density and mass.
    private final double density;

    protected Solid3D(double density) {
        this.density = density;
    }

    public abstract double getDensity();

    public double getMass() {
        return getMass() * getDensity();
    }
}

// Cuboid represents any cuboid, Hollow Cuboid or Filled Cuboid
class Cuboid implements Shape3D {
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
        return length * width * height;
    }
}

// In this case, SolidCuboid needs to extend both Cuboid and Solid3D (with density).
// However, multiple inheritance is not allowed. To solve this problem, instead of modelling is-a relationship,
// We should use a has-a relationship. 

// class SolidCuboid implements Cuboid, Shape3D is NOT ALLOWED.
// We cannot have Cuboid and SolidCuboid as two classes AND expect SolidCuboid to inherit
// the Cuboid class AND another interface Shape3D.

// This technical restriction comes from using the is-a relationship, i.e. 
// the idea of class X implements/extends Y [X is a subtype of Y]
// Instead, let's try the has-a relationship! i.e. class X { variable Y } [X has variable of type Y]

