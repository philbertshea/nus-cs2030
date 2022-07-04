// One way to handle exceptions.
// NOTE: This breaks the abstraction barrier and hence is not desirable. 
// It is preferred to use a try-catch-finally block to handle exceptions, 
// on top of declaring the exception thrown (public void m1() throws FileNotFoundException)
package CS2030;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import CS2030.Geometry.Point;

public class Lec6Slide8 {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader(args[0]);
        // If no exception is thrown, a compilation error is produced.
        // If the file cannot be found, the exception will be thrown.
        Scanner scanner = new Scanner(file);
        Point[] points = new Point[100];
        int numOfPoints = 0;
        // reading the point x and y parameters from scanner and adding point instances
        // to the points list
        while (scanner.hasNextDouble()) {
            double x = Double.parseDouble(scanner.next());
            double y = Double.parseDouble(scanner.next());
            points[numOfPoints] = new Point(x, y);
            numOfPoints++;
        }
    }
}
