
package CS2030.Lec5Generics;

import java.util.ArrayList;

// Queue2 is a generic class which takes in a type parameter T (conventionally, T is used)
public class Queue2<T> {
    private ArrayList<T> elements; 
    // Here, we use an arraylist, a Java collection which has a set of built-in methods for accessing and editing the list
    // The arraylist takes in instances of type T
    private int maxObjects;

    public Queue2(int size) {
        elements = new ArrayList<>();
        maxObjects = size;
    }

    public boolean isFull() {
        return maxObjects == elements.size();  // elements.size() gives the current number of elements in the ArrayList
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void add(T element) {
        if (!isFull()) {
            elements.add(element);  // elements.add(element) adds the element to the back of the arraylist
        } else {
            throw new IllegalStateException();
        }

    }

    public T remove() {
        if (!isEmpty()) {
            return elements.remove(0);  // elements.remove(index) removes element of XX index and returns removed element
        }
        return null; // return null if isEmpty
    }
}
