package CS2030Rec.Rec04_05;

class B {
    static int x = 0;

    void f() {
        A a = new A();
    }

    static class A {
        int y = 0;

        A() {
            y = x + 1;
        }
    }
}

public class PartB {
    
}
