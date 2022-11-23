// Preprocessor directives are specific instructions for the preprocessor.
// Syntax: #directive_name XXX (additional information)

#include <stdio.h> // Add the file "stdio.h" for compilation
#define MAX 5000000   // substitute all occurrences of "MAX" in the source code with 5000

// Main function: a special kind of function which executes first on run.
int main()
{

    /*4 kinds of statements in a C program:
    1. Declaration
    datatype identifier1, identifier2 = initial_value, ...;


    2. Assignment
    variable = value;
    variable = expression;


    3. Function Call.
    function_name ([function arguments]). E.g. printf("msg to be shown")

    4. Control Flow
    E.g. return value; which terminates the current function and gives value to caller of function.

    */

    // Fibonacci Series

    int x = 0, y = 1, z; // Declaration
    printf("%i %i ", x, y);

    while(x+y<MAX)
    {
        // Assignment
        z = x + y;
        x = y;
        y = z;

        // Function Call
        printf("%i ", z);
    }

    printf("Maximum is %i\n", MAX);
    
    return 0; // Control Flow
}
