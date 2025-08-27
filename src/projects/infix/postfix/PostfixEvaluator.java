package projects.infix.postfix;

import datastructures.queue.Queue;
import datastructures.stack.Stack;

public class PostfixEvaluator {

    private final Queue<String> queueExit;
    private final Stack<Integer> resultStack;

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
                // Si es un número, se apila directamente
                resultStack.push(Integer.parseInt(token));
            } else {
                // Operador: desapilar dos operandos
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
