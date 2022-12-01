// My Guess: Should return the same result as Part C.

// Answer: WRONG.
// this.f() is DIFFERENT FROM super.f(). this.f() is a call to class B's own f()
// [This refers to the existing class, class B]. When this.f() is used in f() itself,
// It will recursively call f() and never ends.
// 1) Code will COMPILE
// 2) PRINT StackOverflow Error.

package CS2030Rec.Rec02_05;

class A {
    void f() {
        System.out.println("A f");
    }
}

class B extends A {
    void f() {
        this.f(); // Recursively calls itself and Never ends.
        System.out.println("B f");
    }
}

public class PartD {
    public static void main(String[] args) {
        B b = new B();
        b.f();
        A a = b;
        a.f();
    }
}
