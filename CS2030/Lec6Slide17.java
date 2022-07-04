// User-defined Exceptions: Create your own exception by inheriting existing ones.
package CS2030;

import CS2030.Geometry.*;

public class Lec6Slide17 {
    static class IllegalCircleException extends IllegalArgumentException {
        Point p, q;

        IllegalCircleException(String message) {
            super(message);
        }

        IllegalCircleException(Point p, Point q, String message) {
            super(message);
            this.p = p;
            this.q = q;
        }

        @Override
        public String toString() {
            return p + " " + q + " : " + getMessage();
        }
    }

    static Circle createCircle(Point p, Point q, double radius) {
        if (p.equals(q)) {
            throw new IllegalCircleException(p, q, "Points are the same");
        }
        if (p.distance(q) > 2 * radius) {
            throw new IllegalCircleException(p, q, "Points are too far apart");
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
