package CS2030Rec.Rec04_04.Question_QA_Answer;

public class MCQ extends QA {
    // Few things to take note when extending an abstract class. Note that VARIABLES (question, answer) and METHODS (getAnswer) are brought over from QA to MCQ.

    // 1. Constructor
    public MCQ(String question) {
        super(question);
    }

    // 2. Implement abstract methods
    void getAnswer() {
        answer = askQuestion();
        if (answer < 'A' || answer > 'E') {
            throw new InvalidMCQException("Invalid MCQ Answer. Only A to E.");
        }
    }
}
