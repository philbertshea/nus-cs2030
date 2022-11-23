#include <stdio.h>
#define min(x,y) ((x>=y)?y:x) // An interesting way to define a simple function

int main() {
    int x, y, hcf = 1;

    // Input: scanf( "format_string", &variable1, &variable2 ...)

    printf("Accept two integers in the format x | y , then press enter:\n");
    scanf("%i | %i", &x, &y);

    // Output: printf( "format_string", variable1, variable2, ...)
    printf("Two integers are: %i and %i", x, y);

    // Their highest common factor is...
    for (int i = 1; i<min(x, y); i++) {
        if (x%i == 0 && y%i == 0) {
            hcf = i;
        }
    }

    printf ("\nTheir highest common factor is: %i", hcf);
}
