// Java Collection<E> extends Iterable<E> and has the abstract method listed: Iterator<E> iterator().

package CS2030Rec.Rec04_02;

import java.util.List;
import java.util.ArrayList;
import CS2030Rec.Rec04_01.Point;
import java.util.Iterator;

public class PartA_B {
    public static void main(String[] args) {

        // Part A
        // Question: How does the iteration work?
        List<Point> list = new ArrayList<>();
        list.add(new Point(1.0, 1.0));
        list.add(new Point(2.0, 2.0));

        // Answer: List<E> extends Collection<E>, which extends Iterable<E>.
        // Iterable<E> has the abstract method Iterator<E> iterator.
        // When printing a list, such as the one above:
        // 1. list.iterator() to create an Iterator instance
        // 2. Print iter.next() continuously until iter.hasNext() returns false.
        Iterator<Point> iter = list.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        // Part B
        // Question: How is the iterator different from the following?
        for (Point p : list) {
            System.out.println(p);
        }

        // Answer: Iterator has a built-in method remove() that removes the last element returned by the iterator.
        // This can be used to empty the list after printing all the items, as follows:
        Iterator<Point> iter2 = list.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
            iter2.remove();
        }

    }
}
