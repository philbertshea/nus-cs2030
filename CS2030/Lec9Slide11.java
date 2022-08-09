// The outcome of a Filter function is either an element of a stream or nothing.
// Hence instead of T, it is recommended to use Optional<T>

// To allow forEach, define an abstract class IFLImpl which implements IFL
// Interesting case: methods of the implementation are used in the interface.
// IFL only has generate (which returns IFLImpl.generate), iterate (which returns IFLImpl.iterate) and forEach

package CS2030;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Optional;

// IFL<T> is primarily responsible for dictating the use of generate(), iterate() and forEach, 
// and redirecting the former two to IFLImpl<T>'s same-named methods (IFLImpl.generate(), IFLImpl.iterate())
// IFLImpl<T> does NOT contain a get() method
interface IFL<T> {
    public static <T> IFL<T> generate(Supplier<Optional<T>> supplier) {
        return IFLImpl.generate(supplier);
    }

    public static <T> IFL<T> iterate(Optional<T> seed, Function<Optional<T>, Optional<T>> next) {
        return IFLImpl.iterate(seed, next);
    }

    public void forEach(Consumer<Optional<T>> action);
}

// IFLImpl<T> contains the needed implementation details for generate() and
// iterate().
// forEach()
abstract class IFLImpl<T> implements IFL<T> {
    static <T> IFLImpl<T> generate(Supplier<Optional<T>> supplier) {
        return new IFLImpl<T>() {
            public Optional<T> get() {
                return supplier.get();
            }
        };
    }

    static <T> IFLImpl<T> iterate(Optional<T> seed, Function<Optional<T>, Optional<T>> next) {
        return new IFLImpl<T>() {
            private Optional<T> element = seed;
            private boolean firstElement = true;

            public Optional<T> get() {
                if (firstElement) {
                    firstElement = false;
                } else {
                    element = next.apply(element);
                }
                return element;
            }
        };
    }

    // forEach accepts a Consumer returning type T [lambda function].
    public void forEach(Consumer<Optional<T>> action) {
        Optional<T> curr = get(); // The result of get() [of type T] is stored in curr.
        while (true) { // Loops through repeatedly
            action.accept(curr); // accept is a method of Consumer class which applies the action onto the
                                 // enclosed argument curr.
            curr = get(); // get() is re-executed and its result is stored in curr.
        }
    }

    // get() is implemented in IFLImpl not IFL, as an ABSTRACT METHOD
    abstract Optional<T> get();

    public <R> IFL<R> map(Function<Optional<T>, Optional<R>> mapper) {
        return new IFLImpl<R>() {
            Optional<R> get() {
                return mapper.apply(IFLImpl.this.get());
                // Apply mapper function on the current get()
                // IFLImpl.this is the captured reference to the Enclosing IFLImpl class.
                // If we use this only, Java will assume this refers to the new IFLImpl<R>
                // instance, which accepts type R not T.
            }
        };
    }

    public IFL<T> filter(Predicate<T> predicate) {
        // Modify get() to return Optional<T>
        // Modify all current methods to work with Optional<T>
        // Liberal use of methods in Optional class: Avoid explicit handling of
        // elements, avoid using Optional's get()

        return new IFLImpl<T>() {
            Optional<T> get() {
                return IFLImpl.this.get().filter(predicate); // T doesn't have a filter function.
                // Again, IFLImpl.this references the enclosing IFLImpl class.

            }
        };
    }
}

public class Lec9Slide11 {

}
