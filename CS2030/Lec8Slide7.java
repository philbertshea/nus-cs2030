// A Functor is something that takes in a function and returns another functor.

package CS2030;

import java.util.function.Function;
import CS2030.IList;

import java.util.Arrays;
import java.util.List;

// A Functor of type T has a function f which takes in a Function<T,R> func and returns another functor of type R.
// map() in Optional is a type of functor
interface Functor<T> {
    <R> Functor<R> f(Function<T, R> func);
}

// Functors must obey two laws:
// 1. If func is x -> x, then it should NOT CHANGE THE FUNCTOR
// 2. If func is a composition goh, then the resulting functor should be the
// SAME AS CALLING f with h and then g. (i.e. f(goh) = f(h) -> f(g))  

public class Lec8Slide7 { // in this case, functor is list
    public static void main(String[] args) {
        IList<Integer> list = new IList<>(List.of(1, -2, 3));
        boolean checkOne = list.get().equals(list.map(x -> x).get());

        Function<Integer, Integer> g = x -> x + 1;
        Function<Integer, Integer> h = x -> Math.abs(x) * 20;
        Function<Integer, Integer> goh = x -> g.apply(h.apply(x));
        System.out
                .println("Law 1 of functor (Map in IList): No change to functor if func is x-> x. Equals: " + checkOne);
        // Note that java.util.List has an in-built equals method that compares two
        // lists.

        boolean checkTwo = list.map(h).map(g).get().equals(list.map(goh).get());
        System.out.println("Law 2 of functor: composite goh equals h-->g. Equals: " + checkTwo);

    }
}
