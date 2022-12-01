// My guess: 1) COMPILES.
// 2) returns x in class B, i.e. 1.

package CS2030Rec.Rec02_05;

class A {
    protected int x = 0;
}

class B extends A {
    public int x = 1;

    public void f() {
        System.out.println(x); // refers to x in B (i.e. 1)
    }
}

public class PartN {
    public static void main(String[] args) {
        B b = new B();
        b.f();
    }
}
