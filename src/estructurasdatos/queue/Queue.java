package estructurasdatos.queue;

public class Queue {
    private String[] elementos;
    private int contador;

    public Queue(int capacidad) {
        elementos = new String[capacidad];
        contador = 0;
    }

}
