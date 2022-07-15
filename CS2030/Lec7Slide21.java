package CS2030;

import CS2030.Geometry.*;
import java.util.Optional;

public class Lec7Slide21 {
    public static void main(String[] args) {
        Optional<OptCircle> c1 = OptCircle.getOptCircle(new Point(1, 0), 1); // Optional[OptCircle of Centre
                                                                             // Optional[Point (1.0 , 0.0)] and radius
                                                                             // 1.0]
        Optional<OptCircle> c2 = OptCircle.getOptCircle(new Point(2, 1), 0); // Optional.empty

        System.out.println(c1 + " \n " + c2);

        // How to get the Optional<Point> from Optional<OptCircle> c1? Does map work?
        System.out.println(c1.map(x -> x.getCentre())); // Optional[Optional[Point (1.0 , 0.0)]]
        // Problem: Returns a double (nested) Optional

        // Solution: Use flatmap to "flatten" two Optionals into one
        System.out.println(c1.flatMap(x -> x.getCentre())); // Optional[Point (1.0 , 0.0)]

        // By Ctrl+Click onto map or flatMap, it can be observed that while map returns
        // Optional.of(mapper.apply(value)),
        // flatMap typecasts mapper.apply(value) of type Optional and returns that,
        // after checking for Non-Null condition.

    }
}
