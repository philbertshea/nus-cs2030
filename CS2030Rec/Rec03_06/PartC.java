// My guess: 1) Compiles because there is no fundamental error
// 2) Prints nothing. Instances of Integer cannot be converted to another wrapper class Double. 
// (Required to follow the steps: Integer --> int, int --> double, double --> Double)

// Answer: WRONG. DOES NOT COMPILE.
// Type mismatch at for statement: Cannot convert from Integer to Double
// This is because the type list takes in has been explicitly stated as Integer, therefore Double num : list raises a flag.

package CS2030Rec.Rec03_06;

import java.util.List;
import java.util.Arrays;

public class PartC {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        for (Double num : list) {
            System.out.println(num);
        }
    }
}
