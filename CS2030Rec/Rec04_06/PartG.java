// My guess: COMPILE ERROR. Because ArrayIndexOutOfBoundsException is a subtype of Exception, 
// Reason: We must order the catch blocks in the order of Most Specific to Most Generic.
// In this case, since Exception catch block is above ArrayIndexOutOfBoundsException catch block, the AIOOB catch block is Unreachable. 
// All Exceptions, including AIOOB Exception, will be caught by the first Exception catch block.

// Answer: CORRECT

package CS2030Rec.Rec04_06;

public class PartG {
    static void f() throws Exception {
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println("Caught exception in f");
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
