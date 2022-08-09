// Lazy Evaluation
// Each intermediate operation results in a new stream -- an object representing processing steps specified up to that point in the pipeline.
// Chaining intermediate operations ADDS to set of steps to perform.
// LAST STREAM OBJECT contains ALL performing steps on each element,
// BUT intermediate operation DOES NOT ITERATE ELEMENTS or PERFORM ANYTHING. Only TERMINAL OPERATIONS initiate stream's pipeline operations.
package CS2030;
import java.util.stream.Stream;

public class Lec9Slide1 {
    public static void main(String[] args) {
        System.out.println("Iterate [1,2,3...] --> Map [3,4,5,...] --> Limit 3 : ");
        // Non-terminal operations iterate, map and limit each produce a new Stream object storing the steps to perform. 
        // Stream pipeline initiates at terminal operation forEach. Upstream operations done.
        Stream.iterate(1,x -> x + 1).map(x -> x + 2).limit(3).forEach(x -> System.out.println(x));
    }
}
