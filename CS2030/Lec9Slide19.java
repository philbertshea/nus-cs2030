// To allow for filter function, need to convert T to Optional<T>

package CS2030;

import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Optional;

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

    private final Supplier<Optional<T>> head;
    private final Supplier<IFLImple<T>> tail;

    private IFLImple(Supplier<Optional<T>> head, Supplier<IFLImple<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    static <T> IFLImple<T> generate(Supplier<T> supplier) {
        return new IFLImple<T>(() -> Optional.of(supplier.get()), () -> IFLImple.generate(supplier));
    }

    static <T> IFLImple<T> iterate(T seed, Function<T, T> next) {
        System.out.println("Passed to IFLImple.iterate");
        return new IFLImple<T>(() -> Optional.of(seed), () -> IFLImple.iterate(next.apply(seed), next));
    }

    boolean isEmpty() {
        return false;
    }

    public void forEach(Consumer<T> consumer) {
        IFLImple<T> curr = this;
        System.out.println("Foreach called.");
        while (true) {
            consumer.accept(curr.head.get().get()); // Get is a supplier method which produces a type T element
            curr = curr.tail.get();
        }
    }

    public <R> IFLImple<R> map(Function<T, R> mapper) {
        return new IFLImple<R>(
                () -> Optional.of(mapper.apply(head.get().get())),
                () -> tail.get().map(mapper));
    }

    public IFLImple<T> filter(Predicate<T> pred) {
        return new IFLImple<T>(
            () -> head.get().filter(pred), // Optional<T> has a filter method which checks whether the value passes the predicate, and returns it if true
            () -> tail.get().filter(pred)  // Uses the filter method of IFLImple (the exact method it is enclosed in)
        );
    }
}

public class Lec9Slide19 {
    public static void main(String[] args) {
        IFL2<Integer> imp = IFL2.iterate(1, x -> x + 1);
        System.out.println(imp);
        imp.forEach(System.out::println); // Keeps on running with no end (because while(true))
    }
}
