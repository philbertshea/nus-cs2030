// A problem is raised when a local variable is accessed and modified in a lambda function.
// Why? 
// Lambda and anonymous classes declared in a method are LOCAL CLASSES. 
// --> Scoped within the method   --> Access to variables of enclosing classes 
// IMPT --> local classes (lambda) capture the value of local variables (i.e. make a copy of local vars like area)
// Why? Because when the method foo() is run, the previous declaration of area is gone from the stack, hence Java creates a new stack item for lambda function and duplicates the value of area together with it.

package CS2030;

import java.util.Optional;

import CS2030.Geometry.*;

public class Lec7Slide18 {

    static double foo() {
        double area = 1; // Here it is effectively final.
        Optional<Circle> valOpt = Circle.getOptionalCircle(new Point(0, 0), 1);
        valOpt.filter(x -> area > 0); // Since there are no changes made to local var "area", it is effectively final,
                                      // so NO ERROR.

        // valOpt.filter(x -> area++ > 1); // ERROR: local var is modified within a
        // lambda function.

        // valOpt.ifPresent(circle -> area = circle.getArea()); // ERROR: local var is
        // re-defined after declaration, within a lambda function

        // area = 2; // This induces ERROR in first filter line, because area is no
        // longer EFFECTIVELY FINAL.

        // Problem: A local variable (variable scoped within a method, with access to
        // variables of enclosed class/method) MUST BE FINAL
        // OR EFFECTIVELY FINAL (i.e. cannot be modified after declaration)

        return area;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
