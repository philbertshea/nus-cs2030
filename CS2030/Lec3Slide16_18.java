// This is the NUS explanation for Static vs Dynamic Binding.

/* Binding is the connecting of a method called (usually in main driver) to method body. 
Static Binding: early binding, where the method call is linked to method body at compile time. Used in Method Overloading.
Dynamic Binding: late binding. Method call is connected to method body at runtime only. Used in Method Overriding.
*/

package CS2030;

import CS2030.Geometry.*;
import java.awt.Color;

public class Lec3Slide16_18 {

    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        // circleArray consists of two Circles and one FilledCircle (which is a subset
        // of, hence is a Circle)
        Circle[] circleArray = { new Circle(p1, 1), new Circle(p2, 5), new FilledCircle(p1, 3, new Color(0, 50, 250)) };

        // Reproduce Static Binding: type is determined and binding is done on
        // compilation.
        for (Circle circle : circleArray) {
            if (circle instanceof Circle) {
                System.out.println((Circle) circle); // Cast to type Circle on compilation.
            } else if (circle instanceof FilledCircle) {
                System.out.println((FilledCircle) circle); // Cast to type FilledCircle on compilation.
            }
        }

        // Method Overloading is determined at *Compile time*: The Compiler decides,
        // based on given parameters,
        // which method should be invoked. Hence: Static Binding.
        // Number, order or type of arguments is different => Mwthod Overloading.
        Circle c1 = new Circle(p1, 2);
        Circle c2 = new Circle(p1);
        System.out.println("Circle c1 area is twice that of Circle c2");
        c1.getArea();
        c2.getArea();

        // Dynamic Binding: type is determined and binding is done on runtime.
        for (Circle circle : circleArray) {
            System.out.println(circle); // type is determined on runtime.
        }

        // Method Overriding: both the parent and the child classes have the same
        // method. Type of object determined
        // at runtime dwtermines which method is to be executed.

        // NOTE: equals(other) is Overloading not Overriding, because the type of
        // argument is different compared to Object.equals()
        // ** Number, order or type of arguments is different => Mwthod Overloading.
    }

}
