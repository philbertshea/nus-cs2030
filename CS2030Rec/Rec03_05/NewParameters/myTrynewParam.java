package CS2030Rec.Rec03_05.NewParameters;

import java.util.List;

public class myTrynewParam {
    // What if the parameter type of max3 is List<T> instead? How would you change
    // the method header to be as flexible as you can?

    // Default
    public static <T extends Comparable<T>> T max3Default(T[] arr) {
        T max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // My guess: Since the parameter type changed from T to List<T>
    // 1. No point using T extends compareTo, because List<T> needs access to
    // compareTo, not T.
    // 2. We must explicitly state Comparable in the method header (MOST IMPORTANT:
    // In the brackets)

    // Try max3B
    public static <T> List<T> max3List1(Comparable<T>[] arr) {
        List<T> max = (List<T>) arr[0];

        if (arr[1].compareTo(max) > 0) { // Max3B does not work. Casting as List<T> will mean it is no longer a
                                         // Comparable<T>.
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // Try max3C

    public static <T> Comparable max3List2(List<T>[] arr) { // Still need to assert that the type is List<T> not T.
        Comparable max = (Comparable) arr[0];
        if (arr[1].compareTo(max) > 0) { // Gives some errors
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
