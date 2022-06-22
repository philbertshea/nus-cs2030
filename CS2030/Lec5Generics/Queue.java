
package CS2030.Lec5Generics;

// Queue is a generic class which takes in a type parameter T (conventionally, T is used)
public class Queue<T> {
    private Object[] elements;  // Cannot create a generic array T[]
    private int front;
    private int back;

    public Queue(int size) {
        elements = new Object[size + 1];
        front = 0;
        back = 0;
    }

    public int numofObjects() {
        return back - front;
    }

    public boolean isFull() {
        return numofObjects() == elements.length - 1;
    }

    public boolean isEmpty() {
        return numofObjects() == 0;
    }

    public int nextIndex(int currentIndex) {
        return (currentIndex + 1) % elements.length;
    }

    public void add(T element) {
        if (!isFull()) {
            elements[back] = element;
            back = nextIndex(back);
        } else {
            throw new IllegalStateException();
        }

    }

    public T remove() {
        Object element = null;
        if (!isEmpty()) {
            element = elements[front];
            elements[front] = null;
            front = nextIndex(front);
        }
        @SuppressWarnings("unchecked")
        T elem = (T) element;
        return elem;

    }
}
