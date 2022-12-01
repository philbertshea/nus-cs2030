// My guess: 1) COMPILES because protected access modifier: accessible in SAME PACKAGE AND as subclass IN OTHER PACKAGES
// 2) Output: PRINTS 0.
package CS2030Rec.Rec02_05;

class A {
    protected int x = 0;
}

class B extends A {
    public void f() {
        System.out.println(x); // refers to x in A i.e. 0
    }
}

public class PartM {
    public static void main(String[] args) {
        B b = new B();
        b.f();
    }
}
