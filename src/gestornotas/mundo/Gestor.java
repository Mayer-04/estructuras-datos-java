package gestornotas.mundo;

public class Gestor {

    private final int CAPACIDAD_MAXIMA;
    private final int[][] planilla;
    private String[] nombres;
    private int numeroEstudiantes;

    // Constructor
    public Gestor(int capacidad) {
        CAPACIDAD_MAXIMA = capacidad;
        nombres = new String[CAPACIDAD_MAXIMA];
        planilla = new int[CAPACIDAD_MAXIMA][3];
        numeroEstudiantes = 0;
    }

    public void insertarEstudiante(String nombre) {
        if (!cursoLleno()) {
            nombres[numeroEstudiantes++] = nombre;
        }
    }

    public void eliminarEstudiante(String estudiante) {
        if (estudiante == null || estudiante.isEmpty()) {
            return;
        }

        int nuevoTamaño = 0;
        for (String nombre : nombres) {
            if (!nombre.equals(estudiante)) {
                nuevoTamaño++;
            }
        }

        if (nuevoTamaño == nombres.length) {
            return;
        }

        String[] nuevoArreglo = new String[nuevoTamaño];
        int indice = 0;
        for (String nombre : nombres) {
            if (!nombre.equals(estudiante)) {
                nuevoArreglo[indice] = nombre;
                indice++;
            }
        }

        nombres = nuevoArreglo;
    }

    public boolean cursoLleno() {
        return numeroEstudiantes == CAPACIDAD_MAXIMA;
    }

    public int getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    public int buscarEstudiante(String estudiante) {
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (estudiante.equalsIgnoreCase(nombres[i])) {
                return i;
            }
        }
        return -1;
    }

    public String insertarNotas(String nombre, int[] notas) {

        int encontrado = buscarEstudiante(nombre);

        if (encontrado != -1) {
            for (int i = 0; i < notas.length; i++) {
                planilla[encontrado][i] = notas[i];
                planilla[encontrado][3] += notas[i];
            }
        } else {
            return "ERROR: El estudiante no existe";
        }

        return "Las notas se actualizaron correctamente";
    }

    public String mostrarNotasPorEstudiante(String nombre) {
        int encontrado = buscarEstudiante(nombre);
        String salida = "ERROR: El estudiante no existe";
        if (encontrado != -1) {
            salida = nombres[encontrado] + "\t";
            for (int nota : planilla[encontrado]) {
                salida += nota + "\t";
            }
        }
        return salida;
    }

    // Convierte una cadena de caracteres
    @Override
    public String toString() {
        String salida = "";
        salida += "Capacidad máxima: " + CAPACIDAD_MAXIMA + "\n";
        salida += "Cantidad de estudiantes matriculados: " + numeroEstudiantes + "\n";
        for (int i = 0; i < numeroEstudiantes; i++) {
            salida += nombres[i] + "\t";

            for (int j = 0; j < 4; j++) {
                salida += planilla[i][j] + "\t";
            }

            salida += "\n";
        }

        return salida;
    }

}
