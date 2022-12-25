// In Java, a Set is a Collection that does not contain duplicate elements (this is in
// contrast to a List which does allow duplicates).

// My guess: 1) COMPILES
// 2) p.equals(q) prints TRUE.  3) set prints HashSet(p(1,1), q(1,1))
// Because even though p and q HAVE THE SAME X AND Y, they DO NOT HAVE THE SAME REFERENCE 
// --> To a set, which FOLLOWS THE OBJECT CLASS DEFINITION OF EQUALS (equal <--> same reference), p and q are not equal.

// ANSWER:
/*true
[(1.0, 1.0), (1.0, 1.0)] */
package CS2030Rec.Rec04_01;

import java.util.Set;
import java.util.HashSet;

public class PartA {
    public static void main(String[] args) {
        Point p = new Point(1.0, 1.0);
        Point q = new Point(1.0, 1.0);

        System.out.println(p.equals(q));

        Set<Point> set = new HashSet<>(); // Just like List, Set is an interface which has no constructor.
        set.add(p); 
        set.add(q);
        // p.equals(q) returns true because equals calls the OVERRIDDEN method equals in Class Point, which compares X AND Y VALUES.
        // However, to HashSet<Point>, two Point instances are equal ONLY IF THEY SHARE THE SAME REFERENCE.

        System.out.println(set);
    }
}
