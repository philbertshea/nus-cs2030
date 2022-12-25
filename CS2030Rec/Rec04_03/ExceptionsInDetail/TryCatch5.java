// In TryCatch1-4, we used Checked Exceptions.
// Let's try if the behaviour of Unchecked Exceptions is the same.

package CS2030Rec.Rec04_03.ExceptionsInDetail;
import java.io.*;

public class TryCatch5 {

    public static void noHandling() {

        System.out.println("\n\n---No Handling---");
        // Unchecked Exception, hence NO COMPILE ERROR
        // Upon execution, the First Exception appears and ends the execution of the
        // code

        int num[] = { 1, 2, 3, 4 };
        System.out.println(num[5]); // ArrayIndexOutOfBoundsException
        num[4] = 10 / 0; // ArithmeticException
    }

    public static void catchIndex() {
        try {
            int a = 10/0;
            // Arithmetic Exception
            // No Compile ERROR. But Runtime ERROR: Unhandled Exception.

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("ArrayIndexOutOfBounds caught and handled!");
            ex.printStackTrace();
        } /* catch (IOException ex) {
            System.out.println("COMPILE ERROR: Unreachable. IOException is not expected from the try block.");
        } */
    }

    public static void catchIndexArith() {
        System.out.println("\n\n---Catch Index and Arith---");
        try {
            int num[] = { 1, 2, 3, 4 };
            System.out.println(num[5]); // ArrayIndexOutOfBoundsException
            num[4] = 10 / 0; // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds caught and handled!");
            e.printStackTrace();

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic caught and handled!");
            e.printStackTrace();
        }
    }

    public static void catchRuntime() {
        System.out.println("\n\n---Throw All---");
        try {
            int num[] = { 1, 2, 3, 4 };
            num[4] = 10 / 0; // ArithmeticException
            System.out.println(num[5]); // ArrayIndexOutOfBoundsException
        } catch (RuntimeException e) {
            System.out.println("Runtime caught and handled!");
            e.printStackTrace();
        }
    }

    public static void throwAll() throws ArrayIndexOutOfBoundsException, ArithmeticException, Exception {
        // It is OK for the method header to throw multiple exceptions, even if some exceptions are subtypes of others within the method header.
        System.out.println("\n\n---Throw Index, Arith and Exception---");
        try {
            int num[] = { 1, 2, 3, 4 };
            System.out.println(num[5]); // ArrayIndexOutOfBoundsException
            num[4] = 10 / 0; // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds thrown to main!");
            e.printStackTrace();
            throw e;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic caught and thrown to main!");
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            System.out.println("Other Exceptions thrown to main!");
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        // noHandling(); // Exception: ArrayIndexOutOfBoundsException
        System.out.println("After noHandling");
        // catchIndex(); // Exception: ArithmeticException
        System.out.println("After catchIndex");
        catchIndexArith(); // ArrayIndexOutOfBounds caught and handled within the method.
        System.out.println("After catchIndexArith: No Exceptions passed back to main");
        catchRuntime(); // Arithmetic caught and handled within the method.
        System.out.println("After catchRuntime: No Exceptions passed back to main");
        
    }

}
