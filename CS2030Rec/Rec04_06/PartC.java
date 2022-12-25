// My guess: 1) COMPILES: A) No checked assumption that is undeclared.  B) No unreachable code.
// 2) PRINTS: Before f --> Caught in main
// Exception thrown in f() try block is not caught by catch block (specific for IllegalArgumentException)
// Therefore, exception is passed back to main (caller), which catches it. Code after f() is not executed.

// Answer: WRONG.
// Does not compile, because Exception thrown in f() is NOT EXPLICITLY DECLARED IN METHOD HEADER.

package CS2030Rec.Rec04_06;

public class PartC {
    static void f() throws IllegalArgumentException {
        try {
            throw new Exception();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught in f");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Before f");
            f();
            System.out.println("After f");
        } catch (Exception e) {
            System.out.println("Caught in main");
        }
    }
}
