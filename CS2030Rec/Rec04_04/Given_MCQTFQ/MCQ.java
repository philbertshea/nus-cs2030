// MCQ: multiple-choice questions comprising answers: A B C D E
// TFQ: true/false questions comprising answers: T F

package CS2030Rec.Rec04_04.Given_MCQTFQ;

import java.util.Scanner;

public class MCQ {
    String question;
    char answer;

    public MCQ(String question) {
        this.question = question;
    }

    void getAnswer() {
        System.out.print(question + " ");
        answer = (new Scanner(System.in)).next().charAt(0);
        if (answer < 'A' || answer > 'E') {
            throw new InvalidMCQException("Invalid MCQ answer");
        }
    }
}
