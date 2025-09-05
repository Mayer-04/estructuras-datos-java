package projects.infixpostfix;

import datastructures.queue.Queue;
import datastructures.stack.Stack;

/**
 * Convierte una expresión en notación infija a notación postfija
 * utilizando el algoritmo de Shunting Yard de Dijkstra.
 * <p>
 * Usa una {@link Queue} como entrada (tokens en notación infija),
 * una {@link Queue} como salida (tokens en notación postfija)
 * y una {@link Stack} para manejar los operadores según su precedencia.
 * </p>
 *
 * <h2>Ejemplo de uso</h2>
 * <pre>{@code
 * Queue<String> entrada = new Queue<>();
 * Queue<String> salida = new Queue<>();
 *
 * // Expresión: 3 + 4 * 2
 * entrada.enqueue("3");
 * entrada.enqueue("+");
 * entrada.enqueue("4");
 * entrada.enqueue("*");
 * entrada.enqueue("2");
 *
 * InfixToPostfix converter = new InfixToPostfix(entrada, salida);
 * converter.convertInfixToPostfix();
 *
 * System.out.println(salida); // [3, 4, 2, *, +]
 * }</pre>
 */
public class InfixToPostfix {

    private final Queue<String> queueEntry;
    private final Queue<String> queueExit;
    private final Stack<String> stack;

    /**
     * Crea un nuevo conversor de notación infija a postfija.
     *
     * @param queueEntry la cola de entrada con los tokens en notación infija
     * @param queueExit  la cola de salida donde se almacenará la notación postfija
     */
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

            if (token.matches("\\d+")) {
                queueExit.enqueue(token);
            } else {

                while (!stack.isEmpty() && getPrecedence(token) <= getPrecedence(stack.peek())) {
                    queueExit.enqueue(stack.pop());
                }

                stack.push(token);
            }
        }


        while (!stack.isEmpty()) {
            queueExit.enqueue(stack.pop());
        }
    }
}
