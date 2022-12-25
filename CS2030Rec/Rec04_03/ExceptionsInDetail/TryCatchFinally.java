package CS2030Rec.Rec04_03.ExceptionsInDetail;

public class TryCatchFinally {

    public static void Finally1() {
        try {
            int num[] = { 1, 2, 3, 4 };
            System.out.println(num[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Caught and Handled!");
            e.printStackTrace();
        } finally {
            System.out.println("Finally(1) Block is Executed, regardless of whether an exception is caught.");
        }
    }

    public static void Finally2() throws ArrayIndexOutOfBoundsException {
        try {
            int num[] = { 1, 2, 3, 4 };
            System.out.println(num[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Thrown TO CALLER!");
            throw e;
        } finally {
            System.out.println("Finally(2) Block is Executed, regardless of whether an exception is caught.");
        }
    }

    public static void Finally3() throws ArrayIndexOutOfBoundsException {
        try {

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Thrown TO CALLER!");
            throw e;
        } finally {
            System.out.println("Finally(3) Block is Executed, regardless of whether an exception is caught.");
        }
    }

    public static void Finally4() throws ArrayIndexOutOfBoundsException {
        try {
            if (1 > 10/0) {
                System.out.println("This should not print because 10/0 returns an arithmetic error.");
                // Arithmetic Error is not caught below.
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Thrown TO CALLER!");
            throw e;
        } finally {
            System.out.println("Finally(4) Block is Executed, regardless of whether an exception is caught.");
        }
    }

    public static void main(String[] args) {
        System.out.println("\nFinally1 should catch and handle ArrayIndexOutOfBoundsException");
        Finally1();
        System.out.println("\nFinally2 should catch and throw ArrayIndexOutOfBoundsException");
        // Finally2(); // if Not Placed in a try/catch block, NO COMPILE ERROR, but
        // exception not caught so process halted.

        try {
            Finally2();
            System.out.println("\nThis should not be printed, because Finally2 throws an error that needs to be handled in the CALLER BLOCK (MAIN)");
            Finally1();
        } catch (Exception e) { // OK to just catch a general Exception here.
            System.out.println("Exception caught!");
            e.printStackTrace();
        } finally {
            System.out.println("Main Finally printed.");
        }

        System.out.println("\nFinally3 should not throw any exception.");
        Finally3();
        System.out.println("\nFinally4's protected code gives ARITHMETIC ERROR but is not caught or thrown.");
        Finally4();
        System.out.println("Whenever an exception is NOT PROPERLY HANDLED (CAUGHT AND/OR THROWN), code behind will not be executed. Process will stop.");
    }
}
