// My guess: 1) COMPILES because there is no Type Mismatch
// 2) Prints 5, 4, 3, 2, 1 since the instances are autoboxed as Integer type on addition to list, and the iterator accepts the same wrapper type Integer.
// Hence the numbers are printed as Integers as well.

package CS2030Rec.Rec03_06;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class PartE {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
