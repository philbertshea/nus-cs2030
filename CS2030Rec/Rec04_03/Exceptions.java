package CS2030Rec.Rec04_03;

public class Exceptions {

    static void f() throws Exception {
        try {
            throw new Exception();
        } finally {
            System.out.print("1");
        }
    }

    static void g() throws Exception {
        System.out.print("2");
        f();
        System.out.print("3");
    }

    public static void main(String[] args) {
        // Question: What does this code return?
        // My guess: 2 4 1 3

        // Answer: WRONG.
        // Answer is 214.
        /*
         * Since main() calls g(), 2 will be printed first.
         * • f() is then executed, which leads to an exception being thrown.
         * • Before f() returns, it executes the finally block, leading to 1 being
         * printed.
         * • After returning to g(), since an exception was thrown, 3 will NOT be
         * printed,
         * with control returning to main(), which catches the exception.
         * • The catch block is executed and 4 is then printed.
         */
        try {
            g();
        } catch (Exception e) {
            System.out.print("4");
        }
    }
}
