package CS2030Rec.Rec01_05;

import CS2030Rec.Rec01_05.*;

public class ViolateSubstitutionPrinciple {
    public static void main(String[] args) {
        Rectangle[] rects = { new Rectangle(3, 5), new Square(5) };

        // By the Liskov Substitution Principle, if Square inherits from Rectangle,
        // then a Square object should return the same result as Rectangle object
        // as intended when the same command is applied.

        System.out.println(rects[0].setWidth(10).setHeight(20));
        System.out.println(rects[1].setWidth(10).setHeight(20));

        // Since the result is different, this violates the Liskov Substitution
        // Principle
        // Therefore, it is inappropriate for Square to inherit from Rectangle
    }
}
