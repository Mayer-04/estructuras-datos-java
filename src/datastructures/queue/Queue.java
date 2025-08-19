package datastructures.queue;

// FIFO (First in, First Out)
@SuppressWarnings("unchecked")
public class Queue<T> {
    private T[] elements;
    private int count;

    public Queue() {
        elements = (T[]) new Object[1];
        count = 0;
    }

    public void enqueue(T item) {
        if (count == elements.length) {
            resize(elements.length * 2);
        }
        elements[count] = item;
        count++;
    }

    /**
     * Elimina y devuelve el elemento al frente de la cola.
     * Todos los elementos restantes se desplazan una posición hacia la izquierda
     * para mantener la estructura de la cola.
     *
     * @return el elemento que estaba al frente de la cola.
     * @throws EmptyQueueException si la cola está vacía.
     * @see #isEmpty()
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException("The queue is empty");
        }

        var item = elements[0];

        for (int i = 1; i < count; i++) {
            elements[i - 1] = elements[i];
        }

        elements[count - 1] = null;

        count--;

        return item;
    }

    public T dequeueTwo() {
        var item = elements[0];

        for (int i = 0; i < count - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[count - 1] = null;

        count--;

        return item;
    }

    /**
     * Devuelve el elemento al frente de la cola sin eliminarlo.
     *
     * @return el elemento al frente de la cola
     * @throws EmptyQueueException si la cola está vacía
     * @see #isEmpty()
     */
    public T peek() {
        if (isEmpty()) {
            throw new EmptyQueueException("The queue is empty");
        }
        return elements[0];
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
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
        return "queue: " + output;
    }
}
