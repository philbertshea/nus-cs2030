package CS2030Rec.Rec01_05;

import CS2030Rec.Rec01_05.*;

public class TestSquare {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(5, 10);
        Square sq = new Square(5);
        CorrectAnsSquare csq = new CorrectAnsSquare(5);

        System.out.println("Rectangle: " + rec);
        System.out.println("Square: " + sq);
        System.out.println("CorrectAnsSquare: " + csq);

        // We can note that both Square and CorrectAnsSquare give the same results for
        // the same length parameter given.
        // To save time, work smart and cut out on unnecessary details / override
        // methods.
    }
}
