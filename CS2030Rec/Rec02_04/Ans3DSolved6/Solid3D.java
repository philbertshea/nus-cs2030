package CS2030Rec.Rec02_04.Ans3DSolved6;

// Using a has-a relationship, we make the density property the responsibility
// of the Material class. Solid3D now has a Shape3D, and also has a Material.

class Material {
    // According to the Single Responsibility Principle, the Material class
    // is only responsible for the density property and getDensity function.
    // Mass of 3D Object should be the responsibility of 
    private final double density;

    public Material(double density) {
        this.density = density;
    }

    public double getDensity() {
        return this.density;
    }
}

public abstract class Solid3D {
    // Solid3D has a Shape3D property and a Material property
    // Opposing to the is-a relationship where the Solid3D needs to
    // implement/extend two classes/interfaces, the has-a relationship
    // means that Solid3D contains two variables from two classes.

    private final Shape3D shape;
    private final Material material;

    public Solid3D(Shape3D shape, Material material) {
        this.shape = shape;
        this.material = material;
    }

    // Now we need to implement getters for Volume, Density and Mass
    // For a Filled Solid with mass

    public double getVolume() {
        return this.shape.getVolume(); 
        // Recall that getVolume is the responsibility of Shape3D
    }

    public double getDensity() {
        return this.material.getDensity();
        // Recall that getDensity is the responsibility of Material
    }

    public double getMass() {
        return getVolume() * getDensity();
        // getMass is the responsibility of Solid3D and can be derived by getVolume() and getDensity()
    }

}