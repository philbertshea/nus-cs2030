// Problems with the use of Object instead of Generics
// Implement constructor, numofObjects, isFull, isEmpty, nextIndex, add, remove
package CS2030.Lec5Generics;

public class ObjectQueue {
    private Object[] objects;
    private int front;
    private int back;

    public ObjectQueue(int size) {
        objects = new Object[size + 1];
        front = 0;
        back = 0;
    }

    public int numofObjects() {
        return back - front;
    }

    public boolean isFull() {
        return numofObjects() == objects.length - 1;
    }

    public boolean isEmpty() {
        return numofObjects() == 0;
    }

    public int nextIndex(int currentIndex) {
        return (currentIndex + 1) % objects.length;
    }

    public void add(Object object) {
        if (!isFull()) {
            objects[back] = object;
            back = nextIndex(back);
        } else {
            throw new IllegalStateException();
        }
        
    }

    public Object remove() {
        Object object = null;
        if (!isEmpty()) {
            object = objects[front];
            objects[front] = null;
            front = nextIndex(front);
        }
        return object;
        
    }
}
