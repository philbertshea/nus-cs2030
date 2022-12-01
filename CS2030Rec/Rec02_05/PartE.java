// My guess: 1) Code WILL NOT COMPILE because type A's f() 
// is of return type void, while type B's f() is of return
// type int. MUST BE THE SAME RETURN TYPE.
/* ERROR:
 * error: f() in B cannot override f() in A
    int f() {
        ^
  return type int is not compatible with void
 */

 // LEARNING POINT: TO OVERRIDE, MUST HAVE SAME RETURN TYPE.


package CS2030Rec.Rec02_05;

class A {
    void f() {
        System.out.println("A f");
    }
}

class B extends A {
    /*
    int f() {
        System.out.println("B f");
        return 0;
    }
    */
}

public class PartE {
    public static void main(String[] args) {
        B b = new B();
        b.f();

        A a = b;
        a.f();
    }
}
