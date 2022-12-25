package CS2030Rec.Rec04_03.ExceptionsInDetail;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class TryCatch2 {
    public static void checkException1() {
        try {
            System.out.println("Check Exception 1. IOException --> FileNotFoundException (Unreachable error)\n");
            FileInputStream file = new FileInputStream("SomeFile");
            byte x = (byte) file.read(); // read() is a method in FileInputStream
        } catch (IOException i) {
            // Purpose: Check the second line. HOWEVER, FileNotFoundException is a subtype
            // of IOException, hence Exceptions in the first line are all "trapped" in this
            // block and do not get passed down to the second catch block.
            System.out.println("IOException Caught!");
            i.printStackTrace();
        } /*
           * catch (FileNotFoundException f) { // Purpose: Check the first line.
           * System.out.println("FileNotFoundException Caught!");
           * f.printStackTrace();
           * }
           */

        // If we use a separate catch block which catches FileNotFoundException,
        // BEHIND IOEXCEPTION, there is a COMPILE ERROR.
        // Unreachable catch block for FileNotFoundException. It is already handled by
        // the catch block for IOException
    }

    public static void checkException2() {
        try {
            System.out.println("Check Exception 2: FileNotFoundException --> IOException\n");
            FileInputStream file = new FileInputStream("SomeFile");
            byte x = (byte) file.read();
        } catch (FileNotFoundException f) { // Purpose: Check first line
            System.out.println("FileNotFoundException Caught!");
            f.printStackTrace();
        } catch (IOException i) { // Purpose: Check second line
            System.out.println("IOException Caught!");
            i.printStackTrace();
        }

        // There is no error here because we order the catch-blocks from the SUBTYPE
        // (Most specific) FileNotFoundException
        // to the SUPERTYPE (Most general) IOException.

        // If we reorder the positions of FileNotFoundException and IOException, AND
        // ONLY INCLUDE THE FILEINPUTSTREAM LINE IN THE TRY BLOCK
        // Instead of a compilation error, There is a compile warning at IOException
        // Unreachable catch block for IOException. Only more specific exceptions are
        // thrown and they are handled by previous catch block(s)

        // This is because the first line will only return FileNotFoundException, hence
        // there is no need for the second catch block.
        // The second catch block serves the purpose of catching exceptions from the
        // second line.
    }

    public static void checkException3() {
        try {
            System.out.println("Order catch blocks from the most specific to the most general.");
            /*
             * In this case, Arithmetic, IllegalState and NullPointer all extend
             * RuntimeException.
             * Therefore these three subtypes of RuntimeException can be ordered in any
             * priority
             * but they must be above RuntimeException.
             */

            // Toggle between the three methods.
            // Note that if two or more methods are chosen, whenever the first method throws an Exception,
            // The exception is immediately passed to the corresponding catch block.
            // Therefore, the subsequent methods in the try block are not executed.

            // throwNullPointer();
            System.out.println("Print Me if NO EXCEPTION YET at this Point: No NullPointerException");
            // throwArithmetic();
            System.out.println("Print Me if NO EXCEPTION YET at this Point: No ArithmeticException");
            throwIllegalState();
            System.out.println("Print Me if NO EXCEPTION : No IllegalStateException");
            System.out.println("NO exception at all!");

        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught!");
        } catch (IllegalStateException f) {
            System.out.println("IllegalStateException caught!");
        } catch (NullPointerException g) {
            System.out.println("NullPointerException caught!");
        } catch (RuntimeException h) {
            System.out.println("RuntimeException (Other than Arithmetic, IllegalState, NullPointer) caught!");
            h.printStackTrace();
        } catch (Exception j) {
            System.out.println("Exception caught!");
        }
    }

    public static void throwNullPointer() throws NullPointerException {
        Integer number = null;

        if (number > 0) { // Attempt to access a null pointer
            System.out.println("Positive number");
        }
    }

    public static void throwArithmetic() throws ArithmeticException {
        int num = 10 / 0; // Arithmetic error
        System.out.println("Print Me if there is No Error at the first line.");
        if (num > 5) {
            System.out.println("10 divided by 0 is greater than 5.");
        }
    }

    public static void throwIllegalState() throws IllegalStateException {
        List<String> names = new ArrayList<>();
        names.add("Eric");
        names.add("Sydney");

        Iterator<String> iterator = names.iterator();

        // IllegalStateException is thrown here because 
        while (iterator.hasNext()) {
            iterator.remove();
        }
    }

    public static void main(String[] args) {
        checkException1();
        checkException2();
        checkException3();
    }
}
