**Compile time or Runtime type?**

class Circle implements Shape, Printable {...}
interface Shape { void getArea() {...} }
interface Printable { void print() {...} }

Circle c = new Circle(...); // Compile-time type Circle, Runtime type Circle
Shape s = c; // Compile-time type Shape, Runtime type Circle
Printable p = c; // Compile-time type Printable, Runtime type Circle

--- WILL COMPILE (Based on Compile-time Type) ---
c.getArea();
c.print();
s.getArea();
p.print();

--- WILL NOT COMPILE (Based on Compile-time Type) ---
s.print();
p.getArea();

- At the moment of compilation, the Compiler checks whether there is UNALLOWED ACCESS of methods BASED ON COMPILE-TIME TYPE.
- s is of Compile-time type Shape so it cannot access print(). 
- p is of Compile-time type Printable so it cannot access getArea().
- This is despite the fact that s and p reference an instance (c) of type Circle.


------------------------------------------------------------------

class A { void f() { System.out.println("A f"); } }
class B extends A { void f() { System.out.println("B f"); }  void g() {...} }

--- WILL COMPILE ---
B b = new B();  // b Compiles as B, Runs as B
1: b.f(); 

A a = b;  // a Compiles as A, Runs as B
2: a.f();

a = new A();  // a Compiles as A, Runs as A
3: a.f();

--- WILL NOT COMPILE ---
A a = b;   // a compiles as A, Runs as B
4: a.g();

- On compilation: FOLLOW COMPILE-TIME TYPE
- At the moment of compilation, codechunks 1-3 will compile because BOTH A and B can access f() though different f will be accessed.
- However, codechunk 4 will NOT COMPILE. a is of Compile-time type A so it cannot access g().
- This is despite the fact that a references an instance (b) of type B.

- On running: FOLLOW RUNTIME TYPE
- Codechunk 1 prints "B f". (Runtime type B, calls type B's f().)
- Codechunk 2 prints "B f". (Runtime type B, calls type B's f().)
- Codechunk 3 prints "A f". (Runtime type A. calls type A's f().)
