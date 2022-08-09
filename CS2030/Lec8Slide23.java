package CS2030;

import java.util.function.Supplier;
import java.util.Scanner;
import java.util.stream.Stream;

// Closure: Lambda environment not only stores the function to invoke, but also the data in the enclosing environment
public class Lec8Slide23 {
    static class DelayedData {
        private int index;
        private Supplier<Integer> input; // Note that Supplier<Integer> is a type of functional interface

        public DelayedData(int index, Supplier<Integer> input) {
            this.index = index;
            this.input = input;
        }

        public String toString() {
            return index + " : " + input.get();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DelayedData[] data = new DelayedData[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = new DelayedData(i, () -> sc.nextInt()); // index = i, input = lambda function () -> sc.nextInt()
            System.out.println("i is " + i);
        }

        Stream.of(data).filter(x -> x.index % 2 == 0).forEach(System.out::println);
        // Filter all the data with
        // even-number index. Then print
        // every index-input dataset.

        // Notice that DelayedData and filter are lazy-implemented which means that the
        // integer input is only requested right before the printing of each filtered
        // dataset.
        // in the forloop, giving the input of () -> sc.nextInt() does not immediately
        // call the scanner.
        // it only assigns the input Supplier<Integer> to a lambda function for later
        // use.

    }
}
