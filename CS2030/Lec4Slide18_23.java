// https://www.baeldung.com/java-dependency-inversion-principle#:~:text=The%20Dependency%20Inversion%20Principle%20(DIP,decoupled%2C%20and%20reusable%20software%20components.

/*
 * Dependency Inversion Principle states that:
 * 1. High-Level modules should not depend on low-level modules. Both High-level and Low-level modules should depend on abstractions.
 * 2. Abstractions should not depend on details. Details should depend on abstractions.
 * 
 * The underlying concept -- Inversion of Control -- states that a class should not configure its dependencies (services that classes depend on) statically
 * But from some other class outside of it.
 * 
 * A class should concentrate on fulfilling its responsibilities and not on creating objects that it requires to fulfill those responsibilities. 
 * Hence, DEPENDENCY INJECTION is the middleman which creates the required objects (from the preferred dependency) and provides it to the class at runtime.
 * i.e. a class will use @Inject to inject a dependency, rather than rely on hard dependencies (... = new ...). 
 * Classes with hard dependencies rely on other classes and hence are more difficult to maintain or substitute and reuse.
 * 
 * NO NEED to learn about DI Frameworks like Spring. 
 * Only need to know about Stubbing. A stub is a controllable replacement for an existing dependency (or collaborator) in the system. 
 * By using a stub, you can test your code without dealing with the dependency directly.
 * Dependency Injection via Stubbing (Inheritance)
 */

package CS2030;

import CS2030.Geometry.*;

public class Lec4Slide18_23 {
    // Create a circle given two points, x and y which lie on the circumference of
    // the circle, and radius
    static Circle createCircle(Point p, Point q, double radius) {
        // This is doable by arithmetic by substituting into the equation (x-h)^2 + (y-k)^2 = r^2. But a bit complicated. 
        // Alternatively, look at Lec4Slide18CircleLogic.png. 
        double distPQ = p.distance(q);
        if (distPQ <= 2 * radius && distPQ > 0) {
            Point c = p.midpoint(q);
            return new Circle(new Point(1,1), 1);
        } else {
            return null;
        }
    }

    // TO TEST createCircle, before the actual Point class is created, we can create
    // a stub of a Point.
    // A PointStub extends Point (Which might not have had its concrete
    // implementation done up yet).
    // RESTRICTING THE TEST TO TWO POINTS EXACTLY 2*RADIUS APART, WHERE MIDPOINT =
    // CENTRE,
    // we only need minimally the functions midPoint and moveTo. NOTE: Unlike
    // Implement, Extends automatically takes all the
    // existing functions from Point (Assumes the functions have a concrete
    // implementation, unlike an interface)
    // So we only need to override the functions we need (midPoint and moveTo) to
    // put in actual implementation of these functions for our test.

    class PointStub extends Point {

        public PointStub(double x, double y) {
            super(x, y);
        }
        
        @Override
        public Point midpoint(Point op) {
            PointStub ops = (PointStub) op;  // Cast 
            return new PointStub((this.x + ops.x)/2, (this.y + ops.y)/2);
        }

        @Override
        public PointStub moveTo(double theta, double d) {
            return new PointStub(this.x, this.y);
        }

    }
}
