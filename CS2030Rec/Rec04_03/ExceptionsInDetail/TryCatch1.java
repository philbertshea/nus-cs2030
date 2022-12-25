package CS2030Rec.Rec04_03.ExceptionsInDetail;

public class TryCatch1 {
    public static void main(String[] args) {
        try {
            int a[] = new int[2];
            System.out.println("Access element three : " + a[3]); 
            // Since the array only has 2 elements, this attempt to access
            // the third element, a[3] results in an ArrayIndexOutOfBoundsException.
            // We should expect such an exception and list it in the catch block.
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown : " + e);
        }

        System.out.println("Out of the block");
    }
}
