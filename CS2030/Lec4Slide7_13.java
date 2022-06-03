
/* Single Responsibility Principle: 
A class should have one, and only one, reason to change.
Responsibility is the "one reason to change": every class should only have *ONE RESPONSIBILITY*
, i.e. ONE ultimate purpose. -> Easier to manage in the long run.
Instead of adding methods to class when requirements change, separate the new functionalities into individual classes or entities.
*/

package CS2030;

public class Lec4Slide7_13 {

    public abstract class Shape { // Abstract class
        public abstract double getArea(); // Abstract methods

        public abstract double getPerimeter(); // Abstract methods

        @Override
        public String toString() {
            return "Shape of Area " + String.format("%.2f" + getArea()) + " and Perimeter "
                    + String.format("%.2f" + getPerimeter());
        }

        /*
         * This violates the Single Responsibility Principle.
         * The Shape class has only one responsibility - to manage
         * properties/functionalities unique to Shapes.
         * Leave the scaling and printing to separate classes.
         * 
         * public abstract Shape scale(double factor);
         * public abstract String print();
         */
    }

    public abstract class Scalable {
        // Besides Shapes, other Objects can be scalable.
        // Hence this is not a responsibility of the Shape class. Put into separate
        // class.
        public abstract Object scale(double factor);
    }

    public abstract class Printable {
        // Besides Shapes, other things can be printable.
        // Hence this is not a responsibility of the Shape class. Put into another
        // class.
        public abstract String print();
    }

    public class Rectangle extends Shape {
        private final double length;
        private final double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() {
            return this.length;
        }

        public double getWidth() {
            return this.width;
        }

        @Override
        public double getArea() {
            double area = this.length * this.width;
            return area;
        }

        @Override
        public double getPerimeter() {
            double perimeter = 2 * this.length + 2 * this.width;
            return perimeter;
        }
    }

    // Instead of classes, let's adopt the use of interfaces.
    public interface ShapeInt {
        public double getArea();

        public double getPerimeter();
    }

    public interface ScalableInt {
        public Object scale(double factor);
    }

    public interface PrintableInt {
        public String print();
    }

    // Even though a class can only INHERIT ONE CLASS, it can implement several
    // INTERFACES

    public class Circle implements ShapeInt, ScalableInt, PrintableInt {
        private final double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        // getArea() and getPerimeter() come from interface Shape
        @Override
        public double getArea() {
            double area = Math.PI * Math.pow(radius, 2);
            return area;
        }

        @Override
        public double getPerimeter() {
            double perimeter = 2 * Math.PI * radius;
            return perimeter;
        }

        // scale(double factor) comes from interface Scalable
        @Override
        public Circle scale(double factor) {
            return new Circle(radius * factor);
        }

        // print() comes from interface Printable
        @Override
        public String print() {
            return "Circle with area " + getArea() + " amd perimeter " + getPerimeter();
        }
    }

    // According to the Open-Closed Principle, software entities should be *OPEN FOR
    // EXTENSION / IMPLEMENTATION*
    // but *CLOSED FOR MODIFICATION* -- do not change the base class to meet needs
    // of subclass.
    // INSTEAD: If superclass doesn't meet needs, may consider creating a different
    // superclass.

    public class Square implements ShapeInt, ScalableInt, PrintableInt {
        private final double length;

        public double getLength() {
            return this.length;
        }

        public Square(double length) {
            this.length = length;
        }

        @Override
        public double getArea() {
            double area = this.length * this.length;
            return area;
        }

        @Override
        public double getPerimeter() {
            double perimeter = 4 * this.length;
            return perimeter;
        }

        @Override
        public Square scale(double factor) {
            return new Square(this.length * 2);
        }

        @Override
        public String print() {
            return "Square of length " + length;
        }
    }
}
