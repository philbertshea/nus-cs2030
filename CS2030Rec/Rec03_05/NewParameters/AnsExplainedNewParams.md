Suppose we have:
class Fruit implements Comparable<Fruit> {
@Override
public int compareTo(Fruit f) { return 0; }
}

class Orange extends Fruit { }

Just declaring public static <T extends Comparable<T>> T max3(List<T> list)
would work for List<Fruit> only, but not for List<Orange>, since
Orange extends Comparable<Orange> does not hold.

The first solution is to modify the argument:
public static <T extends Comparable<T>> T max3(List<? extends T> list)

Now what can T be bound to? Can it be Orange? Notice that <T extends Comparable<T>>
would not work for List<Orange>, since Orange extends Comparable<Orange> does
not hold. How about binding T to Fruit? Clearly, Fruit extends Comparable<Fruit>
holds. And is List<Orange> a sub-type of List<? extends Fruit>? Yes! This is a
covariant relation.

On the other hand, Orange <: Comparable<Orange> does not hold since
Orange <: Fruit <: Comparable<Fruit>, but Comparable<Fruit> and Comparable<Orange>
are invariant.

Another way is to declare it as

public static <T extends Comparable<? super T>> T max3(List<T> list)

Now what can T be bound to? Notice that
Orange <: Fruit <: Comparator<Fruit> <: Comparator<? super Orange>
So T can be bounded to Orange! Notice that the relation
Comparator<Fruit> <: Comparator<? super Orange> is contravariant.

And to be even more general, we should have:
public static <T extends Comparable<? super T>> T max3(List<? extends T>
list)
The use of the declaration <T extends Comparable<? super T>> is very common all
over Java’s API. As such we can define max3 as