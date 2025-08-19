package datastructures.queue;

public class EmptyQueueException extends RuntimeException {
    // Constructor CON mensaje personalizado
    public EmptyQueueException(String message) {
        super(message); // Usa el mensaje que le pases
    }
}
