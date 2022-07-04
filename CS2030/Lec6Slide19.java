// Assertions are used to prevent bugs, while exceptions are used to prevent user mishaps.
// Assertions state that a certain condition should be true at some point of the code
// Preconditions: assertion about program state when the program is invoked
// Postconditions: assertion about program state after the method finishes
package CS2030;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CS2030.Geometry.*;

public class Lec6Slide19 {
    
    static Point createPoint(Scanner scanner) {
        try {
            System.out.println("Enter the coordinates of point.");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            Point point = new Point(x,y);
            return point;
        } catch (Exception ex) {
            System.err.println("Exception \n" + ex);
            return null;
        }
    }

    static ArrayList<Point> halveDistance(ArrayList<Point> points) {
        assert points.size() == 2; // Precondition: assert that there are two points.
        assert 1 == 0 : "Assertion 1==0 is incorrect";  // Assert exp1 : exp2 --> Prints exp2 if exp1 is not fulfilled.

        Point A = points.get(0);
        Point B = points.get(1);
        assert A.equals(B) == false; // Precondition: assert that the points are unique from each other.
        
        Point C = A.midpoint(B);
        assert A.distance(B) == 2*C.distance(B); // Postcondition: assert that the distance is halved compared to before.
        
        points.clear();
        points.add(C);
        points.add(B);
        return points;

    }

    static double checkDistance(ArrayList<Point> points) {
        return points.get(0).distance(points.get(1));
    }

    public static void main(String[] args) throws IllegalArgumentException{
        Scanner scanner = new Scanner(System.in);
        Point A = createPoint(scanner);
        Point B = createPoint(scanner);
        // To prevent user mishaps: throw Exceptions.
        if (A.equals(B)) {
            throw new IllegalArgumentException("Two points coincide with each other.");
        }

        ArrayList<Point> points = new ArrayList<Point>();
        points.add(A);
        points.add(B);
        System.out.println("Original distance is " + checkDistance(points));

        while (checkDistance(points) > 0.2) {
            points = halveDistance(points);
            System.out.println("Distance halved to " + checkDistance(points));
        }

    }
}
