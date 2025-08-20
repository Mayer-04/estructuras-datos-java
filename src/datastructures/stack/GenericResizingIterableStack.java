package datastructures.stack;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class GenericResizingIterableStack<T> implements Iterable<T> {
    private T[] elements;
    private int count;

    public GenericResizingIterableStack() {
        elements = (T[]) new Object[1];
        count = 0;
    }

    public void push(T item) {
        if (count == elements.length) {
            resize(2 * elements.length);
        }
        elements[count] = item;
        count++;
    }

    public T pop() {
        T item = elements[--count];

        elements[count] = null;
        if (count > 0 && count == elements.length / 4) {
            resize(elements.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public T peak() {
        return elements[count - 1];
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < count; i++) {
            newArray[i] = elements[i];
        }
        elements = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int index = count - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public T next() {
            return elements[index--];
        }
    }
}
