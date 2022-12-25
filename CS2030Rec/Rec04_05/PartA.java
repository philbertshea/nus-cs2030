package CS2030Rec.Rec04_05;

class B {
    void f() {
        int x = 0;
        class A {
            int y = 0;

            A() {
                y = x + 1;
            }
        }
        A a = new A();
    }
}

public class PartA {

}
