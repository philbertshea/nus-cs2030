package CS2030Rec.Rec05_01;

class B1 {
    static int x = 0;
    void f() {
        A1 a = new A1();
    }
    static class A1 {
        int y = 0;
        A1() {
            y = x + 1;
        }
    }
}

class B2 {
    void f() {
        int x = 0;

        class A2 {
            int y = 0;
            A2() {
                y = x + 1;
            }
        }

        A2 a = new A2();
    }   
}

class A3 {
    int x = 1;

    void f() {
        int y = 2;
        class B3 {
            void g() {
                x = y;
            }
        }
        B3 b = new B3();
        b.g();
    }
}



public class App {

    public static void main(String[] args) {
        B1 b1 = new B1();
        b1.f();

        B2 b2 = new B2();
        b2.f();

        // Not possible to create an instance of class B3, because it is nested in class A.
        B3 b3 = new B3();
        b3.f();
    }
}
