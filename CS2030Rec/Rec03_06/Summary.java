package CS2030Rec.Rec03_06;

import java.util.List;
import java.util.ArrayList;

public class Summary {
    public static void main(String[] args) {

        // 1. List<Integer>.
        // Learning Points: 1) Autoboxing and unboxing works for Integer <--> int.
        // 2) Casting of double to int only works for one case: List<Integer>.add((int)
        // double)
        // 3) Printing works for 3 cases: List<Integer> print Integer, int, double.
        // List<Integer> cannot print Double.

        List<Integer> listInteger = new ArrayList<>();
        int one = 1;
        Integer two = 2;
        double a = 1.23;
        Double b = a;

        listInteger.add(one); // Autoboxing to Integer
        listInteger.add(two);
        listInteger.add(3); // Autoboxing to Integer

        /*
         * listInteger.add(a); // Cannot add double to List<Integer>
         * listInteger.add(b); // Cannot add Double to List<Integer>
         */

        listInteger.add((int) a); // Cast double to int and add as Integer (Autoboxing)
        // listInteger.add((int) b); // Error: cannot cast Double to int.
        // listInteger.add((Integer) a); // Error: cannot cast double to Integer
        // listInteger.add((Integer) b); // Error: cannot cast Double to Integer

        System.out.println("\nFrom List<Integer>, print Integer");
        for (Integer x : listInteger) {
            System.out.println("Print Integer: " + x);
        }

        System.out.println("\nFrom List<Integer>, print int");
        for (int x : listInteger) {
            System.out.println("Print int: " + x);
        }

        System.out.println("\nFrom List<Integer>, print double");
        for (double x : listInteger) {
            System.out.println("Print double: " + x);
        }

        /*
         * System.out.println("\nFrom List<Integer>, print Double");
         * for (Double x : listInteger) { // Gives an error: No direct conversion from
         * Integer to Double.
         * System.out.println("Print double: " + x);
         * }
         */

        // 2. List<Double>.
        // Learning Points: 1) Autoboxing and unboxing works for Double <--> double.
        // 2) Casting of int to double works for two cases: List<Double>.add((double)
        // int) / List<Double>.add((double) Integer)
        // 3) Printing works for 2 cases: List<Double> print Double, double. Cannot
        // print any other type like int or Integer.
        List<Double> listDouble = new ArrayList<>();
        double ten = 10;
        double pi = 3.14159;
        Double piWrapped = pi;

        listDouble.add(ten); // Autoboxing
        listDouble.add(piWrapped);
        listDouble.add(2.71828); // Autoboxing

        // listDouble.add(one); // Error: Cannot add int to List<Double>
        // listDouble.add(two); // Error: Cannot add Integer to List<Double>

        listDouble.add((double) one); // Explicitly cast int to double and add as Double via autoboxing
        listDouble.add((double) two); // Explicitly cast Integer to double and add as Double via autoboxing
        // listDouble.add((Double) one); // Error: Cannot cast int to Double
        // listDouble.add((Double) two); // Error: Cannot cast Integer to Double

        System.out.println("\nFrom List<Double>, print Double");
        for (Double x : listDouble) {
            System.out.println("Print Double: " + x);
        }

        System.out.println("\nFrom List<Double>, print double");
        for (double x : listDouble) {
            System.out.println("Print double: " + x);
        }

        /*
         * System.out.println("\nFrom List<Double>, print int");
         * for (int x : listDouble) { // Gives an error of type mismatch: Cannot convert
         * from Double to int
         * System.out.println("Print int: " + x);
         * }
         * 
         * 
         * System.out.println("\nFrom List<Double>, print Integer");
         * for (Integer x : listDouble) { // Gives an error of type mismatch: Cannot
         * convert from Double to Integer
         * System.out.println("Print Integer: " + x);
         * }
         */

        // 3. double[].
        // Learning points: 1) Can add double, Double, int, Integer directly to double[].
        // 2) Casting Compiles for two cases: 1) int to double, 2) Integer to double.
        // 3) Printing works for 2 cases: 1) arrdouble print double , 2) arrdouble print Double 
        double[] arrdouble = new double[10];
        arrdouble[0] = ten;
        arrdouble[1] = piWrapped; // Unboxing: add Double to double[].
        arrdouble[2] = 2.71828;

        arrdouble[3] = one; // Can directly add int to double[].
        arrdouble[4] = two; // Can directly add Integer to double[].
        arrdouble[5] = (double) one; // Can cast int to double.
        // arrdouble[6] = (Double) one; // ERROR: Cannot cast int to Double.
        arrdouble[7] = (double) two; // Can cast Integer to double.
        // arrdouble[8] = (Double) two; // ERROR: Cannot cast Integer to Double.

        System.out.println("\nFrom arrdouble, print double");
        for (double x : arrdouble) {
            System.out.println("Print double: " + x);
        }

        System.out.println("\nFrom arrdouble, print Double");
        for (Double x : arrdouble) {
            System.out.println("Print Double: " + x);
        }

        /*
         * System.out.println("\nFrom arrdouble, print int");
         * for (int x : arrdouble) { // Error: No conversion from double to int
         * System.out.println("Print int: " + x);
         * }
         * 
         * System.out.println("\nFrom arrdouble, print int");
         * for (Integer x : arrdouble) { // Error: No conversion from double to Integer
         * System.out.println("Print int: " + x);
         * }
         * 
         */


         // 4. int[]
         // Learning points: 1) Can add int, Integer directly to int[].
         // 2) Casting is OK for only one case: double to int.
         // 3) Printing works for 3 cases: arrint[] prints int, Integer, double
         int[] arrint = new int[10];
         arrint[0] = one; 
         arrint[1] = two; // Unboxing: Add Integer to int[].
         arrint[2] = 3;
        
         // arrint[3] = ten; // ERROR: Cannot directly add double to int
         // arrint[4] = piWrapped; // ERROR: Cannot directly add Double to int

         arrint[5] = (int) ten;              // Cast double to int
         // arrint[6] = (int) piWrapped;     // ERROR: Cannot Cast Double to int
         // arrint[7] = (Integer) ten;       // ERROR: Cannot Cast double to Integer
         // arrint[8] = (Integer) piWrapped; // ERROR: Cannot Cast Double to Integer
        
         System.out.println("\n From arrint, print int");
         for (int x : arrint) {
            System.out.println("Print int: " + x);
         }

         System.out.println("\n From arrint, print Integer");
         for (Integer x : arrint) {
            System.out.println("Print Integer: " + x);
         }

         System.out.println("\n From arrint, print double");
         for (double x : arrint) {
            System.out.println("Print double: " + x);
         }

         /*
         System.out.println("\n From arrint, print Double");
         for (Double x : arrint) { // Error: Cannot print Double in int[]
            System.out.println("Print Double: " + x);
         }

         */

    }
}
