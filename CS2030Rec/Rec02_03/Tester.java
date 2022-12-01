// LearnMoreLink: https://www.baeldung.com/java-static-default-methods
package CS2030Rec.Rec02_03;

interface A {
    default void f() {
    };
    // Default methods in Interfaces
    // Imagine having multiple implementations of interface A (classes implements A)
    // already established. If we want to
    // Add in one new method which *SHARES THE SAME IMPLEMENTATION* without having
    // to manually
    // add in this method implementation into every single implementation, we can
    // use the default method
    // Unless overriden in implementations, all the implementations will follow the
    // definition of f() as indicated in {} of interface A

}

interface B {
    default void f() {
    };
}

interface C {
    void f();
}

interface D {
    void f();
}

/*
 * // Just like inheriting two classes, this does not compile because A and B
 * have TWO IMPLEMENTATIONS OF THE SAME-NAMED and SAME-RETURN TYPE
 * // method f.
 * class AB implements A, B {
 * // Returns Error: Duplicate Default Method
 * }
 * 
 * // Default method in one interface has same name and return type as regular
 * method of another interface.
 * class AC implements A, C {
 * // Returns Error: Default method in A conflicts with Another Method in C.
 * }
 * 
 */
class BC implements B, C {
    // Visibility issues: Must use "public void f" instead of "void f"
    @Override
    public void f() {
        // No problem with conflicting f() as long as it is overridden in the
        // implementation.
        System.out.println("Hi!");
    }
}

class CD implements C, D {

    // When implementing two interfaces with regular (non-default) methods, we must
    // still @Override
    // to add in implementation for non-implemented method f().
    @Override
    public void f() {

    }

}

public class Tester {

}
