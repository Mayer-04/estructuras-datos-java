package projects.infix.postfix;

import datastructures.queue.Queue;
import datastructures.stack.Stack;

public class InfixToPostfix {

    private final Queue<String> queueEntry;
    private final Queue<String> queueExit;
    private final Stack<String> stack;

    public InfixToPostfix(Queue<String> queueEntry, Queue<String> queueExit) {
        this.queueEntry = queueEntry;
        this.queueExit = queueExit;
        this.stack = new Stack<>();
    }

    /**
     * Devuelve la precedencia de un operador aritmético.
     * Un número mayor indica mayor precedencia.
     * <ul>
     *     <li>{@code +, -} → precedencia 1</li>
     *     <li>{@code *, /, %} → precedencia 2</li>
     *     <li>Otros operadores → precedencia 0</li>
     * </ul>
     *
     * @param operator el operador a evaluar
     * @return un número entero que representa la precedencia del operador
     */
    private static int getPrecedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/", "%" -> 2;
            default -> 0;
        };
    }

    /**
     * Convierte la expresión en notación infija (almacenada en {@code queueEntry})
     * a notación postfija (almacenada en {@code queueExit}).
     * <p>
     * Este método procesa cada token de la expresión:
     * <ul>
     *     <li>Si el token es un número, se envía directamente a la pila de salida.</li>
     *     <li>Si el token es un operador, se maneja según su precedencia
     *     en comparación con los operadores en la pila.</li>
     * </ul>
     * </p>
     */
    public void convertInfixToPostfix() {
        while (!queueEntry.isEmpty()) {
            String token = queueEntry.dequeue();

            // Si el token es un número (según la expresión regular),
            // se envía directamente a la cola de salida.
            if (token.matches("\\d+")) {
                queueExit.enqueue(token);
            } else {
                // Mientras haya operadores con mayor o igual precedencia
                while (!stack.isEmpty() && getPrecedence(token) <= getPrecedence(stack.peek())) {
                    queueExit.enqueue(stack.pop());
                }
                stack.push(token);
            }
        }

        // Vaciar la pila de operadores
        while (!stack.isEmpty()) {
            queueExit.enqueue(stack.pop());
        }
    }
}
