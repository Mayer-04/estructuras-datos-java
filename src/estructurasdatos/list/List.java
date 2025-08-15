package estructurasdatos.list;

public class List {

    private String[] elementos;
    private int contador;

    public List(int capacidad) {
        elementos = new String[capacidad];
        contador = 0;
    }

    /**
     * Agrega un elemento en una posición indicada.
     *
     * @param indice El índice donde se insertará el elemento.
     * @param elemento El elemento a insertar.
     * @throws IndexOutOfBoundsException Si el índice es negativo o mayor que el
     * tamaño actual de la lista.
     * @throws NullPointerException Si el elemento a insertar es nulo.
     */
    public void adicionar(int indice, String elemento) {
        Validations.indiceInsercion(indice, contador);
        Validations.elementoNoNulo(elemento);

        // Eliminamos los espacios en blanco del principio y del final
        // al agregar un elemento
        elementos[indice] = elemento.trim();
        // Aumenta el contador en 1 cada vez que se agrega un elemento
        contador++;
    }

    /**
     * Agrega un elemento al inicio de la lista.
     * <p>
     * El elemento no puede ser nulo; se lanza
     * <strong>NullPointerException</strong> si lo es.
     * </p>
     *
     * @param elemento El elemento a insertar.
     * @throws NullPointerException Si el elemento es nulo.
     */
    public void adicionarInicio(String elemento) {
        adicionar(0, elemento);
    }

    /**
     * Agrega un elemento al final de la lista.
     * <p>
     * El elemento no puede ser nulo; se lanza NullPointerException si lo es.
     * </p>
     *
     * @param elemento El elemento a insertar.
     * @throws NullPointerException Si el elemento es nulo.
     */
    public void adicionarFinal(String elemento) {
        adicionar(contador, elemento);
    }

    /**
     * Elimina todos los elementos de la lista.
     */
    public void vaciar() {
        elementos = new String[elementos.length];
        contador = 0;
    }

    /**
     * Verifica si la lista contiene un elemento.
     *
     * @param elemento El elemento a buscar.
     * @return true si el elemento se encuentra en la lista, false si no.
     * @throws NullPointerException Si el elemento es nulo.
     */
    public boolean contiene(String elemento) {
        Validations.elementoNoNulo(elemento);
        for (String valor : elementos) {
            if (valor != null && valor.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene el elemento de la lista en la posición indicada.
     *
     * @param indice El índice del elemento a obtener.
     * @return El elemento en la posición indicada.
     * @throws IndexOutOfBoundsException Si el índice es negativo o mayor o
     * igual al tamaño actual de la lista.
     * @throws NullPointerException Si el elemento en la posición indicada es
     * nulo.
     */
    public String obtener(int indice) {
        Validations.indiceAcceso(indice, contador);

        if (elementos[indice] == null) {
            throw new NullPointerException("El elemento en el índice " + indice + " es nulo");
        }

        return elementos[indice];
    }

    /**
     * Obtiene el primer elemento de la lista.
     *
     * @return El primer elemento de la lista.
     */
    public String obtenerPrimero() {
        return obtener(0);
    }

    /**
     * Obtiene el último elemento de la lista.
     *
     * @return El último elemento de la lista.
     */
    public String obtenerUltimo() {
        return obtener(contador - 1);
    }

    /**
     * Busca el elemento en la lista y devuelve su posición.
     *
     * @param elemento El elemento a buscar.
     * @return La posición del elemento si lo encuentra, -1 si no lo encuentra.
     */
    public int buscar(String elemento) {
        for (int i = 0; i < contador; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false si contiene al
     * menos uno.
     */
    public boolean estaVacia() {
        return contador == 0;
    }

    /**
     * Remueve y devuelve el elemento de la posición indicada.
     *
     * @param indice El índice del elemento a remover.
     * @return El elemento que fue removido.
     * @throws IndexOutOfBoundsException Si el índice es negativo o mayor o
     * igual al tamaño de la lista.
     */
    public String remover(int indice) {
        // 1. Validamos que el índice sea mayor que 0 y menor al tamaño del arreglo
        Validations.indiceAcceso(indice, contador);

        // 2. Guardamos en esta variable el elemento que sera removida del arreglo
        String elemento = elementos[indice];

        // 3. Definimos el nuevo tamaño del arreglo
        String[] nuevoArreglo = new String[contador - 1];
        int nuevoIndice = 0;

        for (int i = 0; i < contador; i++) {
            if (i != indice) {
                nuevoArreglo[nuevoIndice] = elementos[i];
                nuevoIndice++;
            }
        }

        // 3. Disminuimos el valor del contador en 1
        contador--;

        // 4. Actualizamos la referencia al nuevo arreglo que creamos
        elementos = nuevoArreglo;

        // 5. Devolvemos el elemento eliminado
        return elemento;
    }

    /**
     * Remueve un elemento específico de la lista.
     *
     * @param elemento El elemento a remover.
     * @return true si el elemento fue removido, false si no se encontró.
     * @throws NullPointerException Si el elemento es nulo.
     */
    public boolean remover(String elemento) {
        Validations.elementoNoNulo(elemento);

        int indice = buscar(elemento);
        if (indice != -1) {
            remover(indice);
            return true;
        }
        return false;
    }

    // public boolean remover(String cadena) {
    // if (cadena == null) {
    // throw new IllegalArgumentException("El elemento a eliminar no debe ser
    // nulo");
    // }
    // for (int i = 0; i < contador; i++) {
    // if (elementos[i].equals(cadena)) {
    // for (int j = i; j < contador - 1; j++) {
    // elementos[j] = elementos[j + 1];
    // }
    // elementos[contador - 1] = null;
    // contador--;
    // return true;
    // }
    // }
    // return false;
    // }

    /**
     * Remueve el primer elemento de la lista y lo devuelve.
     *
     * @return El elemento removido.
     */
    public String removerPrimero() {
        return remover(0);
    }

    /**
     * Remueve el último elemento de la lista y lo devuelve.
     *
     * @return El elemento removido.
     */
    public String removerUltimo() {
        return remover(contador - 1);
    }

    /**
     * Remueve un rango de elementos y devuelve una nueva lista con ellos.
     * <p>
     * Este método aún está en desarrollo y puede no funcionar correctamente.
     * </p>
     *
     * @param inicio Índice inicial (inclusive).
     * @param fin Índice final (exclusive).
     * @return Nueva lista con los elementos removidos.
     * @todo Completar implementación.
     */
    public List removerIntervalo(int inicio, int fin) {
        if (inicio < 0 || fin > contador || inicio >= fin) {
            throw new IndexOutOfBoundsException(Constants.INDICE_FUERA_DE_RANGO);
        }
        int cantidad = fin - inicio;
        List removidos = new List(cantidad);

        // Copiar los elementos que se eliminan
        System.arraycopy(elementos, inicio + 0, removidos.elementos, 0, cantidad);
        removidos.contador = cantidad;

        // Desplazar a la izquierda los elementos posteriores a 'fin'
        for (int i = fin; i < contador; i++) {
            elementos[i - cantidad] = elementos[i];
        }

        // Limpiar el resto
        for (int i = contador - cantidad; i < contador; i++) {
            elementos[i] = null;
        }

        contador -= cantidad;
        return removidos;
    }

    /**
     * Modifica un elemento de la lista en la posición indicada.
     *
     * @param indice El índice del elemento a modificar.
     * @param elemento El nuevo valor del elemento.
     * @throws IndexOutOfBoundsException Si el índice es negativo o mayor o
     * igual al tamaño de la lista.
     * @throws NullPointerException Si el nuevo elemento es nulo.
     */
    public void modificar(int indice, String elemento) {
        Validations.indiceAcceso(indice, contador);
        Validations.elementoNoNulo(elemento);
        elementos[indice] = elemento;
    }

    /**
     * Devuelve el número de elementos en la lista.
     *
     * @return La cantidad de elementos que contiene la lista.
     */
    public int tamaño() {
        // return elementos.length;
        return contador;
    }

    /**
     * Devuelve una representación en cadena de la lista.
     *
     * @return Una cadena que representa la lista y su total de elementos.
     */
    @Override
    public String toString() {
        final StringBuilder salida = new StringBuilder("Lista: [");
        for (int i = 0; i < contador; i++) {
            salida.append(elementos[i]);
            if (i < contador - 1) {
                salida.append(", ");
            }
        }
        salida.append("]").append("\nTotal elementos: ").append(contador);
        return salida.toString();
    }

    // @Override
    // public String toString() {
    // String salida = "[";
    // for (int i = 0; i < contador; i++) {
    // salida += elementos[i];
    // if (i < contador - 1) {
    // salida += ", ";
    // }
    // }
    // salida += "]";
    // return "Lista: " + salida + "\n"
    // + "Total elementos: " + contador + "\n";
    // }
}
