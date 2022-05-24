// Add functions to count the number of points within a unit disc of a given centre.
package CS2030;

import java.util.Scanner;
import java.lang.Math;

public class Lec1Slide15_17 {
    public static void main(String[] args) {
        int NumOfPoints = getNumber();
        double[] centre = getCentre();
        double points[][] = readPoints(NumOfPoints);
        printPoints(points, NumOfPoints);
        printCoverage(centre, points, NumOfPoints);
        System.out.println("Ended.");
    }

    static void printCoverage(double[] centre, double[][] points, int NumOfPoints) {
        int NumCovered = discCover(centre, points, NumOfPoints);
        System.out.println("The unit disc of centre (" + centre[0] + " , " + centre[1] + "), radius 1 has " + NumCovered
                + " points out of " + NumOfPoints + " points lying within it");
    }

    static boolean isInside(double[] centre, double[] point) {
        // Note that the disc is a unit disc with radius of 1 unit.
        double xsquared = Math.pow((centre[0] - point[0]), 2);
        double ysquared = Math.pow((centre[1] - point[1]), 2);
        double distance = Math.sqrt(xsquared + ysquared);
        return (distance <= 1);
    }

    static int discCover(double[] centre, double[][] points, int NumOfPoints) {
        int NumCovered = 0;
        for (int i = 0; i < NumOfPoints; i++) {
            double[] point = new double[2]; // Initialise array
            point[0] = points[i][0];
            point[1] = points[i][1];
            if (isInside(centre, point)) {
                NumCovered++;
            }
        }
        return NumCovered;
    }

    static double[] getCentre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter centre of disc: ");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double[] centre = { x, y };
        return centre;
    }

    static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of points needed: ");
        int NumOfPoints = scanner.nextInt();
        return NumOfPoints;
    }

    static double[][] readPoints(int NumOfPoints) {
        boolean invalid = false;
        Scanner scanner = new Scanner(System.in);

        // Use a double array for easier management of points.
        double a[][] = new double[NumOfPoints][2];

        for (int i = 0; i < NumOfPoints; i++) {
            invalid = false;
            System.out.println("Enter Point Coordinates:");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            for (int j = 0; j < i; j++) {
                if (a[j][0] == x && a[j][1] == y) {
                    System.out.println("Point repetition. Try again.");
                    invalid = true;
                    i--;
                    break;
                }
            }
            if (!invalid) {
                System.out.println("Point #" + (i + 1) + "(" + x + "," + y + ")");
                a[i][0] = x;
                a[i][1] = y;
            }

        }
        return a;
    }

    static void printPoints(double[][] a, int NumOfPoints) {
        System.out.println("All the " + NumOfPoints + " points are as follows:");
        for (int k = 0; k < NumOfPoints; k++) {
            System.out.println("Point #" + (k + 1) + "(" + a[k][0] + "," + a[k][1] + ")");
        }
    }
}
