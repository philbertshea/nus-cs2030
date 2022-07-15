// We csn implement a Maybe class, 
// For reusability, I placed it in a separate file named Lec7Maybe.java, and defined it as a public class.
package CS2030;
import CS2030.Geometry.*;
import CS2030.Lec7Maybe;

public class Lec7Slide5_8 {
    public static void main(String[] args) {
        Lec7Maybe<Circle> validCircle = Circle.getMaybeCircle(new Point(0,0), 1);
        Lec7Maybe<Circle> invalidCircle = Circle.getMaybeCircle(new Point(0,0), -1);

        System.out.println("Maybe Circle Printer \n Valid Circle \n" + validCircle + " \n Invalid Circle \n" + invalidCircle);

        // validCircle.getArea();  // this gives an error because validCircle is a Maybe instance, which does not have the properties of the Circle instance 
        // A generic class does not have the properties of its parameterised type.
    }
}
