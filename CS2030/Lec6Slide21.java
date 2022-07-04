package CS2030;

public class Lec6Slide21 {
    // An enum is a special type of CLASS mainly used for defining constants.
    enum Color {
        RED, GREEN, BLUE // Defined three constants. Instead of using Strings, this prevents errors as
                         // every time the constant is called, its full name is used for the call.
    }

    enum Level {
        LOW, MEDIUM, HIGH
    }

    public static void main(String[] args) {
        Color color = Color.BLUE;

        Level l = Level.LOW;
        switch(l) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }
    }
}
