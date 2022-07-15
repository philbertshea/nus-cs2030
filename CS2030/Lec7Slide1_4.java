// Null references can give rise to new problems
// Therefore, it is best to avoid the use of null referenxes altogether.

package CS2030;

import CS2030.Geometry.*;

public class Lec7Slide1_4 {
    public static void main(String[] args) {
        // The direct use of constructor gives no error, because there is no
        // error-checking for whether the radius is valid.
        Circle circle = new Circle(new Point(0, 0), -1);
        circle.getArea();

        // It is more appropriate to implement a method which checks for parameter validity,
        // if the parameters are valid, it returns a new Circle object. If the parameters are invalid, it returns null.
        // However, null gives rise to problems. 
        Circle circle2 = Circle.getCircle(new Point(0,0), -1);
        circle2.getArea(); // Though there is no compilation error, a NullPointerException is thrown at runtime.

    }
}