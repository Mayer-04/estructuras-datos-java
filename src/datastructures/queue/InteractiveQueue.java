package datastructures.queue;

import java.util.Scanner;

public record QueueHandler(Queue<String> queue, Scanner scanner) {

    public void enqueue() {
        System.out.print("Ingrese un elemento: ");
        String element = scanner.nextLine();

        if (element == null || element.trim().isEmpty()) {
            System.out.println("El elemento no puede estar vacío");
        } else {
            queue.enqueue(element);
            System.out.println("✅ Elemento agregado: " + element);
        }
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            String removed = queue.dequeue();
            System.out.println("🗑️ Elemento eliminado: " + removed);
        } else {
            System.out.println("⚠️ La cola está vacía.");
        }
    }

    public void ShowElements() {
        if (queue.isEmpty()) {
            System.out.println("📭 La cola está vacía.");
            return;
        }

        System.out.println("📋 Elementos en la cola:");
        int index = 1;
        for (String element : queue) {
            System.out.println(index + ". " + element);
            index++;
        }
    }

    public void Exit() {
        System.out.println("👋 Saliendo del programa...");
    }
}
