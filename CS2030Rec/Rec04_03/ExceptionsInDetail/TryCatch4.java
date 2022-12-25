// In contrast to TryCatch2, we can catch multiple exceptions in one catch block.
// However, if AException <: BException, we cannot stack AException and BException into one line in one catch block.
// AException|BException and BException|AException results in a COMPILE ERROR.

package CS2030Rec.Rec04_03.ExceptionsInDetail;

import java.io.*;

public class TryCatch4 {

    // Requirement for successful compilation:
    // 1. Both FileNotFoundException and IOException must eventually be handled:
    // - Handle within the catchXX method: try ... catch ... and NOT THROW.
    // - Throw back to the previous method in the call stack to handle. 
    // (In this case, control goes back to the main block)
    // 2. If an exception is THROWN, the method must declare it in the method header. 
    // e.g. public static void throwIO() throws IOException {...}

    /*
    public static void noHandling() {
        FileInputStream file = new FileInputStream("SomeFile"); // Gives FileNotFoundException
        byte x = (byte) file.read(); // Gives IOException
        // Two compile errors: Unhandled Exception FIleNotFoundException and Unhandled Exception IOException
    }
    */

    /*
    public static void catchFileNotFound() {
        try {
            FileInputStream file = new FileInputStream("SomeFile");
            byte x = (byte) file.read(); // Compile ERROR: IOException is not handled.
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFoundException Caught!");
        }
    }
    */

    public static void catchIO() {
        System.out.println("\n\nRunning catchIO");
        try {
            FileInputStream file = new FileInputStream("SomeFile"); // Gives FileNotFoundException which is a subtype of IOException
            System.out.println("NO FileNotFoundException"); // This only runs if no exception is present at the first line.
            byte x = (byte) file.read(); // Gives IOException
            System.out.println("NO IOException"); // This only runs if no exception is present at the second line.
        } catch (IOException f) {
            // Since FileNotFoundException is a type of IOException, catch IOException does not give any Compile Error.
            System.out.println("IOException Caught!");
            f.printStackTrace();
        }

    }

    public static void catchException() {
        System.out.println("\n\nRunning catchException");
        try {
            FileInputStream file = new FileInputStream("SomeFile"); // Gives FileNotFoundException <: IOException <: Exception
            System.out.println("NO FileNotFoundException"); // This only runs if no exception is present at the first line.
            byte x = (byte) file.read(); // Gives IOException <: Exception
            System.out.println("NO IOException"); // This only runs if no exception is present at the second line.
        } catch (Exception f) {
            // Since FileNotFoundException and IOException are subsets of Exception, catch Exception does not give any Compile Error.
            System.out.println("Exception Caught!");
            f.printStackTrace();
        }

    }

    public static void catchFNFthrowIO() throws IOException {
        System.out.println("\n\nRunning catchFNFthrowIO");
        try {
            FileInputStream file = new FileInputStream("SomeFile"); // Gives FileNotFoundException 
            System.out.println("NO FileNotFoundException");
            byte x = (byte) file.read(); // Gives IOException
            System.out.println("NO IOException"); 
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFoundException Caught and Handled!");
            f.printStackTrace();
        } catch (IOException g) {
            System.out.println("IOException Thrown!");
            g.printStackTrace();
            throw g;
        }
    }

    public static void throwAll() throws FileNotFoundException, IOException {
        System.out.println("\n\nRunning throwAll");
        try {
            FileInputStream file = new FileInputStream("SomeFile"); // Gives FileNotFoundException 
            System.out.println("NO FileNotFoundException");
            byte x = (byte) file.read(); // Gives IOException
            System.out.println("NO IOException"); 
        } catch (FileNotFoundException f) {
            System.out.println("FileNotFoundException Thrown!");
            f.printStackTrace();
            throw f;
        } catch (IOException g) {
            System.out.println("IOException Thrown!");
            g.printStackTrace();
            throw g;
        }
    }

    

    public static void main(String[] args) {
        catchIO();
        catchException();
        System.out.println(
                "Any exception from the try blocks in catchIO and catchException are caught and handled internally, and not passed back to main.");

        try {
            catchFNFthrowIO();
            // FNF Exception is caught and handled internally within catchFNFthrowIO(), skipping second line: IOException.
            // Therefore 
            System.out.println("catchFNFthrowIO: Seems that FNF was caught and handled. No IOException!");
            throwAll();
            System.out.println("throwAll: No exceptions at all!");
        } catch(FileNotFoundException ex) {
            System.out.println("FileNotFoundException passed to Main and Handled in Main!");
        } catch (IOException ex) {
            System.out.println("IOException passed to Main and Handled in Main!");
        }
    }
    
}
