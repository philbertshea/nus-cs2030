// My guess: 1) COMPILES because there is no unchecked exception left undeclared, unreachable code or explicit exceptions undeclared at method header.
// 2) PRINTS Before f --> Caught in f --> After f 
// Since IllegalArgumentException is a subtype of Exception, the exception thrown in caught in catch block of f() and handled.
// The Exception is not passed on to the caller, main block. Therefore, After f is printed and catch block in main is not executed.

// Answer: CORRECT

package CS2030Rec.Rec04_06;

public class PartD {
    static void f() throws Exception {
        // C <--
        try {
            throw new IllegalArgumentException(); // D
        } catch (Exception e) {
            System.out.println("Caught in f"); // E
        }
        // F -->
    }

    public static void main(String[] args) { // Start
        // A
        try { 
            System.out.println("Before f"); // B
            f(); // C -->
            // F <--
            System.out.println("After f"); // G
        } catch (Exception e) {
            System.out.println("Caught in main");
        }
        // H
        // End
    }
}
