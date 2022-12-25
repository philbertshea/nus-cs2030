// Refer to CS2030 > Lec5Slide17.java

package CS2030Rec.Rec03_05;

public class maxThreeB {
    // Default

    // Though Comparable is an interface, we must use "extends" in a type parameter.
    public static <T extends Comparable<T>> T max3Default(T[] arr) {
        // Comparable is an interface with a method compareTo, used to compare this with
        // another object. arr[1] gets access to compareTo because it is of type T,
        // which
        // has been defined in the Generic Bound to extend Comparable<T>.

        // max3 takes in an array parameter of type T[], and has return type of T
        // (returns max)
        T max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // Variation B

    // My guess: max3B takes in an array of type Comparable<T> and returns type T.
    // Similar to a, this requires explicit typecasting of elements in arr to type
    // T,
    // so that the elements can be used as input params for compareTo.

    // The main difference from Variation A is that the return type is T, meaning
    // that
    // it is necessary to typecast max to type T before returning.

    // Direct Replacement from Default
    public static <T> T max3B1(Comparable<T>[] arr) {

        T max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // After Proposed Edits (Adjusting type of max, adding typecasting and
    // suppressig warnings)

    public static <T> T max3B2(Comparable<T>[] arr) {

        Comparable<T> max = arr[0]; // 1. Change T to Comparable<T> since the array consists of Comparable<T>
                                    // elements

        if (arr[1].compareTo((T) max) > 0) { // 2. Change max to (T) max [typecasting to type T is necessary as
                                             // compareTo takes in parameter of type T]
            max = arr[1];
        }
        if (arr[2].compareTo((T) max) > 0) { // 3. Change max to (T) max [typecasting to type T is necessary as
                                             // compareTo takes in parameter of type T]
            max = arr[2];
        }

        return (T) max; // 4. Change max to (T) max. Return type is T, therefore need to cast
                        // (Comparable<T>) max to type T

    }

    /*
     * The above preserves the return type as T. Suppose we declare max as type T
     * now.
     * Still, explicit casting is required when assigning an element of arr to max,
     * e.g.
     * T max = (T) arr[0]
     */

    // Answer: Alternative solution

    public static <T> T max3B3(Comparable<T>[] arr) {
        @SuppressWarnings("unchecked")
        T max = (T) arr[0]; // To avoid the issue of CastedMax and max, just typecast and define ONE
                            // VARIABLE OF MAX with type T

        if (arr[1].compareTo(max) > 0) {
            max = (T) arr[1];
        }

        if (arr[2].compareTo(max) > 0) {
            max = (T) arr[2];
        }

        return max;
    }

}
