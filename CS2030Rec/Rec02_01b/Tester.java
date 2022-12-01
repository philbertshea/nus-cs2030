package CS2030Rec.Rec02_01b;

// No need to explicitly import class/types which are IN THE SAME PACKAGE.
import CS2030Rec.Rec01_02.Point;

public class Tester {
    public static void main(String[] args) {
        Circle c = new Circle(new Point(0,0), 10);
        // Shape s = c;
        Printable p = c;
        // by doing s=c and p=c, we are restricting s and p to ONLY the respective properties of Shape and Printable
        // HOWEVER since Circle can only extend one class not two, we cannot make s=c and p=c at the same time.

        p.print();
    }
}

