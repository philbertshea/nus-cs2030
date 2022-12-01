// My guess
// 1) Code compiles since there is no UNAUTHORISED ACCESS BY COMPILE TYPE.
// 2) PRINT "A f \n B f" [b.f(), B b = new B()]
// FOLLOWED BY "A f \n B f" [A a = b. a.f() runs type B's f() since runtime type of a is B]

package CS2030Rec.Rec02_05;

class A {
    void f() {
        System.out.println("A f");
    }
}

class B extends A {
    void f() {
        super.f();
        System.out.println("B f");
    }
}

public class PartC {
    public static void main(String[] args) {
        B b = new B();
        b.f(); // Runs Type B's f(): "A f B f"
        A a = b; // Compile-time type A, runtime type B
        a.f(); // Runs Type B's f(): "A f B f"
    }

}
