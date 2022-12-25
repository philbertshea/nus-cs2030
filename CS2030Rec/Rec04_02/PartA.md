public interface List<E> extends Collection<E>
public interface Collection<E> extends Iterable<E>
public interface Iterable<T> {
Iterator<T> iterator(); // An abstract method of Iterable<T>
...
}

public interface Iterator<E> {

boolean hasNext(); // Return true if the iteration has more elements.

E next(); // Returns next element in iteration

default void remove() {
throw new UnsupportedOperationException("remove"); // Removes last element returned by iterator
}

    /**
     * Performs the given action for each remaining element until all elements
     * have been processed or the action throws an exception.  Actions are
     * performed in the order of iteration, if that order is specified.
     * Exceptions thrown by the action are relayed to the caller.
     */
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }

}

Question:

How does the list below print its results through an iteration?
List<Point> list = new ArrayList<>();
list.add(new Point(1.0, 1.0));
list.add(new Point(2.0, 2.0));
System.out.println(list);   // How does this work?

Answer:

List<E> extends Collection<E> which extends Iterable<E>. Iterable<E> contains a method Iterator<E> iterator();
--> This means that List<E> has access to a method iterator() which takes in no parameters and returns an Interator<E>.

The key methods needed for iteration here, which are PART OF THE ITERATOR<E>, are boolean hasNext() and E next().

1. Since List<E> has method iterator() which returns an Iterator<E>, we shall create an instance of an Iterator using this method.
Iterator<Point> iter = list.iterator(); 

2. The Iterator<Point>, iter, has methods boolean hasNext() and E next(). Therefore, to print the items in list one by one,
we can use a while loop and print each item until iter.hasNext() returns false, i.e. no next item.

while(iter.hasNext()) {
    System.out.println(iter.next());
}

Or in general, to apply a function onto each item in the list one by one:
for (E item : list) {
    Function(item);
}

-->

while(iter.hasNext()) {
    Function(iter.next());
}


Therefore:

Iterator<Point> iter = list.iterator();
while (iter.hasNext()) {
System.out.println(iter.next());
}
