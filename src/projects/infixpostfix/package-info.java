/**
 * Proporciona clases para la conversión y evaluación de expresiones
 * matemáticas en notación infija y postfija.
 *
 * <p>
 * Este paquete incluye dos componentes principales:
 * </p>
 *
 * <ul>
 *   <li>{@link projects.infixpostfix.InfixToPostfix}:
 *   Convierte una expresión en notación infija (ej. {@code 3 + 4 * 2})
 *   a notación postfija (ej. {@code 3 4 2 * +}).</li>
 *
 *   <li>{@link projects.infixpostfix.PostfixEvaluator}:
 *   Evalúa una expresión en notación postfija y devuelve el resultado numérico.</li>
 * </ul>
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
 * // Conversión a postfijo
 * InfixToPostfix converter = new InfixToPostfix(entrada, salida);
 * converter.convertInfixToPostfix();
 *
 * // Evaluación del postfijo
 * PostfixEvaluator evaluator = new PostfixEvaluator(salida);
 * int resultado = evaluator.evaluate();
 *
 * System.out.println(resultado); // 11
 * }</pre>
 *
 * <p>
 * La clase {@code Main} demuestra un ejemplo práctico del flujo completo del código.
 * </p>
 */

package projects.infixpostfix;
