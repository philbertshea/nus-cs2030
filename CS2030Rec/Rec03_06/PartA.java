/* When 17 is used as a parameter input of type Integer, the following occurs:
Integer a = 17; // Autoboxing
int b = a; // Unboxing */

// My guess: Autoboxing means UNDECLARED INTEGER-VALUES CAN BE DECLARED AS A TYPE OF THE WRAPPER CLASS Integer.
// Unboxing means Wrapper types (Integer) can be unboxed into their primitive types (int)
// Guess: 1) COMPILES
// Prints 1, 2, 3 (Since all the three numbers have been converted to Integer wrapper type)

// Answer: Correct

// Learning Point: WITHIN THE SAME WRAPPER-PRIMITIVE SET (E.G. INTEGER-INT), THERE IS AUTOMATIC AUTOBOXING AND UNBOXING, 
// WHICH ALLOWS THE INSTANCES TO BE FREELY CONVERTED BETWEEN WRAPPER CLASS AND PRIMITIVE WITHOUT ERROR.

package CS2030Rec.Rec03_06;

import java.util.List;
import java.util.ArrayList;

public class PartA {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(); // Create a List accepting Integer (Wrapper class) types

        int one = 1; // Declare and create a primitive (int) type instance one
        Integer two = 2; // Declare and create a wrapper (Integer) type instance two

        list.add(one); 
        // Addable: From Autoboxing, int one is converted to the wrapper class Integer before it is added to List<Integer>.
        // Printable: Since one is converted to an Integer (wrapper class type), it is recognised as an Integer num in list and printed.

        list.add(two);
        // Addable: two is already declared as a Integer so it is addable to the List accepting Integers.
        // Printable: two is an Integer on declaration so it can be printed as an Integer num.

        list.add(3);
        // Addable: From autoboxing, 3 is assigned the type of Integer (wrapper) so that it can be added to List<Integer>
        // Printable: 3 is an Integer when added to List, so it can be printed as an Integer num in List<Integer>.

        for (Integer num : list) {
            System.out.println(num);
        }
    }
}
