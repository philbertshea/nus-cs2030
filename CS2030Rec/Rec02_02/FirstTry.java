package CS2030Rec.Rec02_02;

class A {
    int x;

    A(int x) {
        this.x = x;
    }

    public A method() {
        return new A(x);
    }
}

class B extends A {
    B(int x) {
        super(x);
    }

    @Override
    public B method() {
        return new B(x);
    }
}

public class FirstTry {

    public static void main(String[] args) {
        A a = new A(10);
        System.out.println(a.method().x);

        B b = new B(10);
        System.out.println(b.method().x);
    }
}
