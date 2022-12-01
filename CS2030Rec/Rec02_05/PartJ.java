// My guess: 
// 1) Does not lead to compilation errors.
// Though A.f()/B.f() is preferred for static method access,
// The use of an instance to access a static method DOES NOT LEAD TO A COMPILATION ERROR.
// 2) PRINTS: "A f" (A.f() calls f() of type A directly)
// Followed by: "B f" (B.f() calls f() of type B directly)
// Followed by: "B f" (a is of runtime type B)
// Followed by: "B f" (b is of runtime type B)

// Answer:
// 1) COMPILES
// 2) PRINTS "A f" --> "B f" --> ** "A f"  --> "B f"
// Though a is of RUNTIME TYPE B, a.f() INSTRUCTS THE COMPUTER TO FIND F() of Type A
// On compilation. As f() is static, the RUNTIME TYPE OF THE VARIABLE DOES NOT MATTER.

// Learning Point: 1) For static methods, though instance approach of method calls are 
// discouraged, they DO NOT RESULT IN ANY COMPILATION ERROR.
// 2) For static methods, the COMPILE-TIME TYPE is strictly followed for deciding between overridden methods.

package CS2030Rec.Rec02_05;

class A {
    static void f() {
        System.out.println("A f");
    }
}

class B extends A {
    static void f() {
        System.out.println("B f");
    }
}

public class PartJ {
    public static void main(String[] args) {
        B b = new B();
        A a = b;
        A.f();
        B.f();
        a.f();
        b.f();
    }
}
