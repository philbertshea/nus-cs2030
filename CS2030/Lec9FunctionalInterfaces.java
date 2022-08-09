// Java Functional Interfaces. Consumer, Supplier, Predicate, Function
package CS2030;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.Optional;

public class Lec9FunctionalInterfaces {

    // Consumer: Passes in parameters and outputs values (e.g. println) but DOES NOT
    // RETURN ANY VALUE
    // Consumer has two methods:
    // void accept(T t);
    // default Consumer<T> andThen(Consumer<? super T>);
    //
    public static void useConsumer() {
        Consumer<String> printConsumer = t -> System.out.println(t + " !"); // Accepts a string t and does not return
                                                                            // anything
        printConsumer.accept("Hello"); // should Print "Hello !"
        Stream<String> cities = Stream.of("Sydney", "New York", "Dhana");
        cities.forEach(printConsumer); // Accepts a Consumer interface and applies onto each element in stream
    }

    public static void useBothConsumer() {
        List<String> cities = Arrays.asList("Sydney", "New York", "Dhana");
        Consumer<List<String>> upperCaseConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                String newElement = list.get(i).toUpperCase();
                list.set(i, newElement);
            }
        };
        Consumer<List<String>> printConsumer = list -> list.stream().forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }

    public static void useTypedConsumer() {
        IntConsumer printerInt = t -> System.out.println("This is an integer: " + t);
        LongConsumer printerLong = t -> System.out.println("This is a long: " + t);
        DoubleConsumer printerDouble = t -> System.out.println("This is a double: " + t);
        printerInt.accept(1);
        printerLong.accept(1000L);
        printerDouble.accept(1.5);
    }

    public static void main(String[] args) {
        System.out.println("\nuseConsumer");
        useConsumer();
        System.out.println("\nuseBothConsumer");
        useBothConsumer();
        System.out.println("\nuseTypedConsumer");
        useTypedConsumer();
        System.out.println("\nuseSupplier");
        useSupplier();
        System.out.println("\nuseTypedSupplier");
        useTypedSupplier();
        System.out.println("\nuseOptionalSupplier");
        useOptionalSupplier();
        System.out.println("\nusePredicate");
        usePredicate();
        System.out.println("\nuseAndPredicate");
        useAndPredicate();
        System.out.println("\nuseFunction");
        useFunction();
    }

    // A supplier is a simple interface that DOES NOT PASS IN A PARAMETER but
    // returns a value.
    // A supplier only has a get() method: T get();
    public static void useSupplier() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        System.out.println(doubleSupplier.get());
    }

    // Specific Primitive-Typed Suppliers
    public static void useTypedSupplier() {
        IntSupplier intSupplier = () -> 1;
        DoubleSupplier doubleSupplier = () -> Math.random();
        LongSupplier longSupplier = () -> 10L;
        BooleanSupplier booleanSupplier = () -> false;

        // Note that for Suppliers of specific return types, they have unique getAsT
        // methods
        System.out.println("Returns an int " + intSupplier.getAsInt());
        System.out.println("Returns a long " + longSupplier.getAsLong());
        System.out.println("Returns a  double " + doubleSupplier.getAsDouble());
        System.out.println("Returns a boolean " + booleanSupplier.getAsBoolean());
    }

    // Supplier used for Deferred execution
    // E.g. using the orElseGet method of Optional: if empty, then execute the
    // supplier functional interface
    public static void useOptionalSupplier() {
        Supplier<Double> doubleSupplier = () -> Math.random();
        Optional<Double> optDouble = Optional.empty();

        System.out.println(optDouble.orElseGet(doubleSupplier));
    }

    // Predicate is used as a boolean-valued function of an argument. It helps to
    // filter data within a Java stream.
    // Stream.filter(Predicate) accepts a predicate which takes every element in the
    // stream and returns true/false.
    // Stream.filter(Predicate) then returns a stream of elements which return true
    // when passed into the predicate
    // Predicate has boolean test(T t) which accepts an argument and returns a
    // boolean.

    public static void usePredicate() {
        List<String> names = Arrays.asList("John", "Betty", "Smith", "Soong", "Sandy");
        // Here, the predicate takes in a string value and returns a boolean
        Predicate<String> startWithSPredicate = str -> str.startsWith("S");

        // Filter stream with predicate and print the results that pass the predicate
        names.stream().filter(startWithSPredicate).forEach(System.out::println);
    }

    // Predicate also has some other methods.
    // default Predicate<T> and(Predicate<? super T>);
    // default Predicate<T> or(Predicate<? super T>);
    // static <T> Predicate<T> isequals(Object targetRef);
    // default Predicate<T> negate();

    // Composing a multi-predicate using and.
    public static void useAndPredicate() {
        List<String> names = Arrays.asList("John", "Betty", "Smithstone", "SoongFah", "Sandy");

        // Here, the predicate takes in a string value and returns a boolean
        Predicate<String> startWithSPredicate = str -> str.startsWith("S");
        // Define another predicate that checks the length of the element(name)
        Predicate<String> lengthPredicate = str -> str.length() > 5;

        // Filter stream with predicate and print the results that pass the predicate
        names.stream().filter(startWithSPredicate.and(lengthPredicate)).forEach(System.out::println);
    }

    // a function is a generic functional interface that takes in an argument and
    // returns another.
    // It has a R apply(T t) single abstract method. Often used in Stream.map().
    public static void useFunction() {
        List<String> names = Arrays.asList("John", "Betty", "Smithstone", "SoongFah", "Sandy");

        // Define a Function<String, Integer> that takes in a String parameter (name)
        // and returns length of name (integer)
        Function<String, Integer> nameLengthFunction = str -> str.length();
        List<Integer> namesLength = names.stream().map(nameLengthFunction).collect(Collectors.toList());
        System.out.println(namesLength);

    }
}
