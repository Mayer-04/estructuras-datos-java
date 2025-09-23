package datastructures.stack;

public class Main {
    void main() {
        var stack = new Stack<String>();

        stack.push("Mayer");
        stack.push("Andres");
        stack.push("Chaves");

        IO.println(stack);
        IO.println("Elemento eliminado: " + stack.pop());

        System.out.printf("Nueva pila: %s\n", stack);
    }
}
