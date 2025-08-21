package datastructures.linkedlist;

class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
}

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T element) {

    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T element) {

    }

    public void insert(int index, T element) {

    }

    public void remove(T element) {

    }

    public void removeAt(T index) {

    }

    public void removeFirst() {

    }

    public void removeLast() {

    }

    public void clear() {

    }

    public T get(int index) {
        return null;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public int size() {
        return 0;
    }

    public boolean contains(T element) {
        return false;
    }

    public T indexOf(T element) {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public T[] toArray() {
        return null;
    }
}
