// The sort method from List<E> is a default method, meaning *there is already an existing implementation from the interface. No need to re-implement it in class*
package CS2030;

import java.util.ArrayList;
import java.util.Comparator;

class Student {
    int regNo;
    String name, address;

    public Student(int regNo, String name, String address) {
        this.regNo = regNo;
        this.name = name;
        this.address = address;
    }

    // toString is a Java keyword. When the object is printed, whatever is returned
    // from toString() will be printed
    public String toString() {
        return " Student " + name + " (# " + regNo + " ) living in " + address;
    }
}

class Sortbyregno implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.regNo - o2.regNo;
    }

}

class Sortbyname implements Comparator<Student> {
    // Consider the possibility of same names. However, register number is unique.
    // Therefore, for people of the same name, order by ascending regNo.
    public int compare(Student o1, Student o2) {
        int nameDiff = o1.name.compareTo(o2.name);
        int regnoDiff = o1.regNo - o2.regNo;
        return (nameDiff == 0) ? regnoDiff : nameDiff;
        // if o1.name is alphabetically after o2.name, returns +1
        // if o1.name is equal/equals to o2.name, return 0
        // if o2.name is alphabetically after o1.name, returns -1
    }
}

public class Lec5Slide18_24 {
    // Comparator<?> is a comparison interface with useful methods like compare,.
    // E.g. sort(Comparator<? super E> c): sort takes in an object c with a generic
    // functional interface.

    public static void main(String[] args) {
        ArrayList<Student> li = new ArrayList<Student>();
        // Note that ArrayList implements List<E> so it has some built-in methods.
        li.add(new Student(10, "John", "Hong Kong"));
        li.add(new Student(5, "Larry", "USA"));
        li.add(new Student(20, "Anna", "Malaysia"));
        li.add(new Student(30, "Zenith", "South Africa"));
        li.add(new Student(25, "Anna", "Indonesia"));
        li.add(new Student(18, "John", "South Africa"));

        System.out.println("--- Unsorted (Based on order of addition to list) ---");
        for (Student student : li) {
            System.out.println(student);
        }

        li.sort(new Sortbyregno());
        // Sort method is implemented in List<E>. Sort takes in a Comparator which has
        // compare method defined. Based on what compare method (from comparator)
        // returns, the sort method sorts the elements in ascending order (e.g. if
        // compare(A,B) returns +1, B is before A.)

        System.out.println("--- Sorted by order of ascending register number ---");
        for (Student student : li) {
            System.out.println(student);
        }

        li.sort(new Sortbyname());

        System.out.println("--- Sorted by order of ascending name ---");
        for (Student student : li) {
            System.out.println(student);
        }

        // If the Comparator will only be called once, there is no need to create an
        // extra class. Just define the implementation within the Comparator in sort.
        li.sort(new Comparator<Student>() { // Anonymous Inner class

            @Override
            public int compare(Student o1, Student o2) {
                int addressDiff = o1.address.compareTo(o2.address);
                int regNoDiff = o1.regNo - o2.regNo;
                return (addressDiff == 0) ? regNoDiff : addressDiff;
            }
        });

        System.out.println("--- Sorted by order of ascending address ---");
        for (Student student : li) {
            System.out.println(student);
        }

    }
}
