package CS2030Rec.Rec04_04.Question_QA_Answer;

import java.util.Scanner;

// Make this an abstract class (QA) which cannot create an instance of itself
// QA can only be inherited by subtypes like MCQ and TFQ. Cannot create an instance of QA
abstract class QA {
    String question;
    char answer;

    public QA(String question) {
        this.question = question;
    }

    abstract void getAnswer();

    // We can extract out the asking of question.
    char askQuestion() {
        System.out.print(question + ": ");
        return (new Scanner(System.in)).next().charAt(0);
    }
}
