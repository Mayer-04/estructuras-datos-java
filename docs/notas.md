# Mis notas

## Conventional Commits

- **feat:** nueva funcionalidad.
- **fix:** corrección de error.
- **docs:** cambios en documentación.
- **style:** cambios de formato, sin afectar la lógica.
- **refactor:** reestructuración del código sin cambiar funcionalidad.
- **chore:** tareas varias que no afectan directamente a la app (configuración, dependencias).

- Cola circular.

```java
            // option lee el número entero pero,
            // no consume el carácter de nueva línea (\n) que queda tras pulsar Enter.
            int option = sc.nextInt();
            // evitar que un posterior nextLine() devuelva una cadena vacía
            sc.nextLine(); // Consumir ese \n y "limpiar el buffer"
```

````java
            String line = sc.nextLine();                 // leemos la línea entera
            int option;
            try {
                option = Integer.parseInt(line.trim()); // parse seguro
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Introduce un número entre 1 y 5.");
                continue;
            }
````

## Listas

- adicionar

```java
    * @throws IndexOutOfBoundsException Si el índice es negativo o mayor que el
    *                                   tamaño actual de la lista
    * @throws NullPointerException      Si el elemento a insertar es nulo
        Validations.indiceInsercion(indice, contador);
        Validations.elementoNoNulo(elemento);
```

- contiene

```java
 Validations.elementoNoNulo(elemento);
```

- obtener

```java
      Validations.indiceAcceso(indice, contador);
   Validations.elementoNoNulo(elemento);
```

- remover 

```java
IndexOutOfBoundsException

Validations.indiceAcceso(indice, contador);
```

- removerIntervalo
```java
throw new IndexOutOfBoundsException(Constants.INDICE_FUERA_DE_RANGO);
```

- modificar

```java
Validations.indiceAcceso(indice, contador);
        Validations.elementoNoNulo(elemento);
```