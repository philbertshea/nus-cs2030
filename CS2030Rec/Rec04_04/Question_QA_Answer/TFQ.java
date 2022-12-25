package CS2030Rec.Rec04_04.Question_QA_Answer;

public class TFQ extends QA {
    public TFQ(String question) {
        super(question);
    }

    void getAnswer() {
        answer = askQuestion();
        if (!(answer == 'T' || answer == 'F')) {
            throw new InvalidTFQException("Invalid TFQ Answer. Only T(True) or F(False).");
        }
    }
}
