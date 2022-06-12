// Accepting multiple points.
package CS2030;

import java.util.Scanner;

public class Lec1Slide9 {
    public static void main(String[] args) {
        boolean invalid = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of points needed: ");
        int NumOfPoints = scanner.nextInt();

        double a[] = new double[NumOfPoints * 2];

        for (int i = 0; i < NumOfPoints; i++) {
            invalid = false;
            System.out.println("Enter Point Coordinates:");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();

            for (int j = 0; j < (i * 2); j = j + 2) {
                if (a[j] == x && a[j + 1] == y) {
                    System.out.println("Point repetition. Try again.");
                    invalid = true;
                    i--;
                    break;
                }
            }
            if (!invalid) {
                System.out.println("Point #" + (i + 1) + "(" + x + "," + y + ")");
                a[i * 2] = x;
                a[i * 2 + 1] = y;
            }

        }

        scanner.close();
        System.out.println("All the " + NumOfPoints + " points are as follows:");
        for (int k = 0; k < NumOfPoints; k++) {
            System.out.println("Point #" + (k + 1) + "(" + a[k * 2] + "," + a[k * 2 + 1] + ")");
        }
    }
}
