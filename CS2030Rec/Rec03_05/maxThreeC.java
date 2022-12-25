// Refer to CS2030 > Lec5Slide17.java

package CS2030Rec.Rec03_05;

public class maxThreeC {
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

    // Variation C

    // My guess: Does not work because Comparable is an interface requiring type
    // parameter T.

    public static Comparable max3C1(Comparable[] arr) {
        T max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // After editing T max = arr[0] to Comparable max = arr[0]

    public static Comparable max3C2(Comparable[] arr) {
        Comparable max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // Answer: It COMPILES. Not using the generic type results in multiple WARNINGS, but NOT A COMPILATION ERROR.
    // When it is used as a raw type, the code still compiles. The method max3C2 takes in an array of Comparables,
    // i.e. the elements in array arr are Comparables. Comparables are similar to T extends Comparable. 
    // They have access to compareTo, and at the same time, are of type T and can become parameters of compareTo, without
    // need for explicit typecasting.
}