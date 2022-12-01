// My guess: CANNOT COMPILE
// a has a Compile-time type of A. a.f() is not allowed as 
// f() in type A is a Static method, meaning it does not belong to any individual instance of A
// f() in type A can only be called without reference to any specific instance of A.

// Answer: CANNOT COMPILE
// Non-static (INSTANCE) implementation of f() in type B CANNOT OVERRIDE a static implementation in A. 
package CS2030Rec.Rec02_05;

class A {
    static void f() {
        System.out.println("A f");
    }
}

class B extends A {
    /*
    public void f() {
        System.out.println("B f");
    }
    */
}

public class PartI {
    public static void main(String[] args) {
        B b = new B();
        A a = b;
        a.f(); // Type A's f() *should be accessed statically*. But this does not give a COMPILE ERROR.
        b.f();
}
