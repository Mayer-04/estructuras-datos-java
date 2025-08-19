package datastructures.dequeue;

public class Dequeue<T> {

    private final T[] elements;
    private final int front;
    private final int rear;
    private final int size;

    public Dequeue() {
        elements = (T[]) new Object[1];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void addFirst(T element) {

    }

    public void addLast(T element) {

    }

    public T removeFirst() {
        return null;
    }

    public T removeLast() {
        return null;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }
}
