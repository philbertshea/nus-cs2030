package CS2030Rec.Rec01_05;

// The correct answer omits the introduction of additional variables, since width and height have already been
// inherited from Rectangle. There is also no need to introduce any override methods since the calculations
// are similar as long as we assign the value of parameter length (which is the single only parameter needed
// for initialisation of Square) to width and height.
public class CorrectAnsSquare extends Rectangle {
    public CorrectAnsSquare(double length) {
        super(length, length);
    }
}


