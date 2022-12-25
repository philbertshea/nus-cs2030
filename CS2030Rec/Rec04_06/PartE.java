// My guess: 1) COMPILES because there is A) no undeclared unchecked exceptions, B) unreachable code or C) explicitly thrown exceptions left undeclared in method header.
// 2) PRINTS Before f --> Caught in main
// ArrayIndexOutOfBoundsException is not a subtype of IllegalArgumentException hence it is not caught in the catch block of f.
// This means it is passed to the caller block, main block. Main block catches it and skips the remaining code in the try block.
// Should not give a compile error because f() throws Exception, and ArrayIndexOutOfBoundsException is a subtype of Exception. Therefore, it is declared.

// Answer: CORRECT

package CS2030Rec.Rec04_06;

public class PartE {
    static void f() throws Exception {
        // C <--
        try {
            throw new ArrayIndexOutOfBoundsException(); // D
        } catch (IllegalArgumentException e) {
            System.out.println("Caught in f");
        }
        // E --> ArrayIndexOutOfBoundsException <: Exception is thrown from the f() to the next caller block in call stack, i.e. main block
    }

    public static void main(String[] args) { 
        // Start
        try { // A
            System.out.println("Before f"); // B
            f(); // C -->
            // E <-- ArrayIndexOutOfBoundsException is thrown to main
            System.out.println("After f");
        } catch (Exception e) {
            System.out.println("Caught in main"); // F
        }
        // G
        // End
    }
}
