// My guess: The compile-time type of a is A (Compile-time means As Declared Explicitly), 
// while the runtime type of a is B (Runtime means Type of Variable Referenced).

// 1) CODE COMPILES [For compilation, the compiler checks whether there is any UNALLOWED ACCESS BASED ON THE COMPILE TYPE]
// 2) Actual OUTPUT follows the RUNTIME TYPE.
// OUTPUT IS "A f" [From b.f() since B extends A and inherits A's f() implementation]
// FOLLOWED BY "A f" [From a.f(). A a = b; Follow Runtime Type of B. Same as above: b.f() inherits that of A.]

// Answer: Correct.

package CS2030Rec.Rec02_05;

class A {
    void f() {
        System.out.println("A f");
    } 
}

class B extends A {

}

public class PartA {
    public static void main(String[] args) {
        B b = new B();
        b.f(); // PRINT "A f"
        A a = b; // Compile-time type A, Runtime type B. Follow RUNTIME TYPE of B.
        a.f(); // PRINT "A f"
    }    
}
