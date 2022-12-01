package CS2030Rec.Rec01_01;

public class P {
    private int x;

    public void changeSelf() {
        x = 1;
    }

    // The abstraction barrier is NOT broken when one object of type P accesses the properties of another object of the same type P
    // As instructed in changeAnother. This is because P is the sole implementer. The barrier between the client (Q) and implementer (P) is not broken.

    public void changeAnother(P p) {
        p.x = 1;
    }
}



