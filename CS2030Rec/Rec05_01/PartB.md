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

Given the following is executed
B b = new B();
b.f()
Illustrate the stack and heap memory right after the line A a = new A();

Learning Point: 

**My guess:**

    A()     -   this-2->                - -2->Object A a(y=1)   -
    f()     -   x=0   a-2->             -                       -
    B()     -   this-1->                - -1->Object B b        -
    main    -   ... b -1->              -                       -
Call Stack  -   Stack Memory            -   Heap Memory         -   Metaspace

**Answer:**
    a-2->          -   -2->Object A a(y=1, x=0, B.this-3->) -
    x=0
    this-1->       -   -1-> -3->Object B b                  -
   Stack Memory    -   Heap Memory                          -   Metaspace
