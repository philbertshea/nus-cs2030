// My guess: 1) COMPILES. Super.x references class A. 

// Answer: x still has restricted access because x is a private variable.
package CS2030Rec.Rec02_05;

class A {
    private int x = 0;
}

class B extends A {
    public void f() {
        System.out.println(super.x);
    }
}

public class PartL {
    public static void main(String[] args) {
        B b = new B();
        b.f();
    }

}
