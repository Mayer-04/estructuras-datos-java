package datastructures.bag;

@SuppressWarnings("unchecked")
public class Bag<T> {

    private T[] elements;
    private int count;

    public Bag() {
        elements = (T[]) new Object[1];
        count = 0;
    }

    public void add(T item) {
        // Objects.requireNonNull(item, "El elemento no puede ser nulo");

        if (item == null) {
            throw new NullPointerException("El elemento no puede ser nulo");
        }

        if (count == elements.length) {
            resize(elements.length * 2);
        }

        elements[count] = item;
        count++;
    }

    public boolean contains(T item) {
        for (T element : elements) {
            if (element != null && element.equals(item)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void clear() {
        // elements = new String[elements.length];
        for (int i = 0; i < size(); i++) {
            elements[i] = null;
        }
        count = 0;
    }

    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];

        for (int i = 0; i < count; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;
    }

    public String toString() {
        StringBuilder output = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            T element = elements[i];
            if (element instanceof String s) {
                output.append('"').append(s).append('"');
            } else {
                output.append(element);
            }

            if (i < count - 1) {
                output.append(", ");
            }
        }
        output.append("]");
        return "bag: " + output;
    }
}
