// Data conversion with boiling water
#include <stdio.h>
int main()
{
    // Implicit
    printf("////////// IMPLICIT //////////\n");
    double a, b, c, d;
    a = 2 / 3;
    printf("a=2/3 Implicitly converts to integer value (AND ROUNDS DOWN): %f\n", a);
    b = 3.0 / 4.0;
    printf("b=3.0/4.0 remains as decimal: %f\n", b);
    c = 5.0 / 6;
    printf("c=5.0/6 promotes 6 to 6.0 giving a decimal: %f\n", c);
    d = (double)22 / 7;
    printf("d=(double)22/7 explicitly makes d a decimal: %f\n", d);

    double fahrenheit, celciusCorrect1, celciusCorrect2, celciusCorrect3, celciusWrong;
    fahrenheit = 212; // water boiling
    celciusWrong = 5 / 9 * (fahrenheit - 32);
    printf("Wrong Celcius is %f\n", celciusWrong);

    // Place the largest integer in front so that 5/9 = 0 is not performed first.
    // NOTE: but this rounds the result down to an integer. Not recommended if not at a whole number degC
    celciusCorrect1 = (fahrenheit - 32) * 5 / 9;
    printf("Correct Celcius is %f\n", celciusCorrect1);

    // Explicitly mark out the result to be a double
    celciusCorrect2 = (double)5 / 9 * (fahrenheit - 32);
    printf("Correct Celcius is %f\n", celciusCorrect2);

    // Make 5 or 9 in decimal form for implicit promotion of the other integers to decimals.
    celciusCorrect3 = 5.0 / 9 * (fahrenheit - 32);
    printf("Correct Celcius is %f\n", celciusCorrect3);

    return 0;
}