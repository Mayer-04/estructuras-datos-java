package datastructures.list;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int count;

    public getPreviousNode(Node nodo) {
        final Node predecesor = nodo.prev;
        final Node newNode = new Node();
        nodo.prev = newNode;
        if (predecesor == null)
            first = newNode;
        else
            predecesor.next = newNode;
    }

    public void add(T item, int index) {
        final Node predecesor
        if (index == count) {
            addLast(item);
        } else if (index == 0) {
            addFirst(item);
        } else {

        }
    }

    public void addFirst(T item) {
        Node newNode = new Node();
        newNode.item = item; // asignar el valor

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        count++;
    }

    public void addLast(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        oldLast.next = last;
        count++;
    }

    public void clear() {
        first = null;
        last = null;
        count = 0;
    }

    public boolean contains(T item) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T get() {

    }

    public T getFirst() {
        return first.item;
    }

    public T getLast() {
        return last.item;
    }

    public boolean isEmpty() {
        return count == 0;
        //return first == null;
    }

    public boolean remove() {

    }

    public T removeFirst() {
        T item = first.item;
        first = first.next;
        count--;
        return item;
    }

    public T removeLast() {
        T item = last.item;
        last = last.prev;
        count--;
        return item;
    }

    public int size() {
        return count;
    }

    public boolean equals() {

    }

    public int indexOf() {

    }

    public void set() {

    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class Node {
        T item;
        Node next;
        Node prev;
    }

    private class DoubleLinkedListIterator implements Iterator<T> {
        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
