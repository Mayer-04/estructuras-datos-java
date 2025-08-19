package datastructures.list;

public class Main {

    public static void main(String[] args) {
        // Lista
        var lista = new List(4);
        lista.adicionar(0, "Mayer");
        lista.adicionar(1, "Andres");
        lista.adicionar(2, "Roberto");
        lista.adicionar(3, "Kimberly");

        // Imprimir la lista original
        System.out.println(lista);

        // Modificar un elemento
        lista.modificar(2, "Lucas");

        // Obtener un elemento
        System.out.println("Obtener un elemento: " + lista.obtener(2));

        // Tamaño de la lista
        System.out.println("Tamaño de la lista: " + lista.tamaño());

        // Verificar si la lista esta vacía
        System.out.println("Verificar si la lista esta vacía: " + lista.estaVacia());
        // Buscar elemento y devolvemos su índice
        System.out.println("Índice del elemento buscado: " + lista.buscar("Roberto"));

        // Verificar si la lista contiene un elemento
        System.out.println("Verificar si la lista contiene un elemento: " + lista.contiene("Andres"));

        // Remover un elemento
        System.out.println("Elemento removido: " + lista.remover(2));

        // Imprimir la lista
        System.out.println(lista);

        // Obtener el último elemento
        System.out.println("Obtener el último elemento: " + lista.obtenerUltimo());

        // Obtener el primer elemento
        System.out.println("Obtener el primer elemento: " + lista.obtenerPrimero());

        // Vaciar la lista
        lista.vaciar();
        System.out.println("Vaciar la lista: " + lista);
    }
}
