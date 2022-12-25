package CS2030Rec.Rec04_04;

import java.util.List;
import java.util.ArrayList;

public class QAApplication {
    public static void main(String[] args) {
        // My Try: QA and InvalidQAException
        List<Integer> ansList = new ArrayList<>();
        ansList.add(1);
        ansList.add(2);
        QA<Integer> q4 = new QA<>("One plus one is ", ansList);
        try {
            q4.getAnswer();
        } catch (InvalidQAException e) {
            e.printStackTrace();
            System.out.println("Invalid QA Answer.");
        }

        // My Try: QA and InvalidQAException
        List<String> ansList2 = new ArrayList<>();
        ansList2.add("A");
        ansList2.add("B");
        QA<String> q5 = new QA<>("A: 1+1=2 or B: 1+1=1", ansList2);
        try {
            q5.getAnswer();
        } catch (InvalidQAException e) {
            e.printStackTrace();
            System.out.println("Invalid QA Answer.");
        }
    }
}
