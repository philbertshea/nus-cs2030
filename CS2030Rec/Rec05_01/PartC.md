class A {
    int x = 1;

    void f() {
        int y = 2;
        class B {
            void g() {
                x = y;
            }
        }
        B b = new B();
        b.g();
    }
}

Given the following is executed
B b = new B();
b.f()
Illustrate the stack and heap memory right after the line A a = new A();

--> Do not store variables of an instance in Stack Memory (Store with instance in Heap)
--> OK to store variables from a method in Stack Memory

??

*Compile Error because class B is nested in class A, i.e. without creating an instance of A, we cannot access class B.*

**My guess:**

    g()     -   x=2                     -                       -
    B()     -   this -2->               -   -2->Object B b      -
    f()     -   y=2   b -2->            -                       -
    B()     -   this -1->               -   -1->Object B b      -
    main    -   ... b -1->              -                       -
Call Stack  -   Stack Memory            -   Heap Memory         -   Metaspace

**Answer:**

a                       -   -2->Object A a(y=1, x=0, B.this-3->)    -
x=0                     -                                           -
this -1->               -   -3-> -1->Object B b                     -
Stack Memory            -   Heap Memory                             -   Metaspace