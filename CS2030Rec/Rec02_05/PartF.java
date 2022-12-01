// My guess: CANNOT COMPILE because different parameters.

// Answer: 1) the computer treats it as an OVERLOADED method.
// HOWEVER CANNOT COMPILE BECAUSE a is of COMPILE-TIME TYPE A which has no access to f(int).

// LEARNING POINT: it is OK to overload a same-named method with two implementations as long
// as they have different number/type of parameters. 
// OVERLOADING NOT OVERRIDING WHEN params are different.

package CS2030Rec.Rec02_05;

class A {
    void f() {
        System.out.println("A f");
    }
}

class B extends A {

    void f(int x) {
        System.out.println("B f");
    }
}

public class PartF {
    public static void main(String[] args) {
        B b = new B();
        b.f(); // Prints "A f" if it compiles
        b.f(0); // "B f"
        A a = b;
        a.f(); // "A f"
        // a.f(0); // a is of COMPILE-TIME TYPE A hence NO access to f(int x)
    }
}
