#include <stdio.h>

int main() {
    int cur, prev1 = 1, prev2 = 1, i, n;

    n = 4;

    if (n<=2) {
        cur = 1;
    } else {
        for (i=3; i<=n; i++) {
            cur = prev1 + prev2;
            prev2 = prev1;
            prev1 = cur;
        }
    }
    printf("Answer is %d\n", cur);
    return 0;
}