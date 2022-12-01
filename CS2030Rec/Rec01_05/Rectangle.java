package CS2030Rec.Rec01_05;

public class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Part b. 
    // My Ans: instead of returning the existing rectangle with an edited width/height,
    // the program returns a new rectangle object which takes up additional memory.
    // Correct Ans: Since Square inherits from Rectangle, this means that a user who 
    // uses setWidth or setHeight methods from a Square object will be creating a Rectangle
    // object instead which is not a Square.

    public Rectangle setWidth(double width) {
        Rectangle newRect = new Rectangle(width, this.height);
        return newRect;
    }

    public Rectangle setHeight(double height) {
        Rectangle newRect = new Rectangle(this.width, height);
        return newRect;
    }

    // End of part b

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "area " + String.format("%.2f", getArea()) +
                " and perimeter " + String.format("%.2f", getPerimeter());
    }

}
