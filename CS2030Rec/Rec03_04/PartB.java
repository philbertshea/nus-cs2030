package CS2030Rec.Rec03_04;

class B<T> {
    // My guess: COMPILES. There should not be any problem
    // With defining an instance variable and a static variable
    // within a generic class.

    // Answer: DOES NOT COMPILE. Error: Cannot make a static reference to the
    // non-static type T
    // Note that B takes in different type parameters T in different calls for class
    // B.
    // Therefore, the computer cannot decide which type T to use for the static
    // variable static T y.
    // (Recall that static variables are shared across all instances of B and is not
    // linked to a specific instance.)

    T x;
    static T y;
    static int z;
}

public class PartB {

    public static void main(String[] args) {
        B<Integer> b = new B<>();
        System.out.println("instance variable b.x is of type Integer");

        B<String> b2 = new B<>();
        System.out.println("instance variable b2.x is of type String");

        System.out.println(
                B.y + "y belongs to class B, not any instance b or b2. Then what is the type of y? Integer or String?");
    }
}
