// Java has a class named Optional which performs what Maybe does.
// Optional class has ifPresent, map and filter methods

package CS2030;

import java.util.Optional;
import CS2030.Geometry.*;

public class Lec7Slide14 {
    public static void main(String[] args) {
        Optional<Circle> valOpt = Circle.getOptionalCircle(new Point(2, 5), 2);
        Optional<Circle> invOpt = Circle.getOptionalCircle(new Point(5, 2), -2);

        valOpt.ifPresent((Circle c) -> System.out.println("Valid Circle " + valOpt + "of Area " + c.getArea()));
        // Upon execution, we can observe that Optional's toString is "Optional[<thing
        // inside>]"
        invOpt.ifPresent((Circle c) -> System.out.println("Invalid Circle (EMPTY Optional) should not print anything"));

        // Mapping an Optional<Circle> to an Optional<Boolean>
        System.out.println("1. Mapping Optional<Circle> to Optional<Boolean>: " + valOpt + " --> "
                + valOpt.map(x -> x.contains(new Point(2, 3)))); // Should return a Optional[True]
        System.out.println("2. Mapping Optional<Circle> to Optional<Boolean>: " + valOpt + " --> "
                + valOpt.map(x -> x.contains(new Point(2, 10)))); // Should return a Optional[False]
        System.out.println("3. Mapping Optional<Circle> to Optional<Boolean>: " + invOpt + " --> "
                + invOpt.map(x -> x.contains(new Point(5, 2)))); // Should not return anything

        // Filtering through valid Optionals with an additional requirement.
        System.out.println("\nOnly make the Optional valid IF 1) Area>10 or 2) Circum>20");

        // If Area > 10, valOpt.filter() will return valOpt. If Area < 10,
        // valOpt.filter() returns empty optional.
        System.out.println("1. Filter valid Optional with Area>10 requirement. " + valOpt + " --> "
                + valOpt.filter(x -> x.getArea() > 10));

        // If Circum > 20, valOpt.filter() will return itself. If Circum < 20,
        // valOpt.filter() will return an empty optional.
        System.out.println("2. Filter valid Optional with Circum>20 requirement. " + valOpt + " --> "
                + valOpt.filter(x -> x.getCircumference() > 20));

        // invOpt is already an empty optional and hence should always return an empty
        // optional regardless of the filter condition/argument.
        System.out.println("3. Filter invalid Optional should return invalid (empty). " + invOpt + " --> "
                + invOpt.filter(x -> true));

    }
}
