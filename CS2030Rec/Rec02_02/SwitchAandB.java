package CS2030Rec.Rec02_02;

class A {
    int x;

    A(int x) {
        this.x = x;
    }

    public A method() {
        System.out.println("Type A.method returns new instance of Type B");
        return new B(x);
    }
}

class B extends A {
    B(int x) {
        super(x);
    }

    @Override
    public A method() {
        System.out.println("Type B.method returns new instance of Type A");
        return new A(x);
    }
}

// To avoid type mismatch (Override methods must have the same
// return type as the original). we should use A as the common return type
// (Since B is a subtype of A, returning B(x) in A method() has no adverse
// effect)

// It is allowed to do A method() {return B(x)} BUT NOT ALLOWED to do B method()
// {return A(x)}
// Because B is a subtype of A. Not all A(x) is of subtype B.

public class SwitchAandB {

    public static void main(String[] args) {
        A a = new A(10);
        System.out.println(a.method());  // Type A.method returns new instance of B

        B b = new B(10);
        System.out.println(b.method()); // Type B.method returns new instance of A
    }

    // There seems to be no problem with compilation even after switching as above.
    // This is because 
}
