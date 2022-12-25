package CS2030Rec.Rec04_04;

import java.util.Scanner;
import java.util.List;

public class QA<T> {
    String question;
    T answer;
    List<T> answerList;

    public QA(String question, List<T> answerList) {
        this.question = question;
        this.answerList = answerList;
    }

    void getAnswer() {
        System.out.print(question + " : ");
        Scanner sc = new Scanner(System.in);

        // Note: Casting as below DOES NOT change the ACTUAL TYPE OF OBJECT.
        // Casting is telling the compiler that an object of some supertype is actually of a specific subtype. (EG int <--> double)
        // To CONVERT a String to an Integer/Double, need to use specific methods from Integer and Double
        // Integer.parseInt(String str) or Double.valueOf(String str)

        // answer = (T) sc.next();

        // We cannot possibly use a generic method that CONVERTS A STRING TO WHATEVER WE DESIRE, because the conversion 
        // methods are different for various classes. Therefore, need to check for type T --> Apply corresponding conversion method 
        // (Integer --> parseInt, Double --> valueOf)

        // We have to indirectly infer T (E.g. cannot use T==Integer) because Java uses type erasure, so T has no purpose at runtime.
        String strAns = sc.next();
        if (answerList.get(0) instanceof Integer) {
            Integer intAns = Integer.parseInt(strAns);
            if (!answerList.contains(intAns)) {
                throw new InvalidQAException("Invalid QA Answer. Accepted Integer Answers: " + answerList);
            }
        } else if (answerList.get(0) instanceof Double) {
            Double douAns = Double.valueOf(strAns);
            if (!answerList.contains(douAns)) {
                throw new InvalidQAException("Invalid QA Answer. Accepted Double Answers: " + answerList);
            }
        } else if (answerList.get(0) instanceof String) {
            if (!answerList.contains(strAns)) {
                throw new InvalidQAException("Invalid QA Answer. Accepted String Answers: " + answerList);
            }
        }

        /*
        System.out.println("Answer is: " + answer);
        System.out.println(answer.getClass());
        System.out.println("AnswerList is: " + answerList);
        System.out.println("Answer Contains is: " + answerList.contains(answer));

        if (!answerList.contains(answer)) {
            throw new InvalidQAException("Invalid QA Answer");
        }

        */
    }

}
