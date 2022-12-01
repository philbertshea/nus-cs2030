// My guess: 1) CANNOT COMPILE because f() in B tries to access a private variable in A
// Private variables can only be accessed in the SAME CLASS and SAME PACKAGE.
package CS2030Rec.Rec02_05;

class A {
    private int x = 0;
}

class B extends A {
    public void f() {
        System.out.println(x);
    }
}

public class PartK {
    public static void main(String[] args) {
        B b = new B();
        b.f();
    }
}
