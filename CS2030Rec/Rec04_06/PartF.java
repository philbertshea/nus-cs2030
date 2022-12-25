// My Guess: 1) COMPILES since A) no undeclared unchecked exceptions, B) no unreachable code and C) no explicit exceptions thrown but undeclared in method header.
// PRINTS: Before f --> Caught AIOOB Exception in f --> After f
// Reason: because the exception thrown in f() is caught by the second catch block, it is not passed back to the main block.
// The main block runs the remaining of the try block and does not catch any exception in the main block.

// Answer: CORRECT

package CS2030Rec.Rec04_06;

public class PartF {
    static void f() throws Exception {
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IA exception in f");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught AIOOB exception in f");
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
