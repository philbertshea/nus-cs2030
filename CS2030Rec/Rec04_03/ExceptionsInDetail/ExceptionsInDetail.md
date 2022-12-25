// Learn more link: https://www.tutorialspoint.com/java/java_exceptions.htm
// https://rollbar.com/blog/most-common-java-exceptions/

**Java Exceptions in Detail**

1. 3 types of Exceptions
   a. Checked Exceptions (Compile-time)

- checked (notified) by the compiler at compilation-time: Causes COMPILE ERROR.

File file = new File("E://SomeInvalidFileAddress.txt");
FileReader fr = new FileReader(file);
// error: unreported exception FileNotFoundException; must be caught or declared to be thrown

    b. Unchecked Exceptions (Runtime)

- occurs at the time of execution. NO COMPILE ERROR.
- Includes programming bugs like logic errors or improper use of API.
- Ignored at time of Compilation.

int num[] = {1, 2, 3, 4};
System.out.println(num[5]); // Index 5 does not exist for num[] with 4 elements.
// No Compile error. This gives an unchecked exception.
// On running this code, the exception ArrayIndexOutOfBoundsException pops up:
// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 4

c. Errors
Not a type of exception, but a problem which arises beyond the control of the user or programmer.
Errors are typically ignored in compilation and cannot be solved.
E.g. stack overflow results in an error.

All Exception classes are subtypes of java.lang.Exception class.
java.lang.Exception class extends Throwable.

**Catching Exceptions**
A try/catch block contains PROTECTED CODE which is code that might generate an exception.
--> When the PROTECTED CODE in the try block generates an exception, the Catch block checks whether the exception generated is listed in it.
--> If the exception generated corresponds with that listed in the catch block, the EXCEPTION IS PASSED TO THE CATCH BLOCK.

try {
int a[] = new int[2];
System.out.println("Access element three : " + a[3]);
} catch (ArrayIndexOutOfBoundsException e) {
System.out.println("Exception thrown : " + e);
}

System.out.println("Out of the block");

**Multiple catch blocks**
It is possible to stack multiple catch blocks after one try block.

try {
// Protected code
} catch (ExceptionType1 e1) {
// Catch block 1
} catch (ExceptionType2 e2) {
// Catch block 2
} catch (ExceptionType3 e3) {
// Catch block 3
}

When the protected code generates an exception:

- Check if Exception matches ExceptionType1
  --> In the case of a match, the exception is thrown to the first catch block.
- ELSE: Check if Exception matches ExceptionType2
  --> In the case of a match, the exception is thrown to the second catch block.
- ELSE: Check if Exception matches ExceptionType3
  --> In the case of a match, the exception is thrown to the third catch block.
- ELSE: Current method stops execution. Throw Exception back to previous method on the call stack.

**Multiple Catch Blocks: Ordering two exceptions where one is a subtype of another**

If we are using exceptions AException and BException where AException is a subtype of [extends] BException,
--> ORDER OF EXCEPTIONS MUST BE FROM MOST SPECIFIC (SUBTYPE) TO MOST GENERAL (SUPERTYPE) i.e. catch AException first, then BException.

public class FileNotFoundException extends IOException:
--> catch FileNotFoundException (subtype) first, then IOException (supertype) next.

try {
file = new FileInputStream(fileName);
x = (byte) file.read();
} catch (_IOException_ i) {
i.printStackTrace();
} catch (_FileNotFoundException_ f) { // Returns an error
f.printStackTrace();
}

Code above returns an error BECAUSE FileNotFoundException EXTENDS IOException.
Any IOException, **including FileNotFoundException**, will be caught and passed to the First Catchblock.
Therefore, the second Catch block gives a COMPILE ERROR: Unreachable.

**Following the Correct Order: Specific to General**

try {

} catch(ExceptionA a) {

} catch(ExceptionB b) {

} catch(ExceptionC c) {

} catch(RuntimeException d) {

} catch(Exception e) {

} catch(Throwable t) {

}

**ExceptionA, ExceptionB, ExceptionC <: RuntimeException <: Exception <: Throwable**

In this case, where ExceptionA, ExceptionB and ExceptionC extends RuntimeException,
and RuntimeException extends Exception, Exception extends Throwable:
--> The order of ExceptionA, ExceptionB and ExceptionC does NOT matter.
--> However, these must be ABOVE RuntimeException, and RuntimeException must be ABOVE Exception.
--> Exception must be ABOVE Throwable.


**Catch Multiple in a single line**
try {

} catch(RuntimeException | Exception ex) {
  // Error in the above catch line.
  // COMPILE ERROR if you put A and B on the same line where A <: B
}

try {

} catch (ExceptionA | ExceptionB | ExceptionC) {
  // Catch 3 specific RuntimeExceptions
} catch (RuntimeException) {
  // Catch RuntimeException other than ExceptionA, ExceptionB and ExceptionC
} catch (Exception) {
  // Catch Exception other than RuntimeException
}

**Throw and Throws Exception**
When code generates an exception, there are multiple ways of handling:
*try and catch block:*
- When protected code generates exception, catch and handle in catch-block.
- When protected code generates exception, catch in catch-block and throw to previous caller in call-stack.

*throw a new Exception instance explicitly*
- e.g. void func() throws XXException { throw new XXException}
- throws to previous caller in call-stack

**Throws is like return. Throwing an exception is PASSING CONTROL OF THE EXCEPTION BACK TO THE CALLER.**
**Whenever "throw XException" is used in body, the method header must explicitly state "throws XException".**


**A try block stops at the first exception.**
try {
  // Code that Generates XException. <: RuntimeException
  // (TRY BLOCK STOPS HERE. CODE BELOW WILL NOT RUN.)
  System.out.println("Hello!");
  // Code that Generates YException. <: RuntimeException
} catch(YException e) {
  System.out.println("YException caught!");
} catch(RuntimeException f) {
  System.out.println("RuntimeException caught!")
}

--> There is no catch block that catches XException. Hence, the XException is passed to the RuntimeException block.
--> RuntimeException caught! is printed.
--> Since The try block stops at the first exception caught, Hello! is NOT printed and the YException is NOT generated or caught.


**Handling thrown exceptions at the caller**
HandleExceptions {
  try {
    int a = 10/0;
  } catch(ArithmeticException e) {
    System.out.println("Arithmetic exception caught and handled within HandleExceptions");
  } 
}

ThrowExceptions throws ArithmeticException {
  try {
    int a = 10/0;
  } catch(ArithmeticException e) {
    System.out.println("Arithmetic exception caught, then thrown back to caller");
    throw e;
  } 
}

ExceptionsNotCaught {
  try {
    int a = 10/0;
  } catch(ArrayIndexOutOfBoundsException e) {
    System.out.println("ArrayIndexOutOfBoundsException caught and handled within HandleExceptions");
  } 
}


main {
  // Case 1: Handle Exceptions within called method.
  HandleExceptions();

  // Case 2: Throw Exceptions to caller.
  try {
    ThrowExceptions();
  } catch (Exception e) {
    System.out.println("Exception caught!");
  }

  // INCORRECT CASES.
  // Case 3: Called method does not catch the exception.
  ExceptionsNotCaught();
  System.out.println("This is not printed. ExceptionsNotCaught gives an error which stops the code execution");

  // Case 4: Called method throws exception to caller, but caller does not handle exception.
  ThrowExceptions(); // Not in a try/catch block.
  System.out.println("This is not printed. ThrowExceptions gives an error which stops the code execution");


}


**Try-Catch-Finally block**

Finally block runs regardless of what happens in the try block.

try {
  // Protected Code
} catch (Exception e) {
  // Run if Exception e is caught from protected code
} finally {
  // ALWAYS EXECUTES REGARDLESS OF WHATEVER HAPPENS IN PROTECTED CODE.
  // Runs if Exception not present, present and caught, present and not caught (finally runs before error stops execution.)
}


*Refer to Rec04_06 --> ExceptionsInDetail2.md for extension.*
