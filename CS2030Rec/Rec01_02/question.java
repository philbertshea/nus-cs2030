package CS2030Rec.Rec01_02;

import CS2030Rec.Rec01_02.Circle;
import CS2030Rec.Rec01_02.Point;

public class question {
    public static void main(String[] args) {
        System.out.println("Given the following code fragment: ");
        
        Circle c1 = new Circle(new Point(0,0), 10);
        Circle c2 = new Circle(new Point(0,0), 10);
        Object o1 = c1;
        Object o2 = c2;

        System.out.println("What is the output of the following statements?\n");

        System.out.println("o1.equals(o2): " + o1.equals(o2) + "\n"); 
        // My first guess: o1.equals calls the pre-defined equals function of Object that returns (this == o2) so FALSE.
        // Correct Ans: FALSE.

        System.out.println("o1.equals((Circle) o2): " + o1.equals((Circle) o2) + "\n");
        // My first guess: False. o1 still calls the pre-defined equals function which will only give true if comparing o1 with o1 itself.
        // Correct Ans: FALSE

        System.out.println("o1.equals(c2): " + o1.equals(c2) + "\n");
        // My first guess: False. Same reason as above.
        // Correct Ans: FALSE

        System.out.println("o1.equals(c1): " + o1.equals(c1) + "\n");
        // My first guess: False. o1 is assigned the value of c1 but both are of different types. Therefore it will fail the strict this == c1 test.
        // Correct Ans: TRUE. Because Object o1 = c1. so this = o1 = c1.

        System.out.println("c1.equals(o2): " + c1.equals(o2) + "\n");
        // My first guess: Firstly, c1 and o2 are not the same instance. Secondly, o2 is of type Object, not of type Circle, so o2 instanceof Circle will return false.
        // Therefore, though c1.equals calls the self-defined equals function in Circle.java, it should return false.
        // Correct Ans: FALSE. o2 is of type Object and not explicitly casted to Circle.

        System.out.println("c1.equals((Circle) o2): " + c1.equals((Circle) o2) + "\n");
        // My first guess: By casting o2 to type Circle explicitly, this is effectively the same as c1.equals(c2). Since c1 and c2 share the same centre
        // and same radius, by the overridden function equals in Circle, it should return true.
        // Correct Ans: FALSE.
        // Why?? Because when we debug, we observe that the centre of c1 and centre of c2 = (Circle) o2 are not fundamentally the same instance.
        // They have different addresses. And Point.java does not have any override function for equals.

        // This means that when calling c1's equal(Circle) which checks for circle.centre.equals(centre), this latter equals is actually 
        // the pre-defined equals for an Object. (remember Point inherits Object) Therefore, this only returns true if the two centres are
        // fundamentally the same centre point with the same address. NOT CHECKING FOR x and y values.

        System.out.println("c1.equals(c2): " + c1.equals(c2) + "\n");
        // My first guess: Based on previous example, this returns false because of a fundamental flaw in checking for centre point.
        // Correct Ans: FALSE

        System.out.println("c1.equals(o1): " + c1.equals(o1) + "\n");
        // My first guess: Returns true because the first check (this == o1) will pass.
        // Correct Ans: TRUE

        System.out.println("A clarification for part (f). If we use the same point with the same address for centres of c1 and c2, (f) will return true.");
        Point p = new Point(0,0);
        c1 = new Circle(p, 10);
        c2 = new Circle(p, 10);
        o1 = c1;
        o2 = c2;
        System.out.println("AFTER ADJUSTING CENTRES TO THE SAME POINT: c1.equals((Circle) o2): " + c1.equals((Circle) o2) + "\n");
    }
}
