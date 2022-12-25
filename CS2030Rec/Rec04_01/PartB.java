// My guess: To ensure only one point is in the set, we can either:
// 1) Use the same reference for p and q
// 2) Manually check via equals if the Point about to be added overlaps with any of the existing points in the set.

package CS2030Rec.Rec04_01;

import java.util.Set;
import java.util.HashSet;

public class PartB {
    public static void main(String[] args) {
        Point p = new Point(1, 1);
        Point q = p;
        Point r = new Point(1, 1);
        Set<Point> set = new HashSet<>();

        // Overridden equals method in Point
        System.out.println("Point.equals p and q: " + p.equals(q));
        // Original equals method
        System.out.println("Original Equals p and q: " + (p == q));
        // Check for auto-removal of points
        set.add(p);
        set.add(q);
        System.out.println("Set is of size " + set.size() + " : " + set);

        // Overridden equals method in Point
        System.out.println("\nPoint.equals p and r: " + p.equals(r));
        // Original equals method
        System.out.println("Original Equals p and r: " + (p == r));
        // Check for auto-removal of points
        set.add(p);
        set.add(r);
        System.out.println("Set is of size " + set.size() + " : " + set);
    }
}
