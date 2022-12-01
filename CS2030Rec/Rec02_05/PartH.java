// My guess: 1) CAN COMPILE: No unauthorised access
// 2) PRINT "B f" (runtime type of B)
// Followed by "B f"

// Answer: CANNOT COMPILE. Recall that a has a COMPILE-TIME TYPE OF A.
// Since type A's f() is private, IT CANNOT BE ACCESSED IN PartH. 
// Therefore, a.f() returns a COMPILATION ERROR.
package CS2030Rec.Rec02_05;

class A {
    // Recall that private modifier restricts access to SAME CLASS, SAME PACKAGE
    // ONLY.
    private void f() {
        System.out.println("A f");
    }
}

class B extends A {
    public void f() {
        System.out.println("B f");
    }
}

public class PartH {
    public static void main(String[] args) {
        B b = new B();
        A a = b;
        // a.f(); // f() of type A is private. Method is not visible error.
        b.f();
    }
}
