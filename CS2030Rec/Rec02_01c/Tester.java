package CS2030Rec.Rec02_01c;

// No need to explicitly import class/types which are IN THE SAME PACKAGE.
import CS2030Rec.Rec01_02.Point;

// It seems that part c works as well. We can create an interface which extends Shape and Printable
// And then we can let Circle implement this "combined" interface called PrintableShape.

public class Tester {
    public static void main(String[] args) {
        Circle c = new Circle(new Point(0, 0), 10);
        Shape s = c;
        Printable p = c;
        // by doing s=c and p=c, we are restricting s and p to ONLY the respective
        // properties of Shape and Printable
        // Even though c implements BOTH Shape and Printable, s can only access
        // properties of Shape, while p can only access properties of Printable.

        System.out.println("Let's try which of the statements work.");
        // s.print(); // Does NOT work because a Shape object does not have method print
        p.print(); // Works because a Printable object has method print
        s.getArea(); // Works because a Shape object has method getArea
        // p.getArea(); // Does NOT work because a Printable object does not have method
        // getArea

    }
}
