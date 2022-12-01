package CS2030Rec.Rec01_05;

// Question: Given Rectangle, how to define a Square which inherits from Rectangle
// which: 1. Follows the constraint that all 4 sides are of the same length
// and 2. Returns "Area XX and Perimeter YY" in its toString?
public class Square extends Rectangle {
    private final double length;

    public Square(double length) {
        super(length, length); // IMPORTANT!!
        this.length = length;
        // Note that Rectangle takes in two parameters width and height, while Square
        // only takes in one parameter length.
        // Therefore, we need to use length for both of the parameters of the super
        // method.
        // This means that we "borrow" Rectangle's constructor and apply the same value
        // of length to both width and height.
    }

    // Technically, we do NOT need to write an override method for getArea and
    // getPerimeter, since the width and height values
    // of the Square will equal to length and the Rectangle-inherited methods will
    // return the correct values.

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }

    // We also do not need to write an override method for toString, since the
    // String to return
    // is of the same format as Rectangle for a Square object.

    // Part c
    @Override
    public Square setWidth(double width) {
        return new Square(width);
    }

    @Override
    public Square setHeight(double height) {
        return new Square(height);
    }

    // My Ans: It is not sensible for Square to inherit from Rectangle since it
    // leads to redundancy
    // such as duplicate functions setWidth and setHeight. It is also not sensible
    // for Rectangle to
    // inherit from Square since a Square has more restrictions than a Rectangle.
    // Instead, we should create a class/interface Quadrilateral and allow Square
    // and Rectangle
    // to inherit from it

    // Correct Ans:
    /*
     * Based on the substitutability principle, if Square inherits from Rectangle,
     * then
     * anywhere we expect a Rectangle, we can always substitute it with a Square.
     */

     // An example where we cannot substitute a Rectangle with a Square.
}
