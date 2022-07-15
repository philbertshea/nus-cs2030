// ifPresent method accepts a lambda expression with a void return type
// However, to accept a lambda expression which returns a value, we need an interface that accepts two type parameters.
// Currently, Actionable only accepts one type parameter Circle (object enclosed within Maybe)

package CS2030;

import CS2030.Lec7Maybe;
import CS2030.Geometry.*;

interface Mappable<T, R> {
    R apply(T t); // apply takes in an object t of type T as parameter, and
}

public class Lec7Slide13 {
    public static void main(String[] args) {
        Lec7Maybe<Circle> valMaybe = Circle.getMaybeCircle(new Point(1, 1), 2);
        Lec7Maybe<Circle> invMaybe = Circle.getMaybeCircle(new Point(1, 1), -1);
        System.out.println("Valid " + valMaybe + " Invalid " + invMaybe);

        // Try the map function on a valid Maybe<Circle>
        Lec7Maybe<Boolean> valBool = valMaybe.map(new Mappable<Circle, Boolean>() {
            public Boolean apply(Circle c) {
                System.out.println("Map Maybe<Circle>" + valMaybe + "to a Maybe<Boolean>");
                return (c.getArea() > 10); // Maps thing (Circle) to thing(Boolean)
            }
        });

        valBool.ifPresent(new Actionable<Boolean>() {
            public void doit(Boolean b) {
                System.out.println("New Maybe<Boolean> is " + valBool);
                System.out.println("Does the circle in valMaybe have an area > 10 units2?" + b);
            }
        });

        // Try the map function on an invalid Maybe<Circle>
        // When executed, nothing is printed out. This means that the map function
        // cannot be executed on an empty Maybe.
        invMaybe.map(new Mappable<Circle, Boolean>() {
            public Boolean apply(Circle c) {
                System.out.println("Map Invalid Maybe" + invMaybe + "to a Maybe<Boolean>");
                return (c.getCircumference() > 5);
            }
        }).ifPresent(
                (Boolean b) -> System.out.println("Does the circle in invMaybe have a circumference > 5 units?" + b));

    }
}
