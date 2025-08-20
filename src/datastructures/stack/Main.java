package datastructures.stack;

public class Main {

    public static void main(String[] args) {
        /**
         * GenericResizingStack<Integer> stack1 = new GenericResizingStack<>();
         * GenericResizingStack<Integer> stack1 = new GenericResizingStack<>();
         */

        var genericStack = new GenericResizingStack<Integer>();
        var stack2 = new FixedCapacityStackOfStrings(3);

        genericStack.push(10);
        genericStack.push(20);
        System.out.println(genericStack);

        stack2.push("Hola");
        stack2.push("Mundo");
        System.out.println(stack2);
    }
}
