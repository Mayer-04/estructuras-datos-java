package projects.infixpostfix;

import datastructures.queue.Queue;
import datastructures.stack.Stack;

/**
 * Evalúa expresiones matemáticas en notación postfija.
 * <p>
 * Usa una {@link Queue} que contiene la expresión postfija como entrada
 * y una {@link Stack} de enteros para realizar los cálculos paso a paso.
 * </p>
 *
 * <h2>Ejemplo de uso</h2>
 * <pre>{@code
 * Queue<String> salida = new Queue<>();
 * salida.enqueue("3");
 * salida.enqueue("4");
 * salida.enqueue("2");
 * salida.enqueue("*");
 * salida.enqueue("+");
 *
 * PostfixEvaluator evaluator = new PostfixEvaluator(salida);
 * int resultado = evaluator.evaluate();
 *
 * System.out.println(resultado); // 11
 * }</pre>
 */
public class PostfixEvaluator {

    private final Queue<String> queueExit;
    private final Stack<Integer> resultStack;

    /**
     * Crea un evaluador para una expresión postfija.
     *
     * @param queueExit la cola que contiene los tokens en notación postfija
     */
    public PostfixEvaluator(Queue<String> queueExit) {
        this.queueExit = queueExit;
        this.resultStack = new Stack<>();
    }

    /**
     * Evalúa la expresión matemática en notación postfija contenida en {@code queueExit}.
     * <p>
     * El algoritmo recorre cada token de la cola:
     * <ul>
     *   <li>Si el token es un número, se apila en la {@code resultStack}.</li>
     *   <li>Si el token es un operador ({@code +, -, *, /, %}), se desapilan
     *   dos operandos, se aplica la operación y se apila el resultado.</li>
     * </ul>
     * </p>
     *
     * @return el resultado entero de la evaluación
     * @throws IllegalArgumentException si se encuentra un operador no válido
     */
    public int evaluate() {
        while (!queueExit.isEmpty()) {

            String token = queueExit.dequeue();

            if (token.matches("\\d+")) {
                resultStack.push(Integer.parseInt(token));
            } else {

                int rightOperand = resultStack.pop();
                int leftOperand = resultStack.pop();

                int result = switch (token) {
                    case "+" -> leftOperand + rightOperand;
                    case "-" -> leftOperand - rightOperand;
                    case "*" -> leftOperand * rightOperand;
                    case "/" -> leftOperand / rightOperand;
                    case "%" -> leftOperand % rightOperand;
                    default -> throw new IllegalArgumentException("Invalid operator: " + token);
                };

                resultStack.push(result);
            }
        }

        return resultStack.pop();
    }
}
