**This file primarily deals with the Explicit Throw Exception Statement**

**Unreachable Code: Explicit Throw of Exception**

static void f() {
    int x = 0;
    throw new IllegalArgumentException();
    int y = 0; // COMPILE ERROR
}

static void f() {
    try {
        int x = 0;
        throw new IllegalArgumentException();
        int y = 0; // COMPILE ERROR
    } catch (Exception e) {
        throw e;
        System.out.println("This line is not reachable."); // COMPILE ERROR
    }
   
}

Whenever an exception is EXPLICITLY THROWN, any code behind the throw Exception line within the same block (e.g. try block) will not be reachable.
--> The compiler checks for code behind exceptions. 
--> COMPILE ERROR will result.

**Undeclared Exception at Method Header**
A) Exception thrown is **NOT CAUGHT & HANDLED AND itself/its supertype is NOT DECLARED** in method header. (throws xxx)
--> Results in COMPILE ERROR. (Unhandled Exception type Exception)

static void f() throws IllegalArgumentException { 
    // not throws Exception

    try {
        throw new Exception(); // Throw Exception
    } catch (IllegalArgumentException e) { // Not a valid catch block for Exception [Exception NOT <: IllegalArgumentException]
        System.out.println("IllegalArgumentException is caught.");
    }

    // Throws Exception, but method header does not declare it.
}

B) Exception thrown is **CAUGHT AND HANDLED** --> OK

static void f() {
    try {
        throw new ArithmeticException();
    } catch (Exception e) { // Catch block needs to catch THE SPECIFIC EXCEPTION OR ITS SUPERTYPE.

    }
}

C) Exception thrown is **NOT CAUGHT AND HANDLED** but the **Exception or its supertype is declared** in method header. --> OK
static void f() throws Exception() {
    try {
        throw new ArithmeticException();
    } catch (ArrayIndexOutOfBoundsException e) {
        // Code is not executed because Arithmetic is NOT <: ArrayIndexOutOfBounds
    }
    // Code throws ArithmeticException <: Exception (As declared in method header)
}

D) Exception is **GENERATED AT RUNTIME, IMPLICIT AND UNCHECKED**. It is NOT EXPLICITLY THROWN. --> OK
- Compiler cannot detect unchecked runtime exceptions and hence will not flag them. No compile errors.

static void f() {
    int x = 0/0;
}

E) **DECLARING MORE THAN NEEDED** at the method header is OK.

static void f() throws IllegalArgumentException, ArithmeticException, Exception {
    System.out.println("Hello!");
}
