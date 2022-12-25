package CS2030Rec.Rec04_04.Given_MCQTFQ;

public class Application {
    public static void main(String[] args) {
        MCQ q1 = new MCQ("What is the colour of the sky? White/Blue/Green/Purple/Transparent");
        MCQ q2 = new MCQ("What is the temperature of melting ice in degC? 100/80/40/20/0");
        TFQ q3 = new TFQ("There are infinite real numbers. T/F");

        // Exception is thrown if invalid answers are received. Since the caller does
        // not catch these exceptions, code stops execution.
        q1.getAnswer();
        q2.getAnswer();
        q3.getAnswer();

        System.out.println(
                "\nEnd Of First Section - No Exception Handling in caller block. \n\nStart Of Second Section - Exception Handling with try/catch/finally in caller block. \n");
        // When code in try block throws exceptions to caller, they are caught
        // accordingly and the remaining code in try block is not executed.
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
