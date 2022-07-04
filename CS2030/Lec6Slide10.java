package CS2030;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import CS2030.Geometry.Point;

public class Lec6Slide10 {
    public static void main(String[] args) {
        try {
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
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file " + args[0] + "\n" + ex + "\n");
            // Note that instead of System.out.println, we use System.err.println to print
            // errors specifically (And let Java know that this is an error): args[0] -
            // intended filename, ex - intended exception
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.err.println("Missing filename Exception \n" + ex + "\n");
        } finally {
            System.err.println("Program terminates\n");
        }
        // Try-catch-finally block
    }
}
