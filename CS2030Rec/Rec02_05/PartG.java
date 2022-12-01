// My guess: 1) COMPILES because there is no unauthorised access of functions unique to one type.
// 2) Prints "B f" [a has a runtime type of B]
// Followed by "B f" [b.f() calls type B's f()]
package CS2030Rec.Rec02_05;

class A {
    public void f() {
        System.out.println("A f");
    }
}

class B extends A {
    public void f() {
        System.out.println("B f");
    }
}

public class PartG {
    public static void main(String[] args) {
        B b = new B();
        A a = b;
        a.f(); // Runtime type of B
        b.f();
    }
}
