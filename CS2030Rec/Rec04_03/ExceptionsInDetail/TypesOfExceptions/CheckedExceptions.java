package CS2030Rec.Rec04_03.ExceptionsInDetail.TypesOfExceptions;

import java.io.File;
import java.io.FileReader;

public class CheckedExceptions {
    public static void main(String[] args) {
        File file = new File("E://SomeInvalidFileAddress.txt");
        FileReader fr = new FileReader(file);
        // error: unreported exception FileNotFoundException; must be caught or declared to be thrown
    }
}
