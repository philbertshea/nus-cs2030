// My guess: 1) DOES NOT COMPILE. Integer cannot be directly converted to double. Requires two steps: Integer --> int, int --> double

// Answer: WRONG.
// 1) COMPILES. No problem with Integer to double conversion. Basically, since there is unboxing, treat Integer as int.
// 2) Prints 1.0, 2.0, 3.0 (just like an int to double conversion)

package CS2030Rec.Rec03_06;

import java.util.List;
import java.util.Arrays;

public class PartD {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        for (double num : list) {
            System.out.println(num);
        }
    }
}
