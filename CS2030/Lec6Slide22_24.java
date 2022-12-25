package CS2030;

public class Lec6Slide22_24 {
    Map<String, String>
    // Besides defining constants, enums can also store variables, methods and have
    // constructors, just like any other class.
    enum Color {
        BLACK(0, 0, 0),
        WHITE(1, 1, 1),
        RED(1, 0, 0),
        GREEN(0, 1, 0),
        BLUE(0, 0, 1),
        YELLOW(0, 1, 1),
        PURPLE(1, 0, 1);

        private final double r;
        private final double g;
        private final double b;

        Color(double r, double g, double b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public double luminance() {
            return (0.2126 * r + 0.7152 * g + 0.0722 * b);
        }

        public String toString() {
            return "( " + r + " , " + g + " , " + b + " )";
        }
    }

    public static void main(String[] args) {

        Color c1 = Color.BLUE;
        Color c2 = Color.YELLOW;
        System.out.println("Color BLUE " + c1 + " luminance: " + c1.luminance());
        System.out.println("Color YELLOW " + c2 + " luminance: " + c2.luminance());

    }
}
