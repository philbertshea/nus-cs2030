package CS2030Rec.Rec03_02;
import java.util.Date;

public class WrapperDelay {
    public static void main(String[] args) {
        System.out.println("Start Time: " + new Date());
        double sum = 0.0; // If double is changed to Double, it will take a longer time to run
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("End Time: " + new Date());
    }
}

// Inferences:
/* Despite it’s conveniences, there is an associated overhead in the use of autoboxing. In
addition, due to immutability of Integer, many objects are created. */
