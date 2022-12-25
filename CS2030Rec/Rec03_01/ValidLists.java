/*
     * Given S is a subclass of T (S inherits T), S <: T --> S is a sub-type of T
     * --> COVARIANT: S[] <: T[]
     * Shape[] shapes = new Circle[10];
     * --> COVARIANT: S<E> <: T<E>
     * List<Point> PointList = new ArrayList<Point>(10);
     * --> INVARIANT: C<S> and C<T>
     * ERROR: ArrayList<Shape> shapes = new ArrayList<Circle>(10);
     */

/* Learning Point: For List<? [+ Restrictions]> list = new SomeList<Y>();
 * Points required for Compilation: 
 * 1. If there are restrictions behind the wildcard ? in List<>, Y must fulfill these restrictions.
 * e.g. List<? super Integer> --> Y must be Integer or a supertype of Integer
 * 2. SomeList must be a class implementing java's List interface. SomeList cannot be List itself.
 * e.g. List NOT OK [List is an interface]  LinkedList or ArrayList OK.
 * 3. Y must be a Reference type, e.g. Integer not int.
 */

package CS2030Rec.Rec03_01;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ValidLists {
    public static void main(String[] args) {
        // Part A
        List<?> list1 = new ArrayList<String>();
        // My guess: COMPILES because ArrayList <: List [ArrayList is a subtype of List]
        // The ? wildcard can accept any type. Instead, 

        // List<Object> list1b = new ArrayList<String>(); // Returns an error

        // Part B
        List<? super Integer> list2 = new List<Object>();
        // My guess: COMPILES because Object is a supertype of Integer
        // Answer: CANNOT COMPILE because *** List is an Interface --> Interfaces have NO CONSTRUCTOR i.e. cannot create an instance of an interface ***

        // If the wildcard ? is not used, INVARIANCE between C<S> and C<T> will cause ERROR
        // ArrayList<Object> list2b = new ArrayList<Integer>(); // Error.

        // Part C
        List<? extends Object> list3 = new LinkedList<Object>();
        // My guess: COMPILES because LinkedList is a valid class which implements List. 
        // Besides, For List<? extends Object>, the type of LinkedList must be Object or a subtype of Object.
        // Answer: COMPILES

        // Part D
        List<? super Integer> list4 = new LinkedList<int>();
        // My guess: CANNOT COMPILE because int is a primitive type. ONLY REFERENCE TYPES like Integer are accepted.
        // Answer: CANNOT COMPILE

        // PartE
        List<? super Integer> list5 = new LinkedList();
        // My guess: new LinkedList() returns an error. There must be indication of the type of LinkedList. new LinkedList<Type Y>();
        // Answer: COMPILES. However it gives a Type Safety warning.
    }
}
