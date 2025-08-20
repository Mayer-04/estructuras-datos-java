package datastructures.stack;

@SuppressWarnings("unchecked")
public class GenericResizingStack<T> {

    private T[] elements;
    private int count;

    public GenericResizingStack() {
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
    public String toString() {
        StringBuilder salida = new StringBuilder("[");
        for (int i = count - 1; i > 0; i--) {
            T element = elements[i];

            if (element instanceof String s) {
                salida.append('"').append(s).append('"');
            } else {
                salida.append(element);
            }

            if (i < count - 1) {
                salida.append(", ");
            }
        }
        salida.append("]");
        return "genericStack: " + salida;
    }
}
