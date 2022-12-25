// Refer to CS2030 > Lec5Slide17.java

package CS2030Rec.Rec03_05;

public class maxThreeA {
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

    // Variation A
    // My Guess: Here we are changing to a method that accepts an array of type
    // Comparable<T>
    // and returning Comparable<T>. T no longer extends Comparable<T>.
    // In this case, max will not be of type T, but rather of type Comparable<T>.

    // The essential change is that instead of making type T implement the interface
    // Comparable
    // (And therefore have access to the comparison method compareTo), this
    // variation directly changes
    // the type of elements stored in the array to Comparable<T>.

    // My guess: Only error is at T max = arr[0]. (Change to Comparable<T> max =
    // arr[0]. )
    // arr elements should still have access to compareTo so no other issues.

    public static <T> Comparable<T> max3A1(Comparable<T>[] arr) {
        T max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // After proposed Error Edit.
    public static <T> Comparable<T> max3A2(Comparable<T>[] arr) {
        Comparable<T> max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // Answer: Still CANNOT COMPILE.
    // CARELESS. RELOOKING AT COMPARABLE INTERFACE DEFINITION:
    /*
     * public interface Comparable<T> {
     * public int compareTo(T o);
     * }
     */
    // compareTo TAKES IN PARAMETER OF TYPE T ONLY.

    // No problem with Default implementation, because all the elements are
    // 1. BOTH of type T (meaning they can be the parameter in compareTo)
    // 2. AND of type Comparable<T> since T extends Comparable<T> (meaning they can
    // also call the method compareTo)

    // By replacing T with Comparable<T>, all elements in arr
    // 1. CAN ONLY CALL compareTo (property of Comparable<T>)
    // , but CANNOT BE THE PARAMETER in compareTo. (As per the definition of
    // compareTo, the parameter is of type T only)

    // Answer:
    /*
     * If we declare max with type Comparable<T>, then we require a cast
     * nums[1].compareTo((T)max)
     * Also, realize that the method returns a Comparable object.
     */

    // After typecasting
    public static <T> Comparable<T> max3A3(Comparable<T>[] arr) {
        Comparable<T> max = arr[0];

        if (arr[1].compareTo((T) max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo((T) max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // After typecasting WITH SUPPRESS WARNINGS (You can only use SuppressWarnings
    // right before a variable declaration/definition)

    // NOTE: There is an error here. We cannot use CastedMax = arr[1] wihout
    // incurring
    // Either a compilation error or a type safety warning.
    // Therefore, the code below is not completely accurate: changing max does not
    // change CastedMax
    // But the alternative way of using CastedMax = (T) arr[1] still results in a
    // type safety error (We prefer this as it is compilable and more accurate.)
    public static <T> Comparable<T> max3A4(Comparable<T>[] arr) {
        Comparable<T> max = arr[0];

        @SuppressWarnings("unchecked")
        T CastedMax = (T) max;

        if (arr[1].compareTo(CastedMax) > 0) {
            CastedMax = (T) arr[1]; //Unavoidable type safety flags
        }

        if (arr[2].compareTo(CastedMax) > 0) {
            CastedMax = (T) arr[2];
        }
        return max;
    }
}
