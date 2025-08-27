package projects.infix.postfix;

import datastructures.queue.Queue;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var queueEntry = new Queue<String>();
        var queueExit = new Queue<String>();
        var scanner = new Scanner(System.in);

        System.out.print("Ingrese la operación con espacios entre operandos y operadores:");
        var expression = scanner.nextLine();

        String[] separateString = expression.split(" ");
        for (String dato : separateString) {
            queueEntry.enqueue(dato);
        }

        var infixToPostfix = new InfixToPostfix(queueEntry, queueExit);
        infixToPostfix.convertInfixToPostfix();

        var postfixEvaluator = new PostfixEvaluator(queueExit);
        System.out.println("Resultado final: " + postfixEvaluator.evaluate());
    }
}