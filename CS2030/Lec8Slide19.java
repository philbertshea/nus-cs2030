// User defined reductions
package CS2030;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import CS2030.Geometry.*;

public class Lec8Slide19 {

    static boolean isPrime(int n) {
        return IntStream.range(2, n).noneMatch(x -> n % x == 0);
    }

    public static void main(String[] args) {
        // User-defined reductions.
        // Reduce(identityValue, lambdaFunction -- int->int).
        // First calculation: uses *identity value 0* as LEFT OPERAND
        // Subsequent calculations: uses *result of prior calculations* as LEFT OPERAND.

        // If the stream is empty, identity value is returned.

        int sum = IntStream.of(1, 2, 3).reduce(0, (x, y) -> x + y);
        System.out.println("Sum of 1, 2 and 3: " + sum);
        // 1st Calc: 0(identity), 1 --> 1
        // 2nd Calc: 1, 2 --> 3
        // 3rd Calc: 3, 3 --> 6 Returns 6

        // Benefit of lazy evaluation : OK to use infinite streams that return infinite
        // number of elements
        // As long as the elements are later filtered before terminal operation.
        // Iterate(seed, lambda) generates an ordered sequence with the 1st argument as
        // seed value. It is an infinite stream.
        // Can use functions like filter, limit to restrict the number of elements
        // before terminal operation.

        System.out.println("\n\n First 10 elements, starting from 2, then 4, then 6 ...");
        IntStream.iterate(2, x -> x + 2).limit(10).forEach(System.out::println); // First 10 elements, starting from 2
                                                                                 // then with an increment of 2
        System.out.println("\n\n Elements divisible by 10 and smaller than 50");
        IntStream.iterate(2, x -> x + 2).filter(x -> x % 10 == 0).limit(4).forEach(System.out::println); // Prints 10,
                                                                                                         // 20, 30, 40
        System.out.println("\n\n First 10 prime number elements");
        IntStream.iterate(2, x -> x + 1).filter(x -> isPrime(x)).limit(10).forEach(System.out::println); // Prints first
                                                                                                         // 10 prime
                                                                                                         // numbers,
                                                                                                         // from 2
                                                                                                         // onwards

        // Mapping to Stream<Circle>
        Stream<Circle> circles = IntStream.range(1, 4).mapToObj(r -> new Circle(new Point(0, 0), r)); // map [1-3] to
                                                                                                      // Circles with
                                                                                                      // radius 1-3
        circles.forEach(System.out::println);

        // Stream operations take in multiple types of Functional Interfaces:
        // filter takes in Predicate<T>
        // forEach takes in Consumer<T>
        // generate takes in Supplier<T>
        // map takes in Function<T,R>


        Point centre = new Point(0,0);
        Circle[] circlesOneToThree = {new Circle(centre, 1), new Circle(centre, 2), new Circle(centre, 3)}; 
        // Note that ONLY <type>[] LISTS CAN BE USED FOR DIRECT INPUT INTO STREAM. LIST<CIRCLE> DOES NOT WORK.


        Circle newCircle = Stream.of(circlesOneToThree).reduce(new Circle(centre, 0), (c1, c2) -> new Circle(centre, c1.getRadius() + c2.getRadius()));
        System.out.println("\n\nNew circle after reduction by radius-addition of circles[centre, radius = 1-3], identity Circle[centre, radius=0] : " + newCircle);
        // Reduce is of the form: T reduce(T identity, BinaryOperator<T> accumulator) 
        // Reduce takes in an identity instance of type Circle (i.e. the seed) as the first left argument of the lambda function
        // It also takes in a lambda function that takes in two Circle instances and returns a new Circle instance.

        // First calculation: Circle[centre, rad=0] (identity), Circle[centre, rad=1] --> Circle[centre, rad=1]
        // Second calculation: Circle[centre, rad=1] (bring over), Circle[centre, rad=2] --> Circle[centre, rad=3]
        // Third calculation: Circle[centre, rad=3] (bring over), Circle[centre, rad=3] --> Circle[centre, rad=6]
        // Final output : newCircle is Circle[centre, radius = 6]
        


        // Overloaded reduce method: Optional<T> reduce(BinaryOperator<T> accumulator). NOTE: It is an Optional of type T.
        System.out.println("\n\nOverloaded reduce method: Circle prints if isPresent");
        Stream.of(circlesOneToThree).reduce((c1, c2) -> new Circle(centre, c1.getRadius() + c2.getRadius())).ifPresent(System.out::println); // Reduce returns an Optional<T> which may have a value, or is empty.


        // A lambda expression stores not only the function to invoke, but also the data in its enclosing environment
    }
};
