// An exception is either handled with (catch) or propagated (throw) for handling later
package CS2030;

import CS2030.Geometry.*;

public class Lec6Slide15_16 {
    static Circle createCircle(Point p, Point q, double radius) {
        // This is doable by arithmetic by substituting into the equation (x-h)^2 +
        // (y-k)^2 = r^2. But a bit complicated.
        // Alternatively, look at Lec4Slide18CircleLogic.png.

        // Logically, we cannot create a Circle with two points that ARE THE SAME or two
        // points that CANNOT POSSIBLY BOTH LIE ON THE CIRCLE. (Distance > 2*radius)
        // Therefore, the need to throw exceptions when these situations occur.

        if (p.equals(q)) {
            throw new IllegalArgumentException("Points are the same");
        }
        if (p.distance(q) > 2 * radius) {
            throw new IllegalArgumentException("Points are too far apart");
        }

        double distPQ = p.distance(q);
        if (distPQ <= 2 * radius && distPQ > 0) {
            Point c = p.midpoint(q);
            return new Circle(new Point(1, 1), 1);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            Circle circle = new Circle(new Point(1, 1));
            Circle nextcircle = createCircle(new Point(1, 1), new Point(1, 1), 0.25); // Throws exception
            Circle nextnextcircle = createCircle(new Point(1, 1), new Point(2, 2), 0.25); // Throws exception
            if (nextcircle.equals(circle) && nextnextcircle.equals(circle)) {
                System.out.println("Three circles coincide.");
            } else if (nextcircle.equals(circle) || nextnextcircle.equals(circle)) {
                System.out.println("Two circles coincide.");
            } else {
                System.out.println("No circle coincides with another circle.");
            }

        } catch (IllegalArgumentException ex) {
            System.err.println("Illegal Argument Exception: \n" + ex);
        } finally {
            System.err.println("Program terminated with exception caught.");
        }
    }
}
