package CS2030Rec.Rec02_01c;

import CS2030Rec.Rec01_02.Point;

public class Circle implements PrintableShape {
    private final Point centre;
    private final double radius;

    @Override
    public void print() {
        System.out.println("This is a circle.");
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public Circle(Point p, double radius) {
        this.centre = p;
        this.radius = radius;
    }

}

