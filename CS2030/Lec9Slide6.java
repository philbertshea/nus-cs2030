// Specific implementations
package CS2030;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// IFL is a generic interface that takes in type T. IFL instances have a get() method returning type T.
// IFL has static generate method that accepts a Supplier<T> argument (lambda function of return type T)
// and returns a new IFL<T> object with get() method returning supplier.get() [also type T] by implementation.
interface IFL<T> {
    static <T> IFL<T> generate(Supplier<T> supplier) {
        return new IFL<T>() {
            public T get() {
                return supplier.get(); // supplier has a get function which returns what the lambda returns
            }
        };
    }

    static <T> IFL<T> iterate(T seed, Function<T, T> next) {
        return new IFL<T>() {
            // Initially, element is seed and firstElement is true.
            private T element = seed;
            private boolean firstElement = true;

            public T get() {
                System.out.println("\nfirstElement begins from " + firstElement);
                // First time get() is called, element = seed is returned.
                // From the second time onwards, next is applied onto the element before the
                // result is returned.
                if (firstElement) {
                    firstElement = false;
                } else {
                    element = next.apply(element);
                }
                System.out.println("firstElement is now " + firstElement);
                return element;

            }

        };
    }

    
    T get();
}

public class Lec9Slide6 {
    public static void main(String[] args) {
        IFL<Integer> ifl = IFL.generate(() -> 1); // Supplier is () -> 1. [return type T = integer]
        System.out.println("IFL.get() returns : " + ifl.get()); // returns supplier.get() which should return 1

        IFL<Integer> ifl2 = IFL.iterate(1, x -> x + 1);
        System.out.println("First get() returns : " + ifl2.get()); // should return seed.
        System.out.println("Second get() returns : " + ifl2.get());
    }
    

}
