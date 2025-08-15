package estructurasdatos.list;

public final class Validations {

    private Validations() {
        // Evita instanciación
    }

    public static void indiceAcceso(int indice, int contador) {
        if (indice < 0 || indice >= contador) {
            throw new IndexOutOfBoundsException(Constants.INDICE_FUERA_DE_RANGO);
        }
    }

    public static void indiceInsercion(int indice, int contador) {
        if (indice < 0 || indice > contador) {
            throw new IndexOutOfBoundsException(Constants.INDICE_FUERA_DE_RANGO);
        }
    }

    public static void elementoNoNulo(String elemento) {
        if (elemento == null) {
            throw new NullPointerException(Constants.ELEMENTO_NULO);
        }
    }
}
