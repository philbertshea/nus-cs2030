package CS2030Rec.Rec03_05.NewParameters;

import java.util.List;
import java.util.ArrayList;
import CS2030Rec.Rec03_05.NewParameters.Fruit;
import CS2030Rec.Rec03_05.NewParameters.Orange;

public class Ans2 {
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

    // Let's try another variation to allow both Fruit and Orange to be accepted.
    // i.e. COMPILE EITHER IF T extends Comparable<T> OR T extends Comparable<?
    // super T>

    public static <T extends Comparable<? super T>> T max3List2(List<T> list) {
        T max = list.get(0); // Replace arr[n] with list.get(n)
        if (list.get(1).compareTo(max) > 0) {
            max = list.get(1);
        }
        if (list.get(2).compareTo(max) > 0) {
            max = list.get(2);
        }
        return max;
    }

    // Alternatively, we can try an equivalent variation which makes changes to the parameters that List accepts:
    public static <T extends Comparable<T>> T max3List3(List<? extends T> list) {
        T max = list.get(0); // Replace arr[n] with list.get(n)
        if (list.get(1).compareTo(max) > 0) {
            max = list.get(1);
        }
        if (list.get(2).compareTo(max) > 0) {
            max = list.get(2);
        }
        return max;
    }

    // MIXING max3List2 and max3List3 gives the best, most flexible combination.
    public static <T extends Comparable<? super T>> T max3List4(List<? extends T> list) {
        T max = list.get(0); // Replace arr[n] with list.get(n)
        if (list.get(1).compareTo(max) > 0) {
            max = list.get(1);
        }
        if (list.get(2).compareTo(max) > 0) {
            max = list.get(2);
        }
        return max;
    }


    public static void main(String[] args) {

        // Let's think about max3List2 first.

        // If we use Fruit as the data-type T, the code will compile
        List<Fruit> list1 = new ArrayList<>();
        list1.add(new Fruit());
        list1.add(new Orange()); // new Orange() is OK, as per the illustration below
        list1.add(new Fruit());
        max3List2(list1);

        // If we use Orange as the data-type T, the code will also compile
        // Reason is that Orange extends Comparable<Fruit>, where Fruit is a super-type of Orange.
        // Therefore, where T = Orange, T extends Comparable<? super T> is fulfilled as
        // Orange extends Comparable<Fruit (super Orange)>

        List<Orange> list2 = new ArrayList<>();
        list2.add(new Orange());
        list2.add(new Orange());
        list2.add(new Orange());
        max3List2(list2);

        // Let's think about an alternative, max3List3: public static <T extends Comparable<T>> T max3List3(List<? extends T> list)
        // COMPILES as long as: for List<X> accepted, there is some type T such that 1) X extends T (X is a subtype of T) and 2) T implements Comparable<T>.
        // i.e. Compiles iff the type that List takes in HAS A SUPERTYPE WHICH IMPLEMENTS COMPARABLE<SUPERTYPE>

        // Using List<Fruit> will COMPILE: For List<X>, X = Fruit and T = Fruit such that Fruit extends Comparable<Fruit>
        max3List3(list1);
        // Using List<Orange> will COMPILE: For List<X>, X = Orange and T = Orange such that Orange extends Comparable<Orange>
        max3List3(list2);


        // The best, most flexible variation would be max3List4, which is a combination of max3List2 and max3List3.
        max3List4(list1);
        max3List4(list2);

        
    }
}
