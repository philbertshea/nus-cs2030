// Changed the equals method with Point to adhere to OOP principles

package CS2030;

import java.lang.Math;
import java.util.Scanner;
import java.awt.Color;

public class Lec3Slide7_15 {

    public static void main(String[] args) {
        test();
        Scanner scanner = new Scanner(System.in);
        Circle disc = getDisc(scanner);
        int numPoints = getNumofPoints(scanner);
        Point[] points = readPoints(scanner, numPoints);
        Boolean[] insideDisc = insideCounter(disc, points);
        printPoints(points, insideDisc);
    }

    static void test() {
        System.out.println("Tester");
        Boolean midpointTester = new Point(0, 0).midpoint(new Point(1, 1)).equals(new Point(0.5, 0.5));
        System.out.println("MidPoint is : " + midpointTester);
        Boolean equalsTester = new Point(0.5, 0.5).equals(new Point(1, 1));
        System.out.println("Equals is: " + equalsTester);
        Boolean circleTester = new Circle(new Point(1, 1), 1.0).contains(new Point(1, 2));
        FilledCircle fc = new FilledCircle(new Point(2, 2), 3/Math.PI, new Color(0,0,255));
        System.out.println(fc.getCircumference());
        System.out.println("circleTester is: " + circleTester);
    }

    static Circle getDisc(Scanner scanner) {
        System.out.println("Enter centre of disc:");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        System.out.println("Enter radius of disc:");
        double r = scanner.nextDouble();

        Point centre = new Point(x, y);
        Circle disc = new Circle(centre, r);
        return disc;
    }

    static int getNumofPoints(Scanner scanner) {
        System.out.println("Enter the number of points:");
        int numPoints = scanner.nextInt();
        return numPoints;
    }

    static Boolean[] insideCounter(Circle disc, Point[] points) {
        Boolean[] inDisc = new Boolean[points.length];
        for (int i = 0; i < points.length; i++) {
            if (disc.contains(points[i])) {
                inDisc[i] = true;
            } else {
                inDisc[i] = false;
            }
        }
        return inDisc;
    }

    static void printPoints(Point[] points, Boolean[] inDisc) {
        int len = points.length;
        int trueCount = 0;
        for (int i = 0; i < len; i++) {
            if (inDisc[i]) {
                trueCount++;
            }
        }
        System.out.println("A total of " + len + " points were obtained. " + trueCount
                + " points are in disc. The points obtained are as follows: ");
        for (int i = 0; i < len; i++) {
            System.out.print("Point " + (i + 1) + " : ( " + points[i].getX() + " , " + points[i].getY() + " )");
            if (inDisc[i]) {
                System.out.println(" Within the disc");
            } else {
                System.out.println("Out of the disc");
            }
        }

    }

    static Point[] readPoints(Scanner scanner, int numPoints) {
        Point[] points = new Point[numPoints];
        for (int i = 0; i < numPoints; i++) {
            System.out.println("Enter the coordinates of point " + (i + 1) + " : ");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            Point newpoint = new Point(x, y);
            points[i] = newpoint; // Or, to shorten this, write points[i] = new Point(x,y)

            // Check for "overlapping" points.
            for (int j = 0; j < i; j++) {
                Point oldpoint = points[j];
                if (oldpoint.equals(newpoint)) {
                    points[i] = null;
                    i--;
                    System.out.println("This point coincides with Point " + (j + 1) + " : " + oldpoint);
                    break;
                }
            }
        }
        return points;
    }

    public static class Point {
        // Point properties: x and y coordinates. private --> only accessible within
        // point class.
        private double x;
        private double y;

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

        @Override
        public String toString() {
            return "Point (" + this.x + " , " + this.y + ")";
        }
    }

    static class Circle {
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

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return Math.PI * 2 * radius;
        }


        public boolean contains(Point point) {
            return (point.distance(centre) <= radius);
        }

        @Override
        public String toString() {
            return "Circle of centre ( " + centre.getX() + " , " + centre.getY() + " ) and radius " + radius + " ";
        }
    }

    // Inheritance: FilledCircle inherits the properties of Circle
    // FilledCircle is a subclass/subset of Circle (or it can be said: FilledCircle is a Circle)
    // with additional property of color
    public static class FilledCircle extends Circle {
        private final Color color;

        // Constructor which uses the superclass definition for centre and radius, and assigns color property
        public FilledCircle(Point centre, double radius, Color color) {
            super(centre, radius);
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        // Super(..) to access parent constructor
        // super.radius or super.getArea() to access parent properties and methods respectively
        @Override
        public String toString() {
            return super.toString() + "and colour " + color + " ";
        }
    }


}
