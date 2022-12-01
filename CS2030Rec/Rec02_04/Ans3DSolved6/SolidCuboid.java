package CS2030Rec.Rec02_04.Ans3DSolved6;

public class SolidCuboid extends Solid3D {
    // Do we need to define the properties shape/cuboid and material here?
    // NO. Because these are inherited from Solid3D already.

    // Think about it.
    // Do we want to use Shape3D and Material?
    // Since we are certain that a SolidCuboid will have a Shape3D of Cuboid,
    // (Recalling that Cuboid implements Shape3D),
    // we can just replace Shape3D shape with Cuboid cuboid

    public SolidCuboid(Cuboid cuboid, Material material) {
        super(cuboid, material); // This is accepted because Cuboid IS-A Shape-3D
    }

    // An alternative constructor would be to directly input length, width, height and density.

    public SolidCuboid(double length, double width, double height, double density) {
        this(new Cuboid(length, width, height), new Material(density));
        // We can also use super(..., ...)
    }
}
