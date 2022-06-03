// Design an abstract Shape base class, where Rectangle and Circle classes extend from it.
// A rectangle will also have the getArea and getPerimeter methods.

/* An abstract class cannot be instantiated by itself; an abstract method cannot be called by itself
i.e. cannot create an instance of abstract class Shape and directly call Shape object's method.
*/
package CS2030;

public class Lec4Slide1_6 {
    
public abstract class Shape { // Abstract class
    public abstract double getArea(); // Abstract methods

    public abstract double getPerimeter(); // Abstract methods

    @Override
    public String toString() {
        return "Shape of Area " + String.format("%.2f" + getArea()) + " and Perimeter "
                + String.format("%.2f" + getPerimeter());
    }
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


public class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    
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
}

}
