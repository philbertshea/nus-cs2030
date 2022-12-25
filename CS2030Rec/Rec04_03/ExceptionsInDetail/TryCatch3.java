// In contrast to TryCatch2, we can catch multiple exceptions in one catch block.
// However, if AException <: BException, we cannot stack AException and BException into one line in one catch block.
// AException|BException and BException|AException results in a COMPILE ERROR.

package CS2030Rec.Rec04_03.ExceptionsInDetail;

import java.io.*;

public class TryCatch3 {

    public static void CatchMultiple1() {
        try {
            FileInputStream file = new FileInputStream("SomeFile");
            byte x = (byte) file.read();
        } /* catch (FileNotFoundException | IOException ex) { 
            // Error because FileNotFoundException is a subtype of IOException, therefore they cannot be caught together in one line.
            Logger.log(ex);
            throw ex;
        }*/ catch (Exception ex) {
        }
    }

    public static void CatchMultiple2() { 
        try {
            FileInputStream file = new FileInputStream("SomeFile");
            byte x = (byte) file.read();
        } catch (FileNotFoundException | IllegalStateException | ArithmeticException ex) { 
            // These three exceptions are not direct subtypes/supertypes of each other, hence there is no error.
            System.out.println("File Not Found / Illegal State / Arithmetic Caught AND HANDLED here.");
            // Exception is handled here. Not passed back to main.
        } catch (IOException ex) {
            // Order from the most specific to the most general.
            System.out.println("IOException Caught AND HANDLED here.");
            // Exception is handled here. Not passed back to main.
        } catch (Exception ex) {
            System.out.println("Exception Caught here.");
        }
    }

    public static void main(String[] args) {
        CatchMultiple1();
        CatchMultiple2();
        System.out.println("Any exception from the try blocks in CatchMultiple1 and CatchMultiple2 are caught and handled internally, and not passed back to main.");
    }
}
