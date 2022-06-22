// The problems with non-Generics

package CS2030.Lec5Generics;

import CS2030.Lec5Generics.Geometry.*;

public class Main {
    public static void main(String[] args) {
        CircleQueue cq = new CircleQueue(10);
        cq.add(new Circle(new Point(1, 1)));
        cq.add(new Circle(new Point(2, 2)));
        System.out.println(cq.remove().getArea()); // System knows that the object is a circle, therefore no error.

        ObjectQueue oq = new ObjectQueue(10);
        oq.add(new Circle(new Point(1, 1)));
        oq.add(new Circle(new Point(2, 2)));
        // System.out.println(oq.remove().getArea());
        /*
         * 1. Gives a compilation error,
         * requiring typecasting. Like (Circle) oq.remove()
         */
        System.out.println(((Circle) oq.remove()).getArea());

        // cq.add(new Point(1,2));
        /*
         * VS Code sounds off in advance. But In Terminal, this gives NO COMPILATION
         * ERROR, but A RUNTIME ERROR. This raises a problem in type safety: it is
         * always preferred to have type-related errors raised in compilation, not
         * during runtime
         */
    }
}
