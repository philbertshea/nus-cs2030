// My guess: 1) COMPILES as no unreachable code
// 2) PRINTS Before f --> Caught AIOOB Exception in f --> After f
// Reason: The exception is caught and handled in f. Not passed back to main. Remainder of try block in main is executed.

package CS2030Rec.Rec04_06;

public class PartH {
    static void f() throws Exception {
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught AIOOB exception in f");
        } catch (Exception e) {
            System.out.println("Caught exception in f");
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