// Take out Point/Circle/FilledCircle classes and put inside a separate java file -- "Geometry.java".

package CS2030;

import java.lang.Math;
import java.util.Scanner;

//
import CS2030.Geometry.*;

import java.awt.Color;

public class Lec3Slide15extra {

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

}
