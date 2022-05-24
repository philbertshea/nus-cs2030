import java.util.Scanner;

public class Lec2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle disc = getDisc(scanner);
        int numPoints = getNumofPoints(scanner);
        Point[] points = readPoints(scanner, numPoints);
        Boolean[] insideDisc = insideCounter(disc, points);
        printPoints(points, insideDisc);
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
        public boolean equals(Point otherpoint) {
            return (distance(otherpoint) == 0);
        }

        // Distance function for Point object takes in another point object as parameter
        // and returns the distance between that otherpoint and itself.
        public double distance(Point otherpoint) {
            double Xdistsquared = (otherpoint.x - this.x) * (otherpoint.x - this.x);
            double Ydistsquared = (otherpoint.y - this.y) * (otherpoint.y - this.y);
            return Math.sqrt(Xdistsquared + Ydistsquared);
        }

        // toString is a function which describes the object as a string value. As it is
        // predefined, it is overrided and therefore, marked with @Override.
        @Override
        public String toString() {
            return "Point (" + this.x + " , " + this.y + ")";
        }
    }

    public static class Circle {
        private Point centre;
        private double radius;

        // Constructor for unit circle: when no radius parameter is provided,
        // automatically assumed to be a unit circle of radius 1.0 units.
        // Without this, an error will appear if the Main driver has Circle(<1
        // parameter>) used to create a Circle object. (2 expected.)
        public Circle(Point centre) {
            this.centre = centre;
            this.radius = 1.0;
        }

        // Constructor for circle with radius provided.
        public Circle(Point centre, double radius) {
            this.centre = centre;
            this.radius = radius;
        }

        // Check if the point is within the circle.
        public boolean contains(Point point) {
            // Use distance function which is specific to Point objects
            return (point.distance(centre) <= radius);
        }
    }
}
