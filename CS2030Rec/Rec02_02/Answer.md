--> There is no compilation error in the given program fragment as 
- any existing code that invokes A’s method prior to being inherited would still work if the code invokes B’s
method instead after B inherits A. 

--> Saying that LSP is not violated is not exactly right,
as Java does not check LSP violations during compilation (notice that the questions
asks whether the program compiles, and not whether the program violates LSP).
- LSP is violated because for parts of code which call method() and
expect an instance of A to be returned, substituting it to an instance of B
will not achieve the same result (instead, instance of B will be returned)

When we switch the method definitions, A’s method now returns **a reference to a B
object**, but overriding it with a method that returns a reference-type A 
does not guarantee that the object is a B object. 
(i.e. public A method {return new B} is OK, but @Override public B method {return new A} 
gives an error because returning an A does not guarantee return type of B)
So the overriding is not allowed and results in a compilation error.

-----------------------------------
Extension:

Now suppose Java does allow the method() of class A and B to be swapped. I Imagine
someone wrote the following code, where g() is a method defined in class B (but not
in class A).

1: void f(A a) {
2: B bNew = a.method(); // Assuming we swap method such that a.method() returns object of type B
3: bNew.g(); // g() is a method of class B
4: }

Someone else calls f(new B()). a.method() on Line 2 will invoke method() defined
in B, which returns an object of class A. So now, bNew which has a compile-time type
of B is referencing an instance of A. The next line bNew.g() invokes a method g(),
which is defined only in B, through a reference of (run-time) type A. But since bNew is
referencing to an object with run-time type A, this object does not know anything about
g()!
The following version uses a return type of Object instead.

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
public Object method() { // returns an Object instead
// Note that if A's method returns type A, the @Override B's method cannot return *a supertype of A* e.g. Object
// *** REFER TO Lec3Slide19-24.md for Details on Restrictions for Liskov Substitution Principle ***

return new B(x);
}
}

This version causes a compilation error as well. The return type of B’s method cannot
not be a supertype of the return type of A’s method. If this was allowed, then consider
the code below, where h() is a method that is defined in A.
void f(A a) {
A aNew = a.method();
aNew.h();
}

Now someone calls f(new B()). a.method() on Line 2 will invoke method() defined
in B, which returns an object of class Object. So now, aNew which has a compile-
time type of A is referencing to an instance of B. This actually sounds plausible, since
aNew is referencing to an object of type B, and calling h() on an instance of B should
work! The problem, however, is that the return type of B’s method() is Object, and
therefore there is no guarantee that B’s method() will return an instance of B. Indeed,
the method could return a String object, for instance, in which case, Line 2 does not
make sense anymore.