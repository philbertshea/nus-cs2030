package CS2030Rec.Rec01_02;

public class Circle {
    private final Point centre;
    private final int radius;

    public Circle(Point centre, int radius) {
        this.centre = centre;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals(Object) called");
        if (obj == this) {
            return true;
        }
        if (obj instanceof Circle) {
            Circle circle = (Circle) obj;
            return (circle.centre.equals(centre) && circle.radius == radius);
        } else {
            return false;
        }
    }

    public boolean equals(Circle circle) {
        System.out.println("equals(Circle) called");
        System.out.println("\nCentre of self: " + centre + " \nCentre of other: " + circle.centre);
        System.out.println("\nRadius of self: " + radius + " \nRadius of other: " + circle.radius);
        return circle.centre.equals(centre) && circle.radius == radius;
    }
}
