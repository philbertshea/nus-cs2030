// A monad takes in a function and returns a monad. But unlike functors, the function that a monad takes in ITSELF RETURNS THE MONAD.
package CS2030;

import java.util.Optional;
import java.util.function.Function;

// Similar to a functor, except that the monad takes in a function that returns a monad.
// One example is flatMap.
interface Monad<T> {
    public <R> Monad<R> f(Function<T, Monad<R>> func);
}

// We can rewrite the implementation of flatMap in Optional note: errors are
// generated because the functions aren't actually defined here.
/*
 * class Optional<T> {
 * 
 * public <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper) {
 * 
 * if (!isPresent) {
 * return null;
 * } else {
 * return mapper.apply(value); // mapper.apply(value) is already an Optional in
 * itself
 * }
 * }
 * }
 */

public class Lec8Slide8 {
    public static void main(String[] args) {
        // Monads follow three laws.
        // Law 1: Left identity law. Monad.of(x).flatMap(f) = f.apply(x)

        Optional<Integer> opt = Optional.of(1); // opt : Optional[1]
        System.out.println(" x is 1. Optional.of(x) / opt is " + opt);

        Function<Integer, Optional<Integer>> f = x -> Optional.of(x + 1); // 1 -> Optional[2]
        opt.flatMap(f); // mapper.apply(value), mapper = f, value = x
        System.out.println("By Left identity law, Optional.of(x).flatMap(f) " + opt.flatMap(f)
                + " is equal to f.apply(x) " + f.apply(1));

        // Law 2: Right identity law. monad.flatmap(x -> Monad.of(x)) = monad
        Function<Integer, Optional<Integer>> g = x -> Optional.of(x);
        opt.flatMap(g); // mapper.apply(value), mapper = g, value = x --> g.apply(x) --> Optional.of(x)
                        // --> opt
        System.out.println(
                "By Right identity law, opt.flatMap(x->Optional.of(x)) " + opt.flatMap(g) + " is equal to opt " + opt);

        // Law 3: Associative law. monad.flatMap(f).flatMap(g) = monad.flatMap(x ->
        // f.apply(x).flatMap(g))

        System.out.println("By Associative law, opt.flatMap(f).flatMap(g) is " + opt.flatMap(f).flatMap(g));
        System.out.println(
                "While opt.flatMap(f.apply(x).flatMap(g)) is equivalent: " + opt.flatMap(x -> f.apply(1).flatMap(g)));

    }
}
