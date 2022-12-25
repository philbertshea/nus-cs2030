// My Guess: 1) COMPILES
// 2) Prints 1 2 and 3 due to unboxing.

// Answer: CORRECT

package CS2030Rec.Rec03_06;

import java.util.List;
import java.util.ArrayList;

public class PartB {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Create a List accepting Integer (Wrapper class) types

        int one = 1; // Declare and create a primitive (int) type instance one
        Integer two = 2; // Declare and create a wrapper (Integer) type instance two

        list.add(one);
        // Addable: From Autoboxing, int one is converted to the wrapper class Integer
        // before it is added to List<Integer>.
        // Printable: An Integer instance can be unboxed to a primitive type of int and printed.

        list.add(two);
        // Addable: two is already declared as a Integer so it is addable to the List
        // accepting Integers.
        // Printable: An Integer instance can be unboxed to a primitive type of int and printed.

        list.add(3);
        // Addable: From autoboxing, 3 is assigned the type of Integer (wrapper) so that
        // it can be added to List<Integer>
        // Printable: An Integer instance can be unboxed to a primitive type of int and printed.

        for (int num : list) {
            System.out.println(num);
        }

    }
}
