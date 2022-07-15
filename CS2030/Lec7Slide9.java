// We need to define a ifPresent method which enables actions to be performed on the parameterised object.
// ie if Circle is Valid, we need some way to allow for methods on a ValidCircle within the Maybe<Circle>(Circle) instance.

package CS2030;

import CS2030.Geometry.*;
import CS2030.Lec7Maybe;

interface Actionable<T> {
    void doit(T t); // An abstract method doit, within generic interfsce Actionable that takes in
                    // parameterised type T
}

public class Lec7Slide9 {
    public static void main(String[] args) {
        Lec7Maybe<Circle> validMaybe = Circle.getMaybeCircle(new Point(1, 1), 1);
        Lec7Maybe<Circle> invalMaybe = Circle.getMaybeCircle(new Point(1, 1), -1);

        // If the circle is valid, check if it contains Point(0,0) and print result.
        validMaybe.ifPresent(new Actionable<Circle>() {
            public void doit(Circle c) {
                System.out.println(
                        "#1\nCircle is valid. \nPoint(0,0) in circle? : " + c.contains(new Point(0, 0)) + "\n");
            }
        });

        // If the circle is valid, print Circle name and get Area.
        validMaybe.ifPresent(new Actionable<Circle>() {
            public void doit(Circle c) {
                System.out.println("#2\nCircle is valid: " + c + "\nCircle Area: " + c.getArea() + "\n");
            }
        });

        // If the circle is valid, get its circumference.
        invalMaybe.ifPresent(new Actionable<Circle>() {
            public void doit(Circle c) {
                System.out.println("#3\nCircle is valid. Its circumference is : " + c.getCircumference() + "\n");
            }
        });

        // Note that within the anonymous inner class within ifPresent(...), since there
        // is only one single abstract method, the class name Actionable<> and the
        // abstract method doit are not necessary. In replacenent, we can use lambda functions like (Circle c) -> System.out.println(...)
        // this is a nameless, single-use function which takes in some parameter Circle c and executes System.out.println(...) 
        // Interestingly, action.doit(Circle c) still executes this function even though it is not an Actionable with a doit method, possibly because there is only one method provided.
        validMaybe.ifPresent((Circle c) -> System.out.println("#4\nValid Circle\n"));

        // Using lambda expressions : lambda expressions allow methods to be stored as values
        Actionable<Circle> action = (Circle c) -> System.out.println("#5\nCircle is valid. \nPoint(5,5) in circle ? : " + c.contains(new Point(5,5)) + "\n");
        validMaybe.ifPresent(action);
        invalMaybe.ifPresent(action);
    }
}
