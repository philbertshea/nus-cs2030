// External Iterations vs Internal Iterations
// Range and RangeClosed
// Intermediate operations vs Terminal operations
// Stateful vs stateless operations
// Boolean terminal operations

package CS2030;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Lec8Slide9 {
    public static void main(String[] args) {
        // External Iterations: An imperative loop specifies HOW to loop and sum.
        // Variables i and sum mutate at each iteration. Errors may occur if:
        // 1. Sum initialised wrongly. 2. i initialised wrongly.
        // 3. Loop condition wrong. 4. i incremented wrongly. 5. aggregation of sum is
        // wrong.
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        // Internal Iterations: Declarative approach specifies WHAT to do.
        // Sum is assigned the result of a STREAM PIPELINE. Stream --> Sequence of
        // elements on which tasks are performed
        // Stream Pipeline --> Moves stream elements through sequence of tasks
        // Literal meaning: For range 1-10, sum them.
        // IntStream handles all iteration details. No need to specify HOW to iterate,
        // or use mutatable variables.
        // --> Errors due to wrong iteration details will be avoided.

        int sumTwo = IntStream.rangeClosed(1, 10).sum();
        // range() is end exclusive, rangeClosed() is end inclusive.
        // A stream pipeline starts with a data source.
        // 1. IntStream.rangeClosed(1, 10) creates an IntStream which contains the
        // ordered sequence 1 to 10.
        // 2. Instance method sum() is a processing step/reduction step. Terminal
        // operation which
        // initiates a sequence's pipeline processing, reducing a stream of values to a
        // single result.

        // count, min, max, average are other reduction steps.
        long count = IntStream.rangeClosed(1, 10).count();
        OptionalInt max = IntStream.rangeClosed(1, 10).max();
        System.out.println("For IntStream 1-10, sum is " + sumTwo + "(equivalent to " + sum + ") ,\n count is " + count
                + " ,\n maximum is " + max);

        // Intermediate operations are often used onto elements of a stream, before the
        // terminal operation is executed.
        // Mapping: a common intermediate operation
        int sumThree = IntStream.rangeClosed(1, 10).map(x -> x + 2).sum();

        // Notice that flatMap flattens the nested IntStreams and returns only the
        // elements of the resulting nested IntStreams
        // if ...map(x -> IntStream.rangeClosed(1,x)), stream will consist of 10
        // IntStreams.
        // stream = IntStream[ IntStream[1], IntStream[1,2], ... ,
        // IntStream[1,2,3,4,5,6,7,8,9,10]]
        // This is invalid since IntStreams can only contain ints (not IntStreams).
        // However, by using flatMap, the IntStreams are flattened
        // as a result, the elements in the nested IntStreams are TAKEN OUT.
        // stream = IntStream[ 1, (1, 2), ... , (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)]

        IntStream stream = IntStream.rangeClosed(1, 10).flatMap(x -> IntStream.rangeClosed(1, x));

        /*
         * System.out.println("\n\n Printing stream: ");
         * stream.forEach(x -> System.out.println(x));
         */
        int sumFour = stream.sum();

        System.out.println("Map x-> x+2 as intermediate gives : " + sumThree
                + "\n flatMap x-> IntStream.rangeClosed(1,x) as intermediate gives : " + sumFour);

        // Intermediate Operations use lazy evaluation. Does not perform any operations
        // on stream's elements until a terminal operation is called.
        // E.g. filter(x -> x%2 == 0) is an intermediate operation. This means the
        // filter is ONLY APPLIED when a TERMINAL OPERATION is called.

        // Terminal Operations use eager evaluation. This means the operation is
        // performed when called.
        IntStream otherStream = IntStream.rangeClosed(1, 10).filter(x -> x % 2 == 0); // Lazy
        int otherSum = otherStream.map(x -> x + 1).sum(); // Eager
        System.out.println("\nSum of (2+1), (4+1), (6+1), (8+1), (10+1) = " + otherSum);

        // Stateful and Stateless operations: 
        // Stateless intermediate operations like filter and map : processing one element DOES NOT DEPEND ON OTHER ELEMENTS.
        // Stateful intermediate operations like sorted, limit and distinct : DEPENDS ON OTHER ELEMENTS.

        System.out.println("\nSort and print: ");
        IntStream.of(7,9,5,8,3).sorted().forEach(System.out::println); 
        // System.out::println is a method reference that replaces the lambda x -> System.out.println(x)
        // Only use a method reference if the lambda ONLY CALLS ANOTHER METHOD. 
        // E.g. cannot replace if lambda is x -> System.out.println(x+1)

        System.out.println("\nPrint Distinct: ");
        IntStream.of(0,0,1,1,1,0,1,0).distinct().forEach(System.out::println);

        // Method references: A lambda that simply calls another method can be replaced with a method reference.
        // E.g. forEach(System.out::println). 3 types: 1. Reference to static method 2. Reference to instance method 3. Reference to constructor
        
        System.out.println("\n forEach(lambda function) : ");
        IntStream.of(1,2,3,4,5).forEach(x -> System.out.println(x));
        System.out.println("\n forEach(method reference)");
        IntStream.of(1,2,3,4,5).forEach(System.out::println);

        // Boolean Terminal Operations
        // noneMatch returns true if no element passes the predicate
        // allMatch returns true if all elements pass the predicate

        System.out.println("\n\nCheck: Is 17 prime? ");
        // If NONE of the elements (2 to 16, inclusive) pass the predicate (17 % x == 0), this prints true.
        System.out.println(IntStream.range(2,17).noneMatch(x -> 17 % x == 0));

        System.out.println("Is the list filled with numbers divisible by 3?");
        // If ALL of the elements pass the predicate, this prints true.
        System.out.println(IntStream.range(3,15).allMatch(x -> x % 3 == 0));

        System.out.println("Is there any element in the list divisible by 10?");
        // If ANY of the elements pass the predicate, this prints true.
        System.out.println(IntStream.rangeClosed(1,10).anyMatch(x -> x % 10 == 0));

    }
}
