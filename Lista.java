package listas;

public class Lista {

    private String a[];
    private int contador;

    public Lista(int capacidad) {
        a = new String[capacidad];
        contador = 0;
    }

    // Insertar una cadena en una posición dada.
    public void adicionar(int indice, String cadena) {

    }

    // Inserta una cadena al inicio de la lista.
    public void adicionarInicio(String cadena) {
        // adicionar(0, cadena);
    }

    // Inserta una cadena al final de la lista.
    public void adicionarFinal(String cadena) {
        // adicionar(contador, cadena);
    }

    // Vaciar o limpiar todos los elementos de la lista.
    public void vaciar() {
        // a = new String[a.length];
        // contador = 0;
    }

    // Contiene devuelve verdadero si tenemos una cadena dada.
    public boolean contiene(String Ccadena) {
        return false;
    }

    // Obtiene la cadena según su posición (índice) en la lista.
    public String obtener(int indice) {
        return "";
    }

    // Obtiene la primera cadena de la lista.
    public String obtenerPrimero() {
        // return obtener(0);
        return null;
    }

    // Obtiene la última cadena de la lista.
    public String obtenerUltimo() {
        // return obtener(contador - 1);
        return null;
    }

    // Busca una cadena en la lista, devuelve la posición de la cadena o -1 si no la
    // encuentra.
    public int buscar(String cadena) {
        return 0;
    }

    // Devuelve verdadero si la lista esta vacía.
    public boolean estaVacia(String cadena) {
        // return contador == 0;
        return false;
    }

    // Remueve y devuelve la cadena de la posición índice.
    // Verificar que esa posición índice exista.
    public String remover(int indice) {
        return "";
    }

    // Remueve y devuelve la cadena especificada.
    public boolean remover(String cadena) {
        return false;
    }

    // Remueve la primera cadena de la lista y la devuelve.
    public String removerPrimero() {
        // return remover(0);
        return "";
    }

    // Remueve la última cadena de la lista y la devuelve.
    public String removerUltimo() {
        // return remover(contador-1);
        return "";
    }

    // Remueve de la lista y retorna en una nueva lista todas las cadenas de las posiciones
    // que están entre inicio (inclusive) y fin (exclusive)
    public Lista removerIntervalo(int inicio, int fin) {
        return null;
    }

    // Modifica la cadena de la posición índice de la lista.
    public void modificar(int indice, String cadena) {

    }

    // Devuelve el número de elementos en la lista.
    public int tamaño() {
        // contador;
        return 0;
    }

    // Retorna una cadena con todas las cadenas de la lista.
    @Override
    public String toString() {
        return "";
    }
}
