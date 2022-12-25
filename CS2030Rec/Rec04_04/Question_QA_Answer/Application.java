package CS2030Rec.Rec04_04.Question_QA_Answer;

public class Application {
    public static void main(String[] args) {
        MCQ q1 = new MCQ("What is the colour of the sky? White/Blue/Green/Purple/Transparent");
        MCQ q2 = new MCQ("What is the temperature of melting ice in degC? 100/80/40/20/0");
        TFQ q3 = new TFQ("There are infinite real numbers. T/F");

        try {
            q1.getAnswer();
            q2.getAnswer();
            q3.getAnswer();
        } catch (InvalidMCQException e) {
            e.printStackTrace(); // Message (mesg) from InvalidMCQException is included here.
            System.out.println("Invalid Option for MCQ. Only A to E.");
        } catch (InvalidTFQException f) {
            f.printStackTrace(); // Message (mesg) from InvalidTFQException is included here.
            System.out.println("Invalid Option for TFQ. Only T or F.");
        } finally {
            // If no exception is caught, this marks the end of the 3 questions.
            // If an exception is caught, this is printed after the Exception is caught and
            // handled, and try block execution ends.
            System.out.println("That's the end of the QnA. Try your luck again!");
        }

        System.out.println("Upon catching exception --> \n1. Skip remaining code in try block. Pass to catch block and handle in catch block. \n2. Run finally block. \n3. Run code after try-catch-finally block");
        q1.getAnswer();
    }
}
