// My guess: 1) Compiles
// 2) Since super.x is returned, 0 should be returned instead of 1.
package CS2030Rec.Rec02_05;

class A {
    protected int x = 0;
}

class B extends A {
    public int x = 1;

    public void f() {
        System.out.println(super.x); // Returns x in supertype, i.e. 0
    }
}

public class PartO {
    public static void main(String[] args) {
        B b = new B();
        b.f();
    }
}
