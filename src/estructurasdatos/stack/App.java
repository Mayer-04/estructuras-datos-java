package estructurasdatos.stack;

public class App {

    public static void main(String[] args) {
        // GenericResizingStack<Integer> stack1 = new GenericResizingStack<>();
        // FixedCapacityStackOfStrings stack2 = new FixedCapacityStackOfStrings(3);

        var stack1 = new GenericResizingStack<Integer>();
        var stack2 = new FixedCapacityStackOfStrings(3);

        stack1.push(10);
        stack1.push(20);
        System.out.println(stack1);

        stack2.push("Hola");
        stack2.push("Mundo");
        System.out.println(stack2);
    }
}
