// ERRORS IN UNDERSTANDING. 
// Instead of substituting T with List<T>, the question is asking what method header is suitable
// if WE USE A LIST<T> INSTEAD OF AN ARRAY T[].
// The most direct attempt would be to USE THE DEFAULT STRUCTURE.

package CS2030Rec.Rec03_05.NewParameters;

import java.util.List;
import java.util.ArrayList;

class Fruit implements Comparable<Fruit> {

    // Recall that Comparable<T> has method public int compareTo(T o) {}
    // Therefore, when defining class Fruit which implements Comparable<Fruit>, we
    // need to include implementation public int compareTo(Fruit o)

    @Override
    public int compareTo(Fruit o) {
        return 0;
    }

}

// Class Orange is a subtype of Fruit.
// This means that Orange also carries the implemented method compareTo(Fruit
// o).
class Orange extends Fruit {

}

public class Ans1 {
    // Recall the default:
    // Default
    public static <T extends Comparable<T>> T max3Default(T[] arr) {
        T max = arr[0];
        if (arr[1].compareTo(max) > 0) {
            max = arr[1];
        }
        if (arr[2].compareTo(max) > 0) {
            max = arr[2];
        }
        return max;
    }

    // Let's first attempt the default implementation and method header, changing
    // the param type to List<T>:
    public static <T extends Comparable<T>> T max3List1(List<T> list) {
        T max = list.get(0); // Replace arr[n] with list.get(n)
        if (list.get(1).compareTo(max) > 0) {
            max = list.get(1);
        }
        if (list.get(2).compareTo(max) > 0) {
            max = list.get(2);
        }
        return max;
    }

    // While there seems to be no errors with the code above, we need to consider:
    // 1. If we use Fruit as the data-type T, will the code compile?
    // 2. If we use a subtype of Fruit as the data-type T, such as Orange as T, will
    // the code compile?

    public static void main(String[] args) {
        // If we use Fruit as the data-type T, the code will compile
        List<Fruit> list1 = new ArrayList<>();
        list1.add(new Fruit());
        list1.add(new Orange()); // new Orange() is OK, as per the illustration below
        list1.add(new Fruit());
        max3List1(list1);

        // However, if we use Orange as data-type, even though Orange extends Fruit,
        // this only means Orange implements Comparable<Fruit>.
        // we observe that Orange DOES NOT implement Comparable<Orange>.
        // Given T = Orange, IT CANNOT BE SAID THAT T extends Comparable<T> (Orange
        // extends Comparable<T>)
        List<Orange> list2 = new ArrayList<>();
        list2.add(new Orange());
        list2.add(new Orange());
        list2.add(new Orange());
        // max3List1(list2);

        // WHY IS THERE AN ERROR WHEN USING ORANGE?
        // There is no problem with compareTo when either Fruit or Orange is involved as
        // the instance caller or the parameter.
        // The problem with using max3List1 for List<Orange> is that
        // ** ORANGE DOES NOT EXTEND COMPARABLE<ORANGE>
        new Fruit().compareTo(new Fruit());
        new Fruit().compareTo(new Orange());
        new Orange().compareTo(new Fruit());
        new Orange().compareTo(new Orange());

        assert (new Fruit() instanceof java.lang.Comparable<Fruit>);
        assert (new Orange() instanceof java.lang.Comparable<Fruit>); // Orange DOES implement Comparable<Fruit>
        // assert (new Orange() instanceof java.lang.Comparable<Orange>); // BUT Orange
        // DOES NOT implement Comparable<Orange>

    }

}
