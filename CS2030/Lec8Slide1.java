// A function is a one-to-one or many-to-one relationship. One value of x can only produce one value of y.
// A pure function takes in arguments and returns a deterministic value, with no side effects (effect on program input/output, throwing exceptions, modifying external state)
// Functional Programming
package CS2030;

import java.util.function.Function;
import java.util.List;

public class Lec8Slide1 {

    static int sumList(List<Integer> list, Function<Integer, Integer> func) {
        int sum = 0;
        for (Integer el : list) {
            sum += func.apply(el);
        }
        return sum;
    }

    public static void main(String[] args) {
        
        Function<Integer, Integer> f = x -> x + 1; // Function<T,R> where T is input type (x), R is return type (x+1)
        Function<Integer, Integer> g = x -> Math.abs(x) * 10;

        System.out.println("f.apply(2) gives " + f.apply(2)); // R apply (T t)   -->  Returns 2 + 1 = 3

        List<Integer> list = List.of(1, -2, 3);
        System.out.println("Sum of list with f applied: " + sumList(list, f)); // 2, -1, 4  --> 5
        System.out.println("Sum of list with g applied: " + sumList(list, g)); // 10, 10, 40  --> 60


        // Composite functions like f on g?
        Function<Integer, Integer> fg = x -> f.apply(g.apply(x));
        System.out.println("fg.apply(2) gives " + fg.apply(2));  // g: 2*10 = 20  --> f: 20+1 = 21
        
    }
}