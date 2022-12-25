// My guess: 1) COMPILES because IllegalArgumentException is A) an unchecked runtime exception B) even so, it is explicitly stated in the method headers and caught.
// 2) PRINTS Before f --> Caught in f --> After f
// Reason: THe exception thrown in try block of f() is caught and handled in catch block. 
// Therefore, the exception is not passed to the main block. Code in main block continues to run until end, and catch block in main is not executed.

// Answer: CORRECT. 

package CS2030Rec.Rec04_06;

public class PartB {
    static void f() throws IllegalArgumentException { // B <--
        try {
            throw new IllegalArgumentException(); // C
        } catch (IllegalArgumentException e) {
            System.out.println("Caught in f"); // D
        }
        // E-->
    }

    public static void main(String[] args) {
        // Start
        try {
            System.out.println("Before f"); // A
            f(); // B -->
            // E <--
            System.out.println("After f"); // F
        } catch (Exception e) {
            System.out.println("Caught in main");
        }
        // G end.
    }
}
