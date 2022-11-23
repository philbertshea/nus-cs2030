#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a = 1, b = 0, i = 0, ans, guess;
    int compareGuess(int guess, int ans);
    printf("Guess a number between ? and ?. \n");

    // Method 1 to filter incorrect input: While loop
    while (a >= b && i < 5)
    {
        i = i + 1;
        scanf("%i %i", &a, &b);
        printf("a is %i, b is %i", a, b);
    }

    // Method 2 to filter: if-else
    int r = rand() % (b - a + 1);
    ans = a + r;

    while (ans != guess)
    {
        printf("Guess a number from %i to %i\n", a, b);
        scanf("%i", &guess);
        printf("Guess is %i", guess);

        if (guess > b || guess < a)
        {
            printf("That is out of the range. Try again! \n");
            continue;
        }
        else
        {
            // Method 3: Switch-Case. REMEMBER to break
            switch (compareGuess(guess, ans))
            {
            case -1:
                printf("Too small\n");
                break;
            case 0:
                printf("Correct Guess!\n");
                break;
            case 1:
                printf("Too large\n");
                break;
            } // 0, -1, 1 for > = <
        }
    }

    return 0;
}

int compareGuess(int guess, int answer)
{
    if (guess > answer)
    {
        return 1;
    }
    else if (guess < answer)
    {
        return -1;
    }
    else
    {
        return 0;
    }
}