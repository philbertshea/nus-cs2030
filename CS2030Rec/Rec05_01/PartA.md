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

Given the following is executed
B b = new B();
b.f()
Illustrate the stack and heap memory right after the line A a = new A();

Learning Point: variables of a new Object are added to HEAP not STACK memory.
Referring to JVM.png/MemoryDiagramEdited.png, the id and name parameters are added to top block of stack, because
Argument variables taken in by constructor are ADDED TO STACK [Channel(int id, String name (reference))]
Variables belonging to new object are ADDED TO HEAP [class Channel{ int id; String name; (reference) }]

--> Since the constructor did not take in any parameter, there is no variable added to stack.

--> No need to add static class into metaspace.

**My Guess**
    A()     -   y=1 **HEAP NOT STACK**  -  -2->New Object A a   -   static class A
    f()     -   a    -2->               -
    B()     -   this -1->               -  -1->New Object B b   -   static int x = 0  
    main    -   ... b -1->              -                       -
Call Stack  -   Stack Memory            -   Heap Memory         -   Metaspace


**Answer**
*Note: Question states to assume b is already on stack. So no need to include b in stack.*

a    -2->       -   Object A a **(y=1)**-   (Static class NOT IN METASPACE)
this -1->       -   Object B b          -   **B b:** x=0 (Better to indicate location)
Stack Memory    -   Heap Memory         -   Metaspace