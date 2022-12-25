package CS2030Rec.Rec04_03.ExceptionsInDetail.TypesOfExceptions;

public class UncheckedExceptions {
    public static void main(String[] args) {
        int num[] = {1, 2, 3, 4};
        System.out.println(num[5]); // Index 5 does not exist for num[] with 4 elements.
        // No Compile error. This gives an unchecked exception.
        // On running this code, the exception ArrayIndexOutOfBoundsException pops up:
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 4

        
    }
}
