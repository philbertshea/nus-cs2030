package CS2030;

public class Lec5Slide17 {
    static Integer maxOfThree(Integer[] numbers) {
        if (numbers.length != 3) {
            System.out.println("Invalid use of maxOfThree");
            return null;
        }

        Integer max = numbers[0];
        if (numbers[1] > max) {
            max = numbers[1];
        }
        if (numbers[2] > max) {
            max = numbers[2];
        }

        return max;
    }

    public static <T extends Comparable<T>> T genericMaxOfThree(T[] numbers) {
        T max = numbers[0];

        if (numbers[1].compareTo(max) > 0) {
            max = numbers[1];
        }
        if (numbers[2].compareTo(max) > 0) {
            max = numbers[2];
        }

        return max;
    }

    public static void main(String[] args) {
        Integer[] intList = { 19, 28, 37 };
        Double[] doubleList = { 19.5, 937.3, 53.2 };
        String[] strList = { "Hello", "Hey There", "How" }; // By alphabetical order, not length of string
        System.out.println("----- Integer maxOfThree (Integer[]) -----");
        System.out.println(maxOfThree(intList));
        System.out.println("----- Generic genericMaxOfThree (Generic[]) -----");
        System.out.println("Integer: " + genericMaxOfThree(intList));
        System.out.println("Double: " + genericMaxOfThree(doubleList));
        System.out.println("String: " + genericMaxOfThree(strList));

    }

}
