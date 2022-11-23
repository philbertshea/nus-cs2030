// Stateful operations: Operations which have to maintain the State of the elements contained in the stream.
// Map and filter are stateless (Type of elements can change) while Limit is stateful (Type of element is maintained)
// Note that map, filter and limit are all INTERMEDIATE operations

// To indicate to a terminal operation that a stream has NO MORE elements: 
// - Returning Optional.empty() as in filter (NO because it ONLY SKIPS Current element but continues on to the next)
// - limit requires the Terminal operation to terminate stream processing when limit is reached.

// Let's try another type of implementation for IFLImple!

package CS2030;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;

interface IFL2<T> {
    public static <T> IFL2<T> generate(Supplier<T> supplier) {
        return IFLImple.generate(supplier);
    }

    public static <T> IFL2<T> iterate(T seed, Function<T, T> next) {
        System.out.println("Passed to IFL.iterate");
        return IFLImple.iterate(seed, next);
    }

    public void forEach(Consumer<T> action);
}

class IFLImple<T> implements IFL2<T> {
    // Note that head and tail are final --> IFLImple objects are immutable.
    //

    private final Supplier<T> head;
    private final Supplier<IFLImple<T>> tail;

    private IFLImple(Supplier<T> head, Supplier<IFLImple<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    static <T> IFLImple<T> generate(Supplier<T> supplier) {
        return new IFLImple<T>(supplier, () -> IFLImple.generate(supplier));
    }

    static <T> IFLImple<T> iterate(T seed, Function<T, T> next) {
        System.out.println("Passed to IFLImple.iterate");
        return new IFLImple<T>(() -> seed, () -> IFLImple.iterate(next.apply(seed), next));
    }

    boolean isEmpty() {
        return false;
    }

    public void forEach(Consumer<T> consumer) {
        IFLImple<T> curr = this;
        System.out.println("Foreach called.");
        while (true) {
            consumer.accept(curr.head.get()); // Get is a supplier method which produces a type T element
            curr = curr.tail.get();
        }
    }

    public <R> IFLImple<R> map(Function<T, R> mapper) {
        return new IFLImple<R>(
                () -> mapper.apply(head.get()),
                () -> tail.get().map(mapper));
    }
}

public class Lec9Slide12 {
    public static void main(String[] args) {
        IFL2<Integer> imp = IFL2.iterate(1, x -> x + 1);
        System.out.println(imp);
        imp.forEach(System.out::println); // Keeps on running with no end (because while(true))
    }
}
