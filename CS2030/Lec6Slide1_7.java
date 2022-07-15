// Use of static keyword: declaration of a field, method, block or class.
package CS2030;

import java.util.ArrayList;
import java.util.List;

import CS2030.Rectangle.RectangleCreator;

import java.awt.Color;

interface Shape {
    public double getArea();

    public double getPerimeter();
}

// A static field is a class-level member declared to be *shared among all
// objects of the class*
class Circle2 implements Shape {
    private double radius;
    private static int numberOfCircles = 0;
    // Static is used for Aggregated Data like total number of objects (This
    // number is shared among the Circle class) and not specific to any
    // individual instance

    static final double PI = 3.14159; // Static also used for constants

    public Circle2(int radius) {
        this.radius = radius;
        numberOfCircles++;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return PI * radius * 2;
    }

    public static int getCircleCount() { // Static method for accessing or changing static fields.
        return numberOfCircles;
    }
}

class Square implements Shape {
    private double length;
    private static int numberOfSquares = 0;

    public Square(double length) {
        this.length = length;
        numberOfSquares++;
    }

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public double getPerimeter() {
        return length * 4;
    }

    public static int getSquareCount() { // Static method for accessing or changing static field
        return numberOfSquares;
    }
    // Note: As static methods are resolved at compile time, there is no overriding.
}

class FactoryCircle {
    // Factory method in factory class to produce Shape.
    // createShape is static because it does not depend on a specific instance of
    // FactoryCircle.
    static Shape createShape(String shape) {
        switch (shape) {
            case ("Circle"):
                return new Circle2(1);
            case ("Square"):
                return new Square(1);
            default:
                return null;
        }

    }
}

class myColors {
    static List<Color> colors = new ArrayList<>(); // static field because the list is shared among all instances of
                                                   // myColors (not specific to one instance of myColors)
    static { // static blocks to initialise static field, colors, that cannot be done using
             // =. (Cannot say colors = [...]. Here need to use add.
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
    }
}

// Only nested classes can be made static. Top-level class cannot be made
// static.

// static class Circle3 {} // Gives an error.

// This is because the idea of static class is that the static nested class is
// not dependent on or owned by any specific instance of the outer
// (higher-level) class it belongs to.
// Therefore if there is no higher-level class (Already highest level),
// cannot be static.

class Rectangle {
    private static int numberOfRectangles = 0;
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            System.out.println("Length or width should be greater than 1. To avoid error, set rectangle to 10 x 5");
        } else if (length < width) {
            System.out.println("Length should be longer than width. Therefore, length is " + width + " and width is "
                    + length + " .");
            this.length = width;
            this.width = length;
        } else if (length == width) {
            System.out.println("This seems to be a square, not a rectangle. ");
            this.length = length;
            this.width = width;
        } else {
            this.length = length;
            this.width = width;
        }

    }

    static class RectangleCreator {
        // RectangleCreator is a class within Rectangle because it is specific to
        // rectangles only.
        // However, since it is static.

        public RectangleCreator() {
            numberOfRectangles++;
        }

        private Rectangle createRectangle() {
            System.out.println("Create rectangle.");
            return new Rectangle(5, 3);
        }
    }
}

public class Lec6Slide1_7 {
    public static void main(String[] args) {
        new RectangleCreator(); // Error if RectangleCreator is not a static nested class
        // new Rectangle(1,2).new RectangleCreator(); // Error if RectangleCreator is a
        // static nested class.

    }
}
