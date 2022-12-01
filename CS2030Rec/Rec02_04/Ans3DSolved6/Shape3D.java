package CS2030Rec.Rec02_04.Ans3DSolved6;

public interface Shape3D {
    // Shape3D is an interface which only has the responsibility of getVolume
    // The implementation of getVolume depends on the type of Shape, therefore
    // There is no default method here.
    // E.g. Cuboid implements Shape3D [is-a relationship] and contains the concrete
    // implementation for getVolume()
    public double getVolume();
}
