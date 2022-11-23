package CS2030;

import java.awt.Color;
import java.util.Optional;

public class Geometry {

    public static class Point {
        // Point properties: x and y coordinates. private --> only accessible within
        // point class.
        protected double x;
        protected double y;

        // Point constructor (same name as class) takes in x and y coordinate values and
        // assigns these to the x/y coordinate properties.
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // Use getters to restrict access (and the ability to change) to the properties
        // x and y
        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        // Equals compare method
        @Override
        public boolean equals(Object obj) {
            // 1. Check if obj is the same object as self
            // 2. Check if obj is of the same type as self
            // 3. Check associative property
            if (this == obj) {
                return true;
            } else if (obj instanceof Point) {
                Point p = (Point) obj; // Type casting
                // creates a Point p from obj, asserting obj is of type Point
                // this is so that the x and y properties can be accessed.
                return Math.abs(this.x - p.x) < 1E-15 && Math.abs(this.y - p.y) < 1E-15; // ABSOLUTE!!
            } else {
                return false;
            }
        }

        // midpoint
        public Point midpoint(Point otherpoint) {
            double midX = (this.x + otherpoint.x) / 2;
            double midY = (this.y + otherpoint.y) / 2;
            return new Point(midX, midY);
        }

        public double distance(Point otherpoint) {
            double Xdistsquared = (otherpoint.x - this.x) * (otherpoint.x - this.x);
            double Ydistsquared = (otherpoint.y - this.y) * (otherpoint.y - this.y);
            return Math.sqrt(Xdistsquared + Ydistsquared);
        }

        public Point moveTo(double theta, double d) {
            // Not sure how to moveTo
            return new Point(this.x, this.y);
        }

        @Override
        public String toString() {
            return "Point (" + this.x + " , " + this.y + ")";
        }

    }

    public static class Circle {
        private final Point centre;
        private final double radius;

        public Circle(Point centre) {
            this.centre = centre;
            this.radius = 1.0;
        }

        public Circle(Point centre, double radius) {
            this.centre = centre;
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        public Point getCentre() {
            return centre;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return Math.PI * 2 * radius;
        }

        public boolean contains(Point point) {
            return (point.distance(centre) <= radius);
        }

        static Circle getCircle(Point centre, double radius) {
            // getCircle serves as an additional filter to check whether the radius is valid
            // to filter through non-positive radius values, it is best to use a static
            // function
            // like getCircle, IMPLEMENTED WITHIN CIRCLE CLASS, instead of directly using
            // the constructor Circle(...).
            return (radius > 0 ? new Circle(centre, radius) : null);
        }

        static Lec7Maybe<Circle> getMaybeCircle(Point centre, double radius) {
            if (radius > 0) {
                return new Lec7Maybe<Circle>(new Circle(centre, radius));
            } else {
                return Lec7Maybe.empty();
            }
        }

        static Optional<Circle> getOptionalCircle(Point centre, double radius) {
            if (radius > 0) {
                return Optional.of(new Circle(centre, radius)); // Optional.of is a static method that creates a new
                                                                // Optional instance
            } else {
                return Optional.empty(); // Optional.empty is a static method that creates an empty Optional instance
            }
        }

        @Override
        public String toString() {
            return "Circle of centre ( " + centre.getX() + " , " + centre.getY() + " ) and radius " + radius + " ";
        }
    }

    public static class OptCircle {
        private final Optional<Point> centre;
        private final double radius;

        // RECALL: Private because we want to ensure users use getOptCircle which does a radius check.
        private OptCircle(Optional<Point> centre, double radius) {
            this.centre = centre;
            this.radius = radius;
        }

        public boolean contains(Point other) {
            return centre.get().distance(other) <= radius; // Optional.get() returns the "thing" that the Optional takes
                                                           // in
        }

        static Optional<OptCircle> getOptCircle(Point centre, double radius) {
            // Here we just use Point not Optional<Point>. The user of the function is not
            // expected to create his
            // own Optional. All Optional-related processes at the backend.
            if (radius > 0) {
                return Optional.of(new OptCircle(Optional.of(centre), radius));
            } else {
                return Optional.empty();
            }
        }

        public Optional<Point> getCentre() {
            return centre;
        }

        @Override
        public String toString() {
            return "OptCircle of Centre " + centre + " and radius " + radius;
        }

    }

    // Inheritance: FilledCircle inherits the properties of Circle
    // FilledCircle is a subclass/subset of Circle (or it can be said: FilledCircle
    // is a Circle)
    // with additional property of color
    public static class FilledCircle extends Circle {
        private final Color color;

        // Constructor which uses the superclass definition for centre and radius, and
        // assigns color property
        public FilledCircle(Point centre, double radius, Color color) {
            super(centre, radius);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        // Super(..) to access parent constructor
        // super.radius or super.getArea() to access parent properties and methods
        // respectively
        @Override
        public String toString() {
            return super.toString() + "and colour " + color + " ";
        }
    }
}
