package datastructures.queue;

public class Main {

    public static void main(String[] args) {
        var queue = new Queue<String>();

        queue.enqueue("Mayer");
        queue.enqueue("Jose");
        queue.enqueue("Juan");
        queue.enqueue("Johan");

        System.out.println(queue); // Output: queue: ["Mayer", "Jose", "Juan", "Johan"]
        System.out.println(queue.size()); // Output: 4

        System.out.println(queue.dequeue()); // Output: Mayer
        System.out.println(queue.dequeue()); // Output: Jose

        System.out.println(queue); // Output: queue: ["Juan", "Johan"]
        System.out.println(queue.size()); // Output: 2

        System.out.println(queue.peek()); // Output: Juan

        queue.clear();

        System.out.println(queue); // Output: []
        System.out.println(queue.isEmpty()); // Output: true

        try {
            var firstElement = queue.dequeue();
            System.out.println("primer elemento: " + firstElement);
        } catch (EmptyQueueException e) {
            System.err.println(e.getMessage());
        }
    }
}
