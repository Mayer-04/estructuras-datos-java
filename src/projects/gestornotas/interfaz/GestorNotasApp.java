package projects.gestornotas.interfaz;

import projects.gestornotas.mundo.Gestor;

import java.util.Scanner;

public class GestorNotasApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacidadMaxima, opcion, encontrado;
        int[] notas = new int[3];

        System.out.println("Ingrese la capacidad máxima del curso: ");
        capacidadMaxima = sc.nextInt();

        Gestor gestor = new Gestor(capacidadMaxima);

        // Crear un menú
        System.out.println("""
                Selecciona una opción:
                1. Insertar un estudiante:
                2. Buscar un estudiante:
                3. Insertar notas:
                4. Mostrar notas por estudiante:
                5. Mostrar la planilla de notas:
                6. Salir:
                """);

        opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> {
                // Insertar estudiante
                if (!gestor.cursoLleno()) {
                    System.out.print("Ingrese el nombre del estudiante:");
                    String nombre = sc.nextLine();
                    gestor.insertarEstudiante(nombre);
                }
            }
            case 2 -> {
                // Buscar estudiante
                System.out.print("Ingrese el nombre del estudiante:");
                String nombre = sc.nextLine();
                encontrado = gestor.buscarEstudiante(nombre);
            }
            case 3 -> {
                // Insertar notas
                System.out.print("");
                String nombre = sc.nextLine();
                System.out.println(gestor.mostrarNotasPorEstudiante(nombre));
            }
            case 4 -> {
                // Mostrar notas por estudiante
                System.out.print("");
                String nombre = sc.nextLine();
                System.out.println(gestor.mostrarNotasPorEstudiante(nombre));
            }
            case 5 -> {
            }
            case 6 -> {
                // Salir
            }
            default -> throw new AssertionError();
        }
    }
}
