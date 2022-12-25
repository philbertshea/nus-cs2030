// My guess: 1) COMPILES because IllegalArgumentException is A) an unchecked runtime exception B) even so, it is explicitly stated in the method headers and caught.
// 2) PRINTS Before f --> Before throw --> Caught in f --> After f
// Reason: THe exception thrown in try block of f() is caught and handled in catch block. 
// Therefore, the exception is not passed to the main block. Code in main block continues to run until end, and catch block in main is not executed.


// Answer: WRONG. "After throw" is an unreachable code which flags a COMPILE ERROR.

package CS2030Rec.Rec04_06;

public class PartA {
    static void f() throws IllegalArgumentException {
        try {
            System.out.println("Before throw");
            throw new IllegalArgumentException();
            System.out.println("After throw");
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
