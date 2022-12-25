class A {
    static void f() throws Exception {
        try { B<-- runs code in try block
            throw new Exception(); C - exception thrown
        } finally {
            System.out.print("1"); D - must execute finally block first, before returning
        } E--> control goes back to g() Note that exception was thrown.
    }

    static void g() throws Exception {
        System.out.print("2"); A<-- print 2 first
        f(); B--> control goes to f()     E<-- control back to g().    F--> Since exception is thrown, control goes back to main() which catches the exception.
        System.out.print("3");
    }

    public static void main(String[] args) {
        try {
            g(); START. A--> control goes to g().  F<-- control goes back to main() which catches the exception (thrown in f()).
        } catch (Exception e) {
            System.out.print("4"); G - on catching exception, 4 is printed.
        } H - END.
    }
}

Result is 2 1 4.

• Since main() calls g(), 2 will be printed first.
• f() is then executed, which leads to an exception being thrown.
• Before f() returns, it executes the finally block, leading to 1 being printed.
• After returning to g(), since an exception was thrown, 3 will NOT be printed,
with control returning to main(), which catches the exception.
• The catch block is executed and 4 is then printed.
