package CS2030Rec.Rec01_01;

public class Q {
    public void changeP (P p) {
        // p.x = 1;  
        // In Q, We cannot change the value of a private variable, if the object is implemented in another class (P)
        // The abstraction barrier sits between the client and the implementer. 
        // In this case, class P is the implementer, while Q is the client making use of p (Object of P)

        // The abstraction barrier is present and prevents the access of private variables from another class.
    }
}
