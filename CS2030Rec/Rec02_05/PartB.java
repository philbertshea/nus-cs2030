// My guess:
// 1) CODE COMPILES
// 2) PRINT "B f" [B b = new B() --> b.f() runs type B's f()]
// FOLLOWED BY "B f" [A a = b. Instinctively, a references object of type B so a.f() still calls type B's f()]
// FOLLOWED BY "A f" [a = new A() so a.f() runs type A's f(). ]

// Answer: Correct
package CS2030Rec.Rec02_05;

class A {
    void f() {
        System.out.println("A f");
    }
}

class B extends A {
    @Override
    void f() {
        System.out.println("B f");
    }
}

public class PartB {
    public static void main(String[] args) {
        B b = new B();
        b.f(); // Print "B f"

        A a = b; // Compile time A, Runtime B
        a.f(); // Print "B f" (Follows runtime type)

        a = new A(); // Compile time A, Runtime A
        a.f(); // Print "A f"
    }
}
