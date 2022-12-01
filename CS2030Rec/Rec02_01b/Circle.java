package CS2030Rec.Rec02_01b;

import CS2030Rec.Rec01_02.Point;

// WE note one main problem with using abstract class.
// Circle can only extend one class, so it cannot inherit the properties of both Shape and Printable
// A class can only extend one class, but it can implement more than one interface.
// Using interfaces rather than classes/ abstract classes will allow for improved 
public class Circle extends Printable {
    private final double radius;
    private final Point centre;

    @Override
    public void print() {
        System.out.println("This is a circle");
    }

    public Circle(Point p, double radius) {
        this.radius = radius;
        this.centre = p;
    }

}