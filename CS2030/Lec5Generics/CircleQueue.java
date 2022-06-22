// Problems with the use of Object instead of Generics
// Implement constructor, numOfCircles, isFull, isEmpty, nextIndex, add, remove
package CS2030.Lec5Generics;

import CS2030.Lec5Generics.Geometry.*;

public class CircleQueue {
    private Circle[] circles;
    private int front;
    private int back;

    public CircleQueue(int size) {
        circles = new Circle[size + 1];
        front = 0;
        back = 0;
    }

    public int numOfCircles() {
        return back - front;
    }

    public boolean isFull() {
        return numOfCircles() == circles.length - 1;
    }

    public boolean isEmpty() {
        return numOfCircles() == 0;
    }

    public int nextIndex(int currentIndex) {
        return (currentIndex + 1) % circles.length;
    }

    public void add(Circle circle) {
        if (!isFull()) {
            circles[back] = circle;
            back = nextIndex(back);
        } else {
            throw new IllegalStateException();
        }
        
    }

    public Circle remove() {
        Circle circle = null;
        if (!isEmpty()) {
            circle = circles[front];
            circles[front] = null;
            front = nextIndex(front);
        }
        return circle;
        
    }
}
