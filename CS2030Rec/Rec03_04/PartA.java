// LEARN MORE LINK: https://stackoverflow.com/questions/1998544/method-has-the-same-erasure-as-another-method-in-type

package CS2030Rec.Rec03_04;

import java.util.List;

public class PartA {

    // My guess: Code COMPILES because List<Integer> and List<String> take in
    // different types and are invariant to each other. List<Integer> NOT<:
    // List<String>. Therefore, the method is overloaded.
    
    // Answer: Code DOES NOT COMPILE. Error: Erasure of method foo(List<Integer>) is the same as another method in type PartA
    // Reason is that to ensure compatibility with old codes of raw types, 
    // A Language Rule is implemented which does not allow a class to have
    // MULTIPLE METHODS WHICH ARE OVERRIDE EQUIVALENT, 
    // I.E. SAME NAME AND SAME PARAMETER TYPE AFTER ERASURE OF TYPE PARAMETERS.

    void foo(List<Integer> IntegerList) {
    }

    void foo(List<String> StringList) {
    }
    // Both versions of foo have the same parameter type and are OVERRIDE-EQUIVALENT
    // if we ERASE (ignore) the TYPE PARAMETERS IN <>. Hence they give an error.


    public static void main(String[] args) {

    }
}
