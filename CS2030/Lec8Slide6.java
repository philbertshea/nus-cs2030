// Handling side effects (program input/output, throwing exceptions, modifying external context)
// Even if there are certain unavoidable side effects, these should be handled within the own context of the class.

package CS2030;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

class IList<T> {
    private final List<T> list;

    IList(List<T> list) {
        this.list = new ArrayList<>();
        for (T item : list) {
            this.list.add(item);
        }
    }

    // A map function which, given a function, returns another IList   --> Functor(Slide7)
    <R> IList<R> map(Function<T,R> f) {
        ArrayList<R> newList = new ArrayList<R>();
        for (T item : list) {
            newList.add(f.apply(item));
        }
        return new IList<R>(newList);
    }

    // getter
    List<T> get() {
        return list;
    }

}


public class Lec8Slide6 {
    // Define a generic IList class (Immutable List)
    
    public static void main(String[] args) {
        IList<String> list = new IList<>(Arrays.asList("abc", "d", "ef"));
        System.out.println(list.map(x -> x.length()).get());  // Returns a list of the respective lengths of the strings.
        System.out.println(list.map(x -> x + "123").get());  // Returns a list of concatenated strings
    }

}
