package estructurasdatos.queue;

public class Queue {
    private final String[] elementos;
    private final int contador;

    public Queue(int capacidad) {
        elementos = new String[capacidad];
        contador = 0;
    }

}
