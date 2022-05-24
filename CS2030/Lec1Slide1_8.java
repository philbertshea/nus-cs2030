package CS2030;

import java.util.Scanner;

public class Lec1Slide1_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Define the scanner

        System.out.println(scanner.next()); // scanner.next() requests for input, while System.out.println gives an output
        
        // An alternative way of I/O
        // Java requires static typing, i.e. the type of the variable must be explicitly defined. Cannot use var ...
        double x; 
        double y;
        x = scanner.nextDouble(); // nextDouble is also used to get input for double values
        y = scanner.nextDouble();
        
        System.out.println("(" + x + "," + y + ")");
    }
}